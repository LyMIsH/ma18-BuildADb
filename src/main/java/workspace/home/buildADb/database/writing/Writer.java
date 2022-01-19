package workspace.home.buildADb.database.writing;

import workspace.home.buildADb.database.structure.Table;

public interface Writer {
    void write(Table table);
}
