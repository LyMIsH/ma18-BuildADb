package workspace.home.buildADb.database;

public class Database {
    private String name;
    private String path;

    public void addScheme(String name)
    {
        // Build new Scheme(this, name);
    }

    public Database(String name, String path)
    {
        this.name = name;
        this.path = path;
    }

    public Scheme getScheme(String name)
    {
        return new Scheme(this, name);
    }
}
