package emobi.utilities;

import java.io.IOException;
import java.util.Properties;

public class ConfigSettings {
    public static final String API_KEY = "apikey";

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

    public void setConfigProperties(Properties configProperties) {
        this.configProperties = configProperties;
    }
}
