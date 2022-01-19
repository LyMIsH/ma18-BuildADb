package workspace.home.buildADb.database.structure;

public class Database {
    private String name;
    private String path;

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public Database(String name, String path)
    {
        this.name = name;
        this.path = path;
    }

    public Scheme scheme(String name)
    {
        return new Scheme(this, name);
    }
}
