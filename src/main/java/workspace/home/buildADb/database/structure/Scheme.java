package workspace.home.buildADb.database.structure;


public class Scheme {
    private Database db;
    private String name;

    public Scheme(Database db, String name)
    {
        this.db = db;
        this.name = name;
    }

    public void addTable(String name){}
    public Table getTable(String name){return null;}
    public void deleteTable(){}

    public String getName() {
        return name;
    }

    public Database getDb() {
        return db;
    }
}
