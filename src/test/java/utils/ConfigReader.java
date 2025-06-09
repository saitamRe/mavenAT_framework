package utils;

import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    private static final Properties props = new Properties();

    static {
        File file = Paths.get(System.getProperty("user.dir"), "src", "test", "java", "resources", "globalData.properties").toFile();
        try (FileInputStream fis = new FileInputStream(file)) {
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key)
    {
        return System.getProperty(key, props.getProperty(key));
    }
}
