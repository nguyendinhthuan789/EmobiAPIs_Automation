package emobi.apis.config;

import java.io.IOException;
import java.util.Properties;

public class ConfigSettings {
    public static final String API_KEY = "apikey";
    public static final String DEV_ENV_PARNER_DOMAIN = "env.dev.partner";
    public static final String DEV_ENV_LPAS_DOMAIN = "env.dev.lpas";
    public static final String ENV_DEFAULT = "env.default";

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

    public String getDevEnvParnerDomain(){
        return configProperties.getProperty(DEV_ENV_PARNER_DOMAIN);
    }

    public String getDevEnvLpasDomain(){
        return configProperties.getProperty(DEV_ENV_LPAS_DOMAIN);
    }

    public String getEnvDefault(){
        return configProperties.getProperty(ENV_DEFAULT);
    }

    public void setConfigProperties(Properties configProperties) {
        this.configProperties = configProperties;
    }
}
