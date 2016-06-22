package base;


import dkd.Dkd;
import foti.Foti;
import seans.Seans;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Фабрика для создания соответствующей макропрограммы
 * @see Dkd
 * @see Seans
 * @see Foti
 */
public class MacroprogrammFactory {

    private static final String SEANS_PATTERN = "^SEANS\\d+";
    private static final String FOTI_PATTERN = "^FOTI\\d+";
    private static final String DKD_PATTERN = "^DKD\\d+";

    private static Pattern pattern;
    private static Matcher matcher;

    /**
     * Метод для получения соответствующей макропрограммы
     * @param file директория макропрограммы
     * @return макропрограмма или <code>null</code>
     */

    public Macroprogramm createMacroprogramm(File file) {
        if (isSeans(file.getName())) {
            return new Seans(file.getAbsolutePath());
        }
        if (isDkd(file.getName())) {
            return new Dkd(file.getAbsolutePath());
        }
        if (isFoti(file.getName())) {
            return new Foti(file.getAbsolutePath());
        }

        return null;
    }

    private boolean isSeans(String directoryName) {
        pattern = Pattern.compile(SEANS_PATTERN, Pattern.UNICODE_CASE);
        matcher = pattern.matcher(directoryName);
        return matcher.matches();
    }

    private boolean isDkd(String directoryName) {
        pattern = Pattern.compile(DKD_PATTERN, Pattern.UNICODE_CASE);
        matcher = pattern.matcher(directoryName);
        return matcher.matches();
    }

    private boolean isFoti(String directoryName) {
        pattern = Pattern.compile(FOTI_PATTERN, Pattern.UNICODE_CASE);
        matcher = pattern.matcher(directoryName);
        return matcher.matches();
    }
}
