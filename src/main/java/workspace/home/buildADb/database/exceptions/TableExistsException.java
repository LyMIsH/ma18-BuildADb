package workspace.home.buildADb.database.exceptions;


public class TableExistsException extends DatabaseException {

    public TableExistsException(String msg) {
        super(msg);
    }
}
