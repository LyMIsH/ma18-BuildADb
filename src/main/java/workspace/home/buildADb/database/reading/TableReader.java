package workspace.home.buildADb.database.reading;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import workspace.home.buildADb.database.exceptions.DatabaseException;
import workspace.home.buildADb.database.modules.Record;
import workspace.home.buildADb.database.modules.TableMetadata;
import workspace.home.buildADb.database.modules.TableValue;
import workspace.home.buildADb.database.structure.Scheme;
import workspace.home.buildADb.database.structure.Table;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class TableReader {
    public Table read(Scheme scheme, String name) throws IOException, DatabaseException {
        Reader in = new FileReader(scheme.getPath() + File.separator + name + ".csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
        TableMetadata metadata = scheme.getTableMetaData(name);
        Table table = new Table(metadata.getKey(), metadata.getScheme(),
                name, metadata.getColumns(), metadata.getTypes());
        boolean firstLine = true;

        for (CSVRecord record: records)
        {
            if (firstLine)  // Already have the first line in metadata.
            {
                firstLine = false;
            }
            else
            {
                Record newRecord = this.getRecordObject(record, table);
                table.insert(newRecord);
            }
        }

        return table;
    }

    private Record getRecordObject(CSVRecord record, Table table)
    {
        Record recordObj = new Record(table);
        int count = 0;

        for (String column: table.getColumnNames())
        {
            Class<?> type = table.getTypes().get(column);
            recordObj.addValue(column, this.cast(type, record.get(count)).value);
            count++;
        }
        return recordObj;
    }

    private TableValue<?> cast(Class<?> type, String item) {
        HashMap<Class<?>, Callable<?>> parser = new HashMap<>();
        parser.put(int.class, () -> Integer.parseInt(item));
        parser.put(String.class, () -> item);
        parser.put(Date.class, () -> DateTimeFormatter.ofPattern(item));
        try
        {
            if (!item.isEmpty())
            {
                parser.get(type).call();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return new TableValue<>(item);
    }
}
