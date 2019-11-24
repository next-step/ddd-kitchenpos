package camp.nextstep.edu.calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern customDelimiter = Pattern.compile("//(.)\\n(.*)");

    public int add(String input) {
        if (isEmptyString(input)) {
            return 0;
        }

        String[] numbers = split(input);

        return getSum(numbers);
    }

    private String[] split(String input) {
        String delimiter = "\\,|\\:";

        Matcher matcher = customDelimiter.matcher(input);

        if (matcher.find()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }

        return input.split(delimiter);
    }

    private int getSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += getPositiveNumber(number);
        }
        return sum;
    }

    private int getPositiveNumber(String number) {
        int parsedNumber = Integer.parseInt(number);

        if (parsedNumber < 0) {
            throw new RuntimeException();
        }

        return parsedNumber;
    }

    private boolean isEmptyString(String str) {
        return Objects.isNull(str) || str.isEmpty();
    }

}
