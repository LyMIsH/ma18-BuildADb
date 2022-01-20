package workspace.home.buildADb.database.structure;


import workspace.home.buildADb.database.exceptions.DatabaseException;
import workspace.home.buildADb.database.reading.TableReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Scheme {
    private Database db;
    private String name;
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public Scheme(){}

    public void setDb(Database db) {
        this.db = db;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Scheme(Database db, String name)
    {
        this.db = db;
        this.name = name;
        this.path = this.db.getPath() + File.separator + this.name;
    }

    public void addTable(String key, String name, List<String> columns, List<Class<?>> types) throws IOException, DatabaseException {
        new Table(key, this, name, columns, types).load(true);
    }

    public Table getTable(String name) throws IOException {
        TableReader tableReader = new TableReader();
        return tableReader.read(this, name);
    }
    public void deleteTable(){}

    public String getName() {
        return name;
    }
    public String getPath()
    {
        return this.path;
    }
    public Database getDb() {
        return db;
    }
}
