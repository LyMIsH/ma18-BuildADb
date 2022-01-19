package workspace.home.buildADb.database;

public class Database<T> {
    private String name;
    private String path;

    public Database(String name, String path)
    {
        this.name = name;
        this.path = path;
    }

    public Scheme<T> scheme(String name)
    {
        return new Scheme<>(this, name);
    }
}
