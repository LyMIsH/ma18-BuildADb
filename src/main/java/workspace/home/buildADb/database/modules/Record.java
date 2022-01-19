package workspace.home.buildADb.database.modules;

import java.util.Map;

public class Record> {
    Map<String, ?> values;

    public <T> void addValue(String name, T value)
    {
        this.values.put(name,value);
    }
}
