package emobi.utilities;

import java.io.IOException;
import java.util.Properties;

public class ConfigSettings {
    public static final String API_KEY = "apikey";
    private static final String DATA_FILE = "data_file";

    private Properties configProperties;

    public ConfigSettings(String projectDirLocation) {
        try {
            setConfigProperties(PropertySettingStoreUtil.getSettings(projectDirLocation, ConfigSettings.class.getSimpleName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getApiKey() {
        return configProperties.getProperty(API_KEY);
    }

    public String getDataFile() {
        return this.configProperties.getProperty(DATA_FILE);
    }

    public void setConfigProperties(Properties configProperties) {
        this.configProperties = configProperties;
    }
}
