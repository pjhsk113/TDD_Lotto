package lotto.domain.lottoResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {
    private final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResults of() {
        return new LottoResults(Arrays.stream(Rank.values())
                .map(LottoResult::of)
                .collect(Collectors.toList()));
    }

    public void win(int hitCount) {
        for (LottoResult result : lottoResults) {
            result.win(hitCount);
        }
    }

    public List<LottoResult> getLottoResults() {
        return Collections.unmodifiableList(this.lottoResults);
    }

    public int getTotalReward() {
        return lottoResults.stream()
                .map(LottoResult::winningProfit)
                .reduce(0, Integer::sum);
    }
}
