package workspace.home.buildADb.database.modules;

import workspace.home.buildADb.database.structure.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Record {
    Map<String, String> values;

    public Record(Table table, List<TableValue<?>> values)
    {
        this.values = new HashMap<>();
        int count = 0;

        for (String column: table.getColumnNames())
        {
            if (count >= values.size())
            {
                this.values.put(column, "");
            }
            else
            {
                this.values.put(column, values.get(count).value.toString());
            }
            count++;
        }
    }

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
