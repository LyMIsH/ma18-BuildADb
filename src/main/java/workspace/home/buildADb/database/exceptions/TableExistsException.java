package workspace.home.buildADb.database.exceptions;

import java.io.IOException;

public class TableExistsException extends DatabaseException {

    public TableExistsException(String msg) {
        super(msg);
    }
}
