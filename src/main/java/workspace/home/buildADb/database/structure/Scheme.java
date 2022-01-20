package workspace.home.buildADb.database.structure;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class Scheme {
    private Database db;
    private String name;

    public Scheme(Database db, String name)
    {
        this.db = db;
        this.name = name;
    }

    public Table addTable(String key, String name, List<String> columns) throws IOException {
        return new Table(key, this, name, columns);
    }

    public Table getTable(String name){return null;}
    public void deleteTable(){}

    public String getName() {
        return name;
    }
    public String getPath()
    {
        return this.db.getPath() + File.separator + this.name;
    }
    public Database getDb() {
        return db;
    }
}
