package lotto.domain;

import lotto.domain.lottoResult.LottoResults;

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

    public LottoResults getLottoResult(Lotto winningNumbers) {
        LottoResults lottoResults = LottoResults.of();
        for (Lotto lotto : lottos) {
            lottoResults.win(lotto.getHitCount(winningNumbers));
        }
        return lottoResults;
    }
}
