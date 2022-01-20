package workspace.home.buildADb.database.writing;

import workspace.home.buildADb.database.exceptions.TableExistsException;
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
        path += File.separator + table.getName() + ".csv";
        if ((new File(path)).exists() && build)
        {
            throw new TableExistsException("Table '" + path + "' already exists");
        }
        FileWriter file = new FileWriter(path, true);
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
