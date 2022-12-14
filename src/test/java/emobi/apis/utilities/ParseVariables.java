package emobi.apis.utilities;

import emobi.apis.exceptions.CommonException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseVariables {
    /**
     * This method is to
     * - Check string contain System environment (pattern ${varName})
     * - Get value from System Variables
     * - Replace pattern String by that value
     *
     * @param text
     * @return
     * @throws CommonException
     */
    public static String parseVariables(String text) throws CommonException {
        String regex = "\\$\\{([^\\\\$\\\\]+)\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        String returnString = text;
        while (matcher.find()) {
            String replacedString = matcher.group(0);
            String key = matcher.group(1);
            String replaceValue = System.getProperty(key);
            if (replaceValue == null || replaceValue.isEmpty()) {
                throw new CommonException("Variable variable with name " + key + " is not passed to execute.");
            }
            returnString = returnString.replace(replacedString, replaceValue);
        }
        return returnString;
    }
}
