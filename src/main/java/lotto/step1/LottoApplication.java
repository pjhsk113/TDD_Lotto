package lotto.step1;

import lotto.step1.domain.Lotto;
import lotto.step1.domain.LottoNumberGenerator;
import lotto.step1.domain.LottoShop;
import lotto.step1.domain.Lottos;
import lotto.step1.domain.lottoResult.LottoResults;
import lotto.step1.view.Input;
import lotto.step1.view.Output;

public class LottoApplication {
    public static void main(String[] args) {
        int payment = Input.enterAmount();
        Lottos lottos = LottoShop.buyLotto(payment);
        Output.print(lottos);

        Lotto winningNumber = LottoNumberGenerator.generateLottoNumber(Input.enterWinningNumber());
        LottoResults lottoResult = lottos.getLottoResult(winningNumber);

        Output.printLottoResult(lottoResult);
        Output.printProfit(payment, lottoResult);
    }
}
