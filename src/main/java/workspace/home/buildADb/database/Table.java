package workspace.home.buildADb.database;

import workspace.home.buildADb.database.modules.Record;

import java.util.List;
import java.util.Map;

public class Table {
    List<String> column;
    List<Record> records;
    Scheme scheme;
    String key;
    String name;

    public void insert(Record record){};

    public Record get(String keyVal){return null;}
    // Delete key value match.
    public void delete(String val){}

    public void delete(List<Map<String, String>> conditions){}
    // Update key value match.
    public Record update(String keyVal){return null;}

    public Record update(List<Map<String, String>> conditions){return null;}
}
