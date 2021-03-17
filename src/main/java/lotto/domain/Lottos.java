package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of (List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }
}
