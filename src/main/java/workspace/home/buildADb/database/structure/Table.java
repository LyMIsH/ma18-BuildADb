package workspace.home.buildADb.database.structure;

import workspace.home.buildADb.database.exceptions.DatabaseException;
import workspace.home.buildADb.database.exceptions.TableExistsException;
import workspace.home.buildADb.database.modules.Record;
import workspace.home.buildADb.database.modules.TableMetadata;
import workspace.home.buildADb.database.writing.TableWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Table {
    private List<String> columns;
    private List<Record> records;
    private TableMetadata metadata;


    public String getKey() {
        return this.metadata.getKey();
    }

    public List<String> getColumnNames() {
        return columns;
    }

    public List<Record> getRecords() {
        return records;
    }

    public String getName() {
        return this.metadata.getName();
    }

    public List<Class<?>> getTypes() {
        return this.metadata.getTypes();
    }

    public Table(String key, Scheme scheme, String name, List<String> columns, List<Class<?>> types) throws IOException {
        this.metadata = new TableMetadata(name, scheme, types, key);
        this.columns = new ArrayList<>(columns);
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

    public Record get(String keyVal){return null;}
    // Delete key value match.
    public void delete(String val){}

    public void delete(List<Map<String, String>> conditions){}
    // Update key value match.
    public Record update(String keyVal){return null;}

    public Record update(List<Map<String, String>> conditions){return null;}
}
