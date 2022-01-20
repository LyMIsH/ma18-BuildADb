package workspace.home.buildADb.database.structure;

import workspace.home.buildADb.database.exceptions.DatabaseException;
import workspace.home.buildADb.database.exceptions.TableExistsException;
import workspace.home.buildADb.database.modules.Record;
import workspace.home.buildADb.database.modules.TableMetadata;
import workspace.home.buildADb.database.writing.TableWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private List<Record> records;
    private TableMetadata metadata;


    public String getKey() {
        return this.metadata.getKey();
    }

    public List<String> getColumnNames() {
        return this.metadata.getColumns();
    }

    public List<Record> getRecords() {
        return records;
    }

    public String getName() {
        return this.metadata.getName();
    }

    public HashMap<String, Class<?>> getTypes() {
        int count = 0;
        HashMap<String, Class<?>> map = new HashMap<>();
        for (String column: this.metadata.getColumns())
        {
            map.put(column, this.metadata.getTypes().get(count));
            count++;
        }

        return map;
    }

    public Table(String key, Scheme scheme, String name, List<String> columns, List<Class<?>> types) throws IOException {
        this.metadata = new TableMetadata(name, scheme, columns, types, key);
        this.records = new ArrayList<>();
    }

    public void load(boolean build) throws IOException, DatabaseException {
        TableWriter tableWriter = new TableWriter();
        tableWriter.write(this, build);
    }

    public TableMetadata getMetadata() {
        return metadata;
    }

    public Scheme getScheme() {
        return this.metadata.getScheme();
    }

    public void insert(Record record)
    {
        this.records.add(record);
    }

    public ArrayList<Record> get(String key, String val)
    {
        return this.get(List.of(new String[][]{{key, val}}));
    }

    public ArrayList<Record> get(List<String[]> conditions)
    {
        ArrayList<Record> matches = new ArrayList<>();
        boolean passed;

        for (Record record: this.records)
        {
            passed = true;
            for (String[] condition: conditions) {
                if (!record.getColumnValue(condition[0]).equals(condition[1])) {
                    passed = false;
                }
            }
            if(passed)
            {
                matches.add(record);
            }
        }

        return matches;
    }
    // Delete key value match.
    public void delete(String val){}

    public void delete(List<Map<String, String>> conditions){}
    // Update key value match.
    public Record update(String keyVal){return null;}

    public Record update(List<Map<String, String>> conditions){return null;}
}
