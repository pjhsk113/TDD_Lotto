package lotto;

import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.view.Input;

public class LottoApplication {
    int payment = Input.enterAmount();
    Lottos lottos = LottoShop.buyLotto(payment);
}
