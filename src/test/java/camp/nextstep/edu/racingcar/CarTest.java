package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차 생성")
    @ParameterizedTest
    @ValueSource(strings = {"aa", "bbb", "cccc", "dddd"})
    void ParameterizedCarTest(final String name) {
        new Car(name, 1);
    }

    @DisplayName("자동차 위치 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 100})
    void isInPosition(final int position) {
        final Car car = new Car("name", position);
        assertThat(car.isInPosition(position)).isTrue();
    }

    @Test
    void move() {
        final Car car = new Car("keum", 0);
        car.move(new TestMovingStrategy());
        assertThat(car.isInPosition(1)).isTrue();
    }

    class TestMovingStrategy implements MovingStrategy {
        @Override
        public boolean movable() {
            return true;
        }
    }

}
