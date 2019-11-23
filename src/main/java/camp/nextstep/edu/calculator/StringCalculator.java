package camp.nextstep.edu.calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public int add(final String text) {
        if (isEmptyOrNull(text)) return 0;
        return 1;
    }

    private boolean isEmptyOrNull(final String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

    private String[] split(final String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER_REGEX);
    }
}
