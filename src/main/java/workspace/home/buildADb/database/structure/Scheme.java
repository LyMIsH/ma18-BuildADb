package workspace.home.buildADb.database.structure;


import workspace.home.buildADb.database.exceptions.DatabaseException;
import workspace.home.buildADb.database.exceptions.TableExistsException;
import workspace.home.buildADb.database.writing.TableReader;

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

    public void addTable(String key, String name, List<String> columns) throws IOException, DatabaseException {
        new Table(key, this, name, columns).load(true);
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
        return this.db.getPath() + File.separator + this.name;
    }
    public Database getDb() {
        return db;
    }
}
