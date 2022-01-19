package workspace.home.buildADb.database.exceptions;

public class TableExistsException extends Exception{
    public TableExistsException(String msg)
    {
        super(msg);
    }
}
