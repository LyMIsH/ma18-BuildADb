package workspace.home.buildADb.database.writing;

import workspace.home.buildADb.database.modules.Record;
import workspace.home.buildADb.database.structure.Scheme;
import workspace.home.buildADb.database.structure.Table;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TableWriter implements Writer {

    @Override
    public void write(Table table) throws IOException {
        Scheme scheme = table.getScheme();
        FileWriter file = new FileWriter(scheme.getDb().getPath());

        file.append(String.join(",", table.getColumnNames()));
        for (Record record: table.getRecords())
        {
            file.append(String.join(",", record.getRecordValues()));
            file.flush();
        }
        file.close();
    }
}
