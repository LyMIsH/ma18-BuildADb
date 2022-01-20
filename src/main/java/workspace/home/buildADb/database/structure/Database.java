package workspace.home.buildADb.database.structure;

import java.io.File;

public class Database {
    private String name;
    private String path;

    public String getName() {
        return name;
    }

    public String getPath() {
        return path + File.separator + name;
    }

    public Database(String name)
    {
        this.name = name;
        this.path = System.getProperty("user.home");
    }

    public Scheme scheme(String name)
    {
        return new Scheme(this, name);
    }
}
