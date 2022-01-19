package workspace.home.buildADb.database;

import workspace.home.buildADb.database.modules.Record;

import java.util.List;

public class Table {
    List<String> column;
    List<Record> records;
    Scheme scheme;
    String key;
    String name;

    public void insert(Record record){};
    public Record get(String keyVal){return null;}
}
