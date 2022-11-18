package utils;

import helper.Constants;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {
    private String result = "";
    private InputStream inputStream;

    public String getProperty(String key) {
        try {
            Properties properties = new Properties();
            String propFileName = Constants.PROP_FILE_NAME;

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if(inputStream != null){
                properties.load(inputStream);
            }
            else {
                throw new FileNotFoundException(Constants.PROP_FILE_NOT_FOUND_MESSAGE);
            }
            this.result = properties.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
