package lotto.step2.domain;

import lotto.step2.constant.LottoContant;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Lotto {
    private static final String OUT_OF_RANGE_NUMBER = "로또 범위에 벗어난 수입니다.";
    private static final String DUPLICATE_LOTTO_NUMBER_OR_INVALID_NUMBER = "숫자에 중복이 존재하거나 잘못 입력하셨습니다.";

    private final SortedSet<Integer> lottoNumbers;

    private Lotto(SortedSet<Integer> lottoNumbers) {
        validator(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        return new Lotto(new TreeSet<>(lottoNumbers));
    }

    public int getHitCount(Lotto winningLotto) {
        return winningLotto.stream()
                .filter(lottoNumbers::contains)
                .map(e -> 1)
                .reduce(0, Integer::sum);
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    /**
     * validation 메서드
     */
    private void validator(SortedSet<Integer> lottoNumbers) {
        validateOverlab(lottoNumbers);
        validateNumber(lottoNumbers);
    }

    private void validateOverlab(SortedSet<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoContant.LOTTO_COUNT) {
            throw new RuntimeException(DUPLICATE_LOTTO_NUMBER_OR_INVALID_NUMBER);
        }
    }

    private void validateNumber(SortedSet<Integer> lottoNumbers) {
        lottoNumbers.forEach(number -> {
            if (number < LottoContant.MIN_LOTTO_NUMBER || number > LottoContant.MAX_LOTTO_NUMBER) {
                throw new RuntimeException(OUT_OF_RANGE_NUMBER);
            }
        });
    }

    public Stream<Integer> stream() {
        return lottoNumbers.stream();
    }
}
