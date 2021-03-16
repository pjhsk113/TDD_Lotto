package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoShopTest {

    @DisplayName("로또가 올바른 수량만큼 구입되는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1001 :1", "12780 :12", "1999 :1", "234567 : 234" }, delimiter = ':')
    void lotto_Purchase_Test(int payment, int expected) {
        Lottos lottos = LottoShop.buyLotto(payment);
        assertThat(lottos.getLottoCount()).isEqualTo(expected);
    }

    @DisplayName("금액 부족으로 로또를 구매할 수 없는 경우 Exception 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 999, 2, 1, 10, 892 })
    void invalid_Payment(int payment) {
        assertThatThrownBy(() -> {
            LottoShop.buyLotto(payment);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}