package workspace.home.buildADb.database;


public class Scheme {
    private Database db;
    private String name;

    public Scheme(Database db, String name)
    {
        this.db = db;
        this.name = name;
    }

    public void addTable(String name){}
    public Table getTable(){return null;}
    public void deleteTable(){}
}
