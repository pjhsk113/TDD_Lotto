package lotto.step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoShop {
    private LottoShop() { }

    private static final int THOUSAND = 1000;
    private static final String LACK_MONEY = "금액이 부족합니다.";

    public static Lottos buyLotto(int payment, List<Lotto> lottos) {
        validatePayment(payment);
        int remainingPayment = payment - lottos.size() * THOUSAND;
        validateRemainPayment(remainingPayment);
        lottos.addAll(buyAutoLotto(remainingPayment));
        return Lottos.of(lottos);
    }

    private static List<Lotto> buyAutoLotto(int autoLottoPurchasePayment) {
        return Stream.generate(LottoNumberGenerator::generateLottoNumber)
                .limit(autoLottoPurchasePayment / THOUSAND)
                .collect((Collectors.toList()));
    }

    private static void validatePayment(int payment) {
        if (payment < THOUSAND) {
            throw new IllegalArgumentException(LACK_MONEY);
        }
    }

    private static void validateRemainPayment(int payment) {
        if (payment < 0) {
            throw new IllegalArgumentException(LACK_MONEY);
        }
    }
}
