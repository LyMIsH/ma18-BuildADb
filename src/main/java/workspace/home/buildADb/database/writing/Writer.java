package workspace.home.buildADb.database.writing;

import workspace.home.buildADb.database.structure.Table;

import java.io.IOException;

public interface Writer {
    void write(Table table) throws IOException;
}
