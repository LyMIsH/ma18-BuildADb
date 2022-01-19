package workspace.home.buildADb.database;

import workspace.home.buildADb.database.modules.Record;

import java.util.List;
import java.util.Map;

public class Table<T> {
    List<String> column;
    List<Record<T>> records;
    Scheme<T> scheme;
    String key;
    String name;

    public void insert(Record<T> record){};

    public Record<T> get(String keyVal){return null;}
    // Delete key value match.
    public void delete(String val){}

    public void delete(List<Map<String, T>> conditions){}
    // Update key value match.
    public Record<T> update(String keyVal){return null;}
    
    public Record<T> update(List<Map<String, T>> conditions){return null;}
}
