package workspace.home.buildADb.database.reading;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import workspace.home.buildADb.database.modules.Record;
import workspace.home.buildADb.database.modules.TableValue;
import workspace.home.buildADb.database.structure.Scheme;
import workspace.home.buildADb.database.structure.Table;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class TableReader {
    public Table read(Scheme scheme, String name) throws IOException {
        Table table = null;
        Reader in = new FileReader(scheme.getPath() + File.separator + name + ".csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
        boolean firstLine = true;

        for (CSVRecord record: records)
        {
            if (!firstLine)
            {
                List<TableValue<?>> values = new ArrayList<>();
            }
            else
            {
                //table = new Table("key", scheme, name, record.toList());
                firstLine = false;
            }
        }

        return table;
    }

/*
    private Record getRecordObject(CSVRecord record, List<String> columns)
    {

    }*/
}
