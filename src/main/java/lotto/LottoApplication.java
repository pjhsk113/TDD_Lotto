package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.view.Input;
import lotto.view.Output;

public class LottoApplication {
    public static void main(String[] args) {
        int payment = Input.enterAmount();
        Lottos lottos = LottoShop.buyLotto(payment);
        Output.print(lottos);

        Lotto winningNumber = LottoNumberGenerator.generateLottoNumber(Input.enterWinningNumber());

    }
}
