package lotto.step3.domain;

import lotto.step3.domain.lottoResult.LottoResults;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public LottoResults getLottoResult(Lotto winningNumbers, int bonusNumber) {
        LottoResults lottoResults = LottoResults.of();
        for (Lotto lotto : lottos) {
            lottoResults.win(lotto.getHitCount(winningNumbers), lotto.hasBonusNumber(bonusNumber));
        }
        return lottoResults;
    }
}
