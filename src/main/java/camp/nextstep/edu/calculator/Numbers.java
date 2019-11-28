package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Numbers {
    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static Numbers intValuesOf(final String[] separatedText) {
        final List<Number> numbers = new ArrayList<>(separatedText.length);
        for (String text : separatedText) {
            numbers.add(Number.intValueOf(text));
        }
        return new Numbers(numbers);
    }

    public Number sum() {
        int sum = 0;
        for (Number number : numbers) {
            sum += number.getValue();
        }
        return Number.intValueOf(String.valueOf(sum));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
