package workspace.home.buildADb.database.structure;

import java.io.File;

public class Database {
    private String name;
    private String path;
    private String dataPath;

    public String getName() {
        return name;
    }

    public String getPath() {
        return path + File.separator + name;
    }

    public String getDataPath() {
        return dataPath;
    }

    public Database(){}

    public Database(String name)
    {
        this.name = name;
        this.path = System.getProperty("user.home");
        this.dataPath = this.getPath() + File.separator + "db_data.json";
    }

    public Scheme scheme(String name)
    {
        return new Scheme(this, name);
    }
}
