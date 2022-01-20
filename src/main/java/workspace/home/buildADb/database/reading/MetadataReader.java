package workspace.home.buildADb.database.reading;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.home.buildADb.database.exceptions.DatabaseException;
import workspace.home.buildADb.database.exceptions.TableExistsException;
import workspace.home.buildADb.database.modules.TableMetadata;
import workspace.home.buildADb.database.structure.Scheme;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MetadataReader {
    public TableMetadata read(Scheme scheme, String name) throws DatabaseException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<TableMetadata> dataList = objectMapper.readValue(new File(scheme.getDb().getDataPath()),
                new TypeReference<>(){});
        dataList = dataList.stream().filter(item -> item.getName().equals(name) &&
                item.getScheme().getName().equals(scheme.getName())).toList();
        if (dataList.size() == 0)
        {
            throw new TableExistsException("Scheme does not contain this table");
        }
        return dataList.get(0);
    }
}
