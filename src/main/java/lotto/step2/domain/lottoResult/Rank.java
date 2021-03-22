package lotto.step2.domain.lottoResult;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    LOSE(0, 0);

    private int hit;
    private int reward;

    Rank(int hit, int reward) {
        this.hit = hit;
        this.reward = reward;
    }

    public int getHit() {
        return hit;
    }

    public int getReward() {
        return reward;
    }

    public static Rank valueOf(int hit) {
        return Arrays.stream(values())
                .filter(rank -> rank.getHit() == hit)
                .findFirst()
                .orElse(LOSE);
    }
}
