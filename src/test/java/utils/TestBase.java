package utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;


public class TestBase {
    public static String getProperty(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") +
                "/src/main/resources/config.properties");
        properties.load(fileInputStream);
        System.out.println(properties.getProperty(key));
        return properties.getProperty(key);

    }

}
