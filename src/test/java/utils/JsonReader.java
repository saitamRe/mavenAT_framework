package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class JsonReader {
    public static List<HashMap<String, String>> getJsonDataToMap(String fileName) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"), "src", "test", "java", "data", fileName);
        String content = FileUtils.readFileToString(path.toFile(), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<List<HashMap<String, String>>>() {
        });


    }
}
