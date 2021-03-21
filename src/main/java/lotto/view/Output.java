package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.lottoResult.LottoResult;
import lotto.domain.lottoResult.LottoResults;

import java.util.stream.Collectors;

public class Output {
    private static final String BUYING_FORMAT = "%d개를 구매했습니다.\n%s\n\n";
    private static final String WINNINNG_STATISTICS_MESSAGE = "당첨 통계.\n---------";
    private static final String STATISTICS_STATUS= "%d개 일치 (%d원)- %d개";
    private static final String TOTAL_REVENUS= "총 수익률은 %.2f 입니다";

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

    public static void printLottoResult(LottoResults prizes) {
        System.out.println(WINNINNG_STATISTICS_MESSAGE);
        System.out.println(printLottoPrizes(prizes));
    }

    private static String printLottoPrizes(LottoResults prizes) {
        StringBuilder sb = new StringBuilder();

        for (LottoResult value : prizes.getLottoResults()) {
            sb.append(String.format(STATISTICS_STATUS, value.getHitNumber(), value.getMoney(), value.getWinCount()));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void printProfit(int purchaseAmount, LottoResults prizes) {
        System.out.printf((TOTAL_REVENUS) + "%n", (double)prizes.getTotalReward() / purchaseAmount);
    }
}
