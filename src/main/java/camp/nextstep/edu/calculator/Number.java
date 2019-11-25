package camp.nextstep.edu.calculator;

import java.util.Objects;

public final class Number {
    public static final int ZERO_VALUE = 0;
    private int value;

    private Number(final int number) {
        if (isNegative(number)) {
            throw new RuntimeException(String.format(Constants.RUNTIME_EXCEPTION_MESSAGE, number));
        }
        this.value += number;
    }

    public static Number intValueOf(final String text) {
        int number = Integer.parseInt(text);
        return new Number(number);
    }

    private boolean isNegative(int number) {
        return number < ZERO_VALUE;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}