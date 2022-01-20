package workspace.home.buildADb;

import workspace.home.buildADb.database.exceptions.DatabaseException;
import workspace.home.buildADb.database.exceptions.TableExistsException;
import workspace.home.buildADb.database.modules.Record;
import workspace.home.buildADb.database.modules.TableValue;
import workspace.home.buildADb.database.structure.Database;
import workspace.home.buildADb.database.structure.Table;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database db = new Database("Test");
        try {
            db.scheme("SchemeTest1").addTable("ID", "Test", List.of("ID", "Name", "Age", "Hobie"));
            Table table = db.scheme("SchemeTest1").getTable("Test");
            Record record = new Record(table, List.of(new TableValue<>(5), new TableValue<>("Ron")));
            table.insert(record);
            table.load(false);
            table = db.scheme("SchemeTest1").getTable("Test");
            record.addValue("ID", 5);
            record.addValue("Name", "Ron");
            table.insert(record);
            table.load(false);
            db.scheme("SchemeTest2").addTable("ID", "Test", List.of("ID", "Name", "Age", "Hobie"));
        } catch (IOException | DatabaseException e) {
            e.printStackTrace();
        }
    }
}
