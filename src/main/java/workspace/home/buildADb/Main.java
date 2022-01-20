package workspace.home.buildADb;

import workspace.home.buildADb.database.exceptions.DatabaseException;
import workspace.home.buildADb.database.exceptions.TableExistsException;
import workspace.home.buildADb.database.modules.Record;
import workspace.home.buildADb.database.modules.TableValue;
import workspace.home.buildADb.database.structure.Database;
import workspace.home.buildADb.database.structure.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database db = new Database("Db");
        try {
            db.scheme("SchemeTest1").addTable("ID", "Test", List.of("ID", "Name", "Age", "Hobie"),
                    List.of(int.class, String.class, int.class, String.class));
            Table table = db.scheme("SchemeTest1").getTable("Test");
            Record record = new Record(table, List.of(new TableValue<>(5), new TableValue<>("Ron")));
            table.insert(record);
            table.load(false);
            table = db.scheme("SchemeTest1").getTable("Test");
            ArrayList<Record> result = table.get("Name", "Ron");
            record.addValue("Age", 95);
            record.addValue("Hobie", "Friends");
            table.insert(record);
            table.load(false);
            db.scheme("SchemeTest2").addTable("ID", "Test", List.of("ID", "Name", "Age", "Hobie"),
                    List.of(int.class, String.class, int.class, String.class));
        } catch (IOException | DatabaseException e) {
            e.printStackTrace();
        }
    }
}
