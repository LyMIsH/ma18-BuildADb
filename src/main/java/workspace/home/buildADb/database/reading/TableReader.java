package workspace.home.buildADb.database.reading;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import workspace.home.buildADb.database.modules.Record;
import workspace.home.buildADb.database.modules.TableMetadata;
import workspace.home.buildADb.database.modules.TableValue;
import workspace.home.buildADb.database.structure.Scheme;
import workspace.home.buildADb.database.structure.Table;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TableReader {
    public Table read(Scheme scheme, String name) throws IOException {
        Reader in = new FileReader(scheme.getPath() + File.separator + name + ".csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
        TableMetadata metadata = scheme.getTableMetaData(name);
        Table table = new Table(metadata.getKey(), metadata.getScheme(),
                name, metadata.getColumns(), metadata.getTypes());

        for (CSVRecord record: records)
        {
            Record newRecord = this.getRecordObject(record, table);
            table.insert(newRecord);
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
            TableValue<?> value = new TableValue<>(type.cast(record.get(count)));
            recordObj.addValue(column, value);
            count++;
        }
        return recordObj;
    }
}
