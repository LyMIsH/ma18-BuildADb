package workspace.home.buildADb.database.modules;

import java.util.Map;

public class Record<T> {
    Map<String, T> values;

    public void addValue(String name, T value)
    {
        this.values.put(name, value);
    }
}
