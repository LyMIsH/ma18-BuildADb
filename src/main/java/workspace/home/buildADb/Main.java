package workspace.home.buildADb;

import workspace.home.buildADb.database.structure.Database;
import workspace.home.buildADb.database.structure.Table;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database db = new Database("Test");
        try {
            Table table = db.scheme("SchemeTest1").addTable("ID", "Test", List.of("ID", "Name", "Age", "Hobie"));
            db.scheme("SchemeTest2").addTable("ID", "Test", List.of("ID", "Name", "Age", "Hobie"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
