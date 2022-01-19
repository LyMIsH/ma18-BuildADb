package workspace.home.buildADb;

import workspace.home.buildADb.database.structure.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database db = new Database("Test", "e:/dbTest");
        try {
            db.scheme("SchemeTest").addTable("ID", "Test", List.of("ID", "Name", "Age", "Hobie"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
