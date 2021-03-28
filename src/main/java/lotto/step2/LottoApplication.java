package lotto.step2;

import lotto.step2.domain.Lotto;
import lotto.step2.domain.LottoNumberGenerator;
import lotto.step2.domain.LottoShop;
import lotto.step2.domain.Lottos;
import lotto.step2.domain.lottoResult.LottoResults;
import lotto.step2.view.Input;
import lotto.step2.view.Output;

public class LottoApplication {
    public static void main(String[] args) {
        int payment = Input.enterAmount();
        Lottos lottos = LottoShop.buyLotto(payment);
        Output.print(lottos);

        Lotto winningNumber = LottoNumberGenerator.generateLottoNumber(Input.enterWinningNumber());
        int bonusNumber = Input.enterBonusNumber();

        LottoResults lottoResult = lottos.getLottoResult(winningNumber, bonusNumber);

        Output.printLottoResult(lottoResult);
        Output.printProfit(payment, lottoResult);
    }
}
