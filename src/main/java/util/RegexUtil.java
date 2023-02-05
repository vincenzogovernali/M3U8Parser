package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    public static String checkRegex(String toCheck, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(toCheck);
        if (m.find()) {
            return m.group();
        } else {
            return null;
        }
    }

}
