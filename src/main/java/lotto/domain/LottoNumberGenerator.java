package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    // 로또 번호 캐싱
    private static final List<Integer> LOTTO_NUMBERS =
            IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());

    public static Lotto generateLottoNumber() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.stream()
                .limit(6)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::of));
    }
}
