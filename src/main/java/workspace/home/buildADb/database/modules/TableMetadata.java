package workspace.home.buildADb.database.modules;

import workspace.home.buildADb.database.structure.Scheme;

import java.util.List;

public class TableMetadata {
    private String name;
    private Scheme scheme;
    private List<String> columns;
    private List<Class<?>> types;
    private String key;

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public String getName() {
        return name;
    }

    public Scheme getScheme() {
        return scheme;
    }

    public List<Class<?>> getTypes() {
        return types;
    }

    public String getKey() {
        return key;
    }

    public TableMetadata(){}

    public TableMetadata(String name, Scheme scheme, List<String> columns, List<Class<?>> types, String key) {
        this.name = name;
        this.scheme = scheme;
        this.columns = columns;
        this.types = types;
        this.key = key;
    }
}
