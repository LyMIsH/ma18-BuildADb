package workspace.home.buildADb.database.writing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.home.buildADb.database.modules.TableMetadata;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MetadataWriter {
    public void write(TableMetadata metadata) throws IOException {
        File file = new File(metadata.getScheme().getDb().getDataPath());
        file.createNewFile();
        List<TableMetadata> current = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        if (file.length() != 0)
        {
            current = objectMapper.readValue(new File(metadata.getScheme().getDb().getDataPath()),
                    new TypeReference<>(){});
        }
        current.add(metadata);
        objectMapper.writeValue(file, current);
    }
}
