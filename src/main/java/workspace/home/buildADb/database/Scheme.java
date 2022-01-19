package workspace.home.buildADb.database;


public class Scheme<T> {
    private Database<T> db;
    private String name;

    public Scheme(Database<T> db, String name)
    {
        this.db = db;
        this.name = name;
    }

    public void addTable(String name){}
    public Table<T> getTable(){return null;}
    public void deleteTable(){}
}
