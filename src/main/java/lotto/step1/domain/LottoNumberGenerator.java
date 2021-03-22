package lotto.step1.domain;

import lotto.step1.constant.LottoContant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    // 로또 번호 캐싱
    private static final List<Integer> LOTTO_NUMBERS =
            IntStream.rangeClosed(LottoContant.MIN_LOTTO_NUMBER, LottoContant.MAX_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public static Lotto generateLottoNumber() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.stream()
                .limit(LottoContant.LOTTO_COUNT)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::of));
    }

    public static Lotto generateLottoNumber(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::of));
    }
}
