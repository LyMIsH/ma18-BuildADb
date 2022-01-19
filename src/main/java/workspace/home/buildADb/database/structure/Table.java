package workspace.home.buildADb.database.structure;

import workspace.home.buildADb.database.modules.Record;
import workspace.home.buildADb.database.writing.TableWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Table {
    List<String> columns;
    List<Record> records;
    Scheme scheme;
    String key;
    String name;

    public String getKey() {
        return key;
    }

    public List<String> getColumnNames() {
        return columns;
    }

    public List<Record> getRecords() {
        return records;
    }

    public String getName() {
        return name;
    }

    public Table(Scheme scheme, String name) throws IOException {
        this.name = name;
        this.scheme = scheme;
        this.columns = new ArrayList<>();
        this.records = new ArrayList<>();

        TableWriter tableWriter = new TableWriter();
        tableWriter.write(this);
    }

    public Scheme getScheme() {
        return scheme;
    }

    public void insert(Record record){};

    public Record get(String keyVal){return null;}
    // Delete key value match.
    public void delete(String val){}

    public void delete(List<Map<String, String>> conditions){}
    // Update key value match.
    public Record update(String keyVal){return null;}

    public Record update(List<Map<String, String>> conditions){return null;}
}
