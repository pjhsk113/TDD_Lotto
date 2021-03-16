package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoShop {
    private LottoShop() { }

    private static final int THOUSAND = 1000;
    private static final String LACK_MONEY = "금액이 부족합니다.";

    public static Lottos buyLotto(int payment) {
        validatePayment(payment);
        return Stream.generate(LottoNumberGenerator::generateLottoNumber)
                .limit(payment / THOUSAND)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::of));
    }

    private static void validatePayment(int payment) {
        if (payment < THOUSAND) {
            throw new IllegalArgumentException(LACK_MONEY);
        }
    }
}
