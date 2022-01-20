package workspace.home.buildADb.database.writing;

import workspace.home.buildADb.database.modules.Record;
import workspace.home.buildADb.database.structure.Scheme;
import workspace.home.buildADb.database.structure.Table;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TableWriter {

    public void write(Table table, boolean build) throws IOException {
        Scheme scheme = table.getScheme();
        String path = scheme.getPath();
        File dir = new File(path);

        dir.mkdirs();
        path += '/' + table.getName() + ".csv";
        FileWriter file = new FileWriter(path, !build);  // If we build a new table, do not append.
        BufferedWriter bw = new BufferedWriter(file);
        bw.write(String.join(",", table.getColumnNames()));
        bw.newLine();

        for (Record record: table.getRecords())
        {
            bw.write(String.join(",", record.getRecordValues()));
            bw.newLine();
        }
        bw.close();
    }
}
