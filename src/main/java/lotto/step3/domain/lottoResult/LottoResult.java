package lotto.step3.domain.lottoResult;

public class LottoResult {
    private final Rank rank;
    private final WinCount winCount;

    private LottoResult(Rank rank, WinCount winCount) {
        this.rank = rank;
        this.winCount = winCount;
    }

    public static LottoResult of(Rank rank) {
        return new LottoResult(rank, new WinCount(0));
    }

    public void win(int hitNumber, boolean bonusNumber) {
        if (rank != Rank.valueOf(hitNumber, bonusNumber)) {
            return;
        }
        winCount.plus();
    }

    public int getWinCount() {
        return winCount.getNumberOfWin();
    }

    public int getHitNumber() {
        return rank.getHit();
    }

    public int getMoney() {
        return rank.getReward();
    }

    public int winningProfit() {
        return winCount.moneyCount(rank.getReward());
    }

    public boolean isWinningNumber(Rank second) {
        return rank.equals(second);
    }
}
