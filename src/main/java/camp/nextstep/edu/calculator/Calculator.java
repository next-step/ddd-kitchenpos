package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    private static final Pattern customDelimiter = Pattern.compile("//(.)\\n(.*)");

    private static final String DEFAULT_DELIMITER_REGEX = "\\,|\\:";

    public int add(String input) {
        if (isEmptyString(input)) {
            return 0;
        }

        List<Number> numbers = Arrays.stream(split(input))
                .map(Number::of)
                .collect(Collectors.toList());

        return getSum(numbers);
    }

    private String[] split(String input) {
        String delimiter = DEFAULT_DELIMITER_REGEX;

        Matcher matcher = customDelimiter.matcher(input);

        if (matcher.find()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }

        return input.split(delimiter);
    }

    private int getSum(List<Number> numbers) {
        return numbers.stream()
                .mapToInt(Number::getNumber)
                .sum();
    }

    private boolean isEmptyString(String str) {
        return Objects.isNull(str) || str.isEmpty();
    }

}
