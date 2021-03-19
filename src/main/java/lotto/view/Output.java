package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.stream.Collectors;

public class Output {
    private static final String BUYING_FORMAT = "%d개를 구매했습니다.\n%s\n\n";

    private Output() { }

    public static void print(Lottos lottos) {
        String lottoList = lottos.stream()
                .map(Output::getLotto)
                .collect(Collectors.joining("\n"));
        System.out.printf(BUYING_FORMAT, lottos.getLottoCount(), lottoList);
    }

    private static String getLotto(Lotto lotto) {
        String str = lotto.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        return "[" + str + "]";
    }
}
