package workspace.home.buildADb;

import workspace.home.buildADb.database.structure.Database;

public class Main {
    public static void main(String[] args) {
        Database db = new Database("Test", "src/main/resources");
        db.scheme("SchemeTest").addTable("Test");
    }
}
