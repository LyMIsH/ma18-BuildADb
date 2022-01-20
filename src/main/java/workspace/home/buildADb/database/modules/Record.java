package workspace.home.buildADb.database.modules;

import workspace.home.buildADb.database.structure.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Record {
    List<String> columns;
    Map<String, String> values;

    public Record(Table table) {
        this.columns = table.getColumnNames();
        this.values = new HashMap<>();
    }

    public Record(Table table, List<TableValue<?>> values)
    {
        this.columns = table.getColumnNames();
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
        TableValue<T> tableValue = new TableValue<>(value);
        this.values.put(name, tableValue.value.toString());
    }

    public String getColumnValue(String column)
    {
        return this.values.get(column);
    }
    public void setColumnValue(String column, String val)
    {
        this.values.put(column, val);
    }

    public ArrayList<String> getRecordValues()
    {
        ArrayList<String> sortedValues = new ArrayList<>();
        for (String column: this.columns)
        {
            sortedValues.add(this.values.get(column));
        }
        return sortedValues;
    }
}
