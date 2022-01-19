package workspace.home.buildADb.database.writing;

import workspace.home.buildADb.database.structure.Database;
import workspace.home.buildADb.database.structure.Scheme;
import workspace.home.buildADb.database.structure.Table;

public class TableWriter implements Writer {

    @Override
    public void write(Table table) {
        Scheme scheme = table.getScheme();
        Database db = scheme.getDb();

        db.getPath();
    }
}
