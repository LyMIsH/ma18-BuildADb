package workspace.home.buildADb.database.modules;

import java.util.ArrayList;
import java.util.Map;

public class Record {
    Map<String, String> values;

    public <T> void addValue(String name, T value)
    {
        this.values.put(name, value.toString());
    }

    public String getColumnValue(String column)
    {
        return this.values.get(column);
    }
    public ArrayList<String> getRecordValues()
    {
        return new ArrayList<>(this.values.values());
    }
}
