package workspace.home.buildADb.database.exceptions;

import java.io.IOException;

public class TableExistsException extends IOException {
    public TableExistsException(String msg)
    {
        super(msg);
    }
}
