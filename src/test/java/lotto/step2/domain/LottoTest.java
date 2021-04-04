package lotto.step2.domain;

import lotto.step1.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("잘못된 범위의 수가 들어왔을 경우 exception 테스트")
    @ParameterizedTest
    @MethodSource("generateOutOfRangeLottoData")
    void outOfRangeNumberTest(List<Integer> numbers) {
        assertThatThrownBy(() -> {
            Lotto.of(numbers);
        }).isInstanceOf(RuntimeException.class);
    }
    private static Stream<Arguments> generateOutOfRangeLottoData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 0)),
                Arguments.of(Arrays.asList(1, 9, 2, 3, 4, 46)),
                Arguments.of(Arrays.asList(1, 9, 2, 3, 4, 97)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 0))
        );
    }

    @DisplayName("숫자가 적거나 많게 들어온 경우 exception 테스트")
    @ParameterizedTest
    @MethodSource("generateInvalidLottoData")
    void invalidNumberTest(List<Integer> numbers) {
        assertThatThrownBy(() -> {
            Lotto.of(numbers);
        }).isInstanceOf(RuntimeException.class);
    }
    private static Stream<Arguments> generateInvalidLottoData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 3, 2)),
                Arguments.of(Arrays.asList(1, 6, 2, 3, 4, 5, 7)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 9, 11, 12))
        );
    }

    @DisplayName("숫자가 중복되게 들어온 경우 exception 테스트")
    @ParameterizedTest
    @MethodSource("generateDuplicatedLottoData")
    void duplicatedNumberTest(List<Integer> numbers) {
        assertThatThrownBy(() -> {
            Lotto.of(numbers);
        }).isInstanceOf(RuntimeException.class);
    }
    private static Stream<Arguments> generateDuplicatedLottoData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 5, 5, 5)),
                Arguments.of(Arrays.asList(1, 3, 2, 2, 2, 6)),
                Arguments.of(Arrays.asList(1, 1, 1, 2, 2, 2)),
                Arguments.of(Arrays.asList(2, 2, 3, 4, 9, 9))
        );
    }
}