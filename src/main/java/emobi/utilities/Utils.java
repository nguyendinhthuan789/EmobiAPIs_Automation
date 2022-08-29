package emobi.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Utils {
    private static Logger log = LoggerFactory.getLogger(Utils.class);

    public Utils() {

    }

    /**
     * Get integer
     *
     * @param number Object
     * @return Integer
     */
    public static Integer getInt(Object number) {
        if (number instanceof BigDecimal)
            return ((BigDecimal) number).intValue();
        else if (number instanceof Integer) {
            return (Integer) number;
        } else {
            return new BigDecimal((String) number).intValue();
        }
    }

    /**
     * Get double
     *
     * @param number Object
     * @return Double
     */
    public static Double getDouble(Object number) {
        if (number instanceof BigDecimal)
            return ((BigDecimal) number).doubleValue();
        else if (number instanceof Double) {
            return (Double) number;
        } else {
            return new BigDecimal((String) number).doubleValue();
        }
    }

    /**
     * Get Long
     *
     * @param number Object
     * @return Long
     */
    public static Long getLong(Object number) {
        if (number instanceof BigDecimal)
            return ((BigDecimal) number).longValue();
        else if (number instanceof Double) {
            return (Long) number;
        } else {
            return new BigDecimal((String) number).longValue();
        }
    }

    /**
     * Return timestamps
     *
     * @param ts1 format timestamps
     * @return long
     */
    public long TimeStamps(long ts1) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long ts = timestamp.getTime();
        return ts;
    }

    public static LocalDateTime localDateTime() {
        return Instant.now()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static Date date() {
        Date date = new Date();
        return date;
    }

    public static boolean isJSONValid(String jsonInString) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(jsonInString);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void isSnakeStrategy() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

    public static String serializeAsJsonString(Object object) throws IOException {
        ObjectMapper objMapper = new ObjectMapper();
        objMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        StringWriter sw = new StringWriter();
        objMapper.writeValue(sw, object);
        return sw.toString();
    }

    public static String serializeAsJsonString(Object object, boolean indent) throws IOException {
        ObjectMapper objMapper = new ObjectMapper();
        if (indent == true) {
            objMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        }
        StringWriter stringWriter = new StringWriter();
        objMapper.writeValue(stringWriter, object);
        return stringWriter.toString();
    }

    public static <T> T jsonStringToObject(String content, Class<T> clazz) throws IOException {
        T obj = null;
        ObjectMapper objMapper = new ObjectMapper();
        obj = objMapper.readValue(content, clazz);
        return obj;
    }

    public static List<String> generateListString(List<List<String>> list) {
        List<String> result = list.stream()
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());
        return result;
    }

    public static List<String> generateListofListString1(List<List<String>> list) { //[[a], [b]].
        List<String> result = list.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return result;
    }

    public void deleteFolder(String path) {
        try {
            if (!path.isEmpty()) {
                FileUtils.deleteDirectory(new File(path));
                log.info("Folder '" + path + "' deleted successfully!");
            } else {
                log.info("Folder '" + path + "' has been deleted successfully!");
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            log.info("Folder '" + path + "' deleted Failed!");
        }
    }

    public static void createEnvironmentProperties(String filePath) {
        Properties prop = new Properties();
        // set the properties value
        prop.setProperty("Domain", "http://dev.api.emobi-sys.com:8091/v1");
        try {
            PropertySettingStoreUtil.saveSettings(prop, filePath,"");
            log.info(
                    "Class Utils | Method createEnvironmentProperties | saveSettings : " + prop + " | "
                            + filePath);
        } catch (IOException e) {
            log.error(
                    "Class Utils | Method createEnvironmentProperties | Exception desc : " + e.getMessage());
        }
    }
}
