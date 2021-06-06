package lotto.step3;

import lotto.step3.domain.Lotto;
import lotto.step3.domain.LottoNumberGenerator;
import lotto.step3.domain.LottoShop;
import lotto.step3.domain.Lottos;
import lotto.step3.domain.lottoResult.LottoResults;
import lotto.step3.view.Input;
import lotto.step3.view.Output;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int payment = Input.enterAmount();
        int manualLottoCount = Input.enterManualNumberCount();
        List<Lotto> manualLottoNumbers = Input.enterManualNumber(manualLottoCount);
        Lottos lottos = LottoShop.buyLotto(payment, manualLottoNumbers);
        Output.print(lottos, manualLottoCount);

        Lotto winningNumber = LottoNumberGenerator.generateLottoNumber(Input.enterWinningNumber());
        int bonusNumber = Input.enterBonusNumber();

        LottoResults lottoResult = lottos.getLottoResult(winningNumber, bonusNumber);

        Output.printLottoResult(lottoResult);
        Output.printProfit(payment, lottoResult);
    }
}
