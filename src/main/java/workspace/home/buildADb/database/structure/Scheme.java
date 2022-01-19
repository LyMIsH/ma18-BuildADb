package workspace.home.buildADb.database.structure;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scheme {
    private Database db;
    private String name;

    public Scheme(Database db, String name)
    {
        this.db = db;
        this.name = name;
    }

    public void addTable(String key, String name, List<String> columns) throws IOException {
        new Table(key, this, name, columns);
    }

    public Table getTable(String name){return null;}
    public void deleteTable(){}

    public String getName() {
        return name;
    }

    public Database getDb() {
        return db;
    }
}
