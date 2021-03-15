package lotto.domain;

import lotto.constant.LottoContant;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Lotto {
    private static final String OUT_OF_RANGE_NUMBER = "로또 범위에 벗어난 수입니다.";
    private static final String DUPLICATE_LOTTO_NUMBER = "숫자에 중복이 존재합니다.";
    private static final int LOTTO_COUNT = 6;

    private final SortedSet<Integer> lottoNumbers;

    private Lotto(SortedSet<Integer> lottoNumbers) {
        validator(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        return new Lotto(new TreeSet<>(lottoNumbers));
    }

    /**
     * validation 메서드
     */
    private void validator(SortedSet<Integer> lottoNumbers) {
        validateOverlab(lottoNumbers);
        validateNumber(lottoNumbers);
    }

    private void validateOverlab(SortedSet<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new RuntimeException(DUPLICATE_LOTTO_NUMBER);
        }
    }

    private void validateNumber(SortedSet<Integer> lottoNumbers) {
        lottoNumbers.forEach(number -> {
            if (number < LottoContant.MIN_LOTTO_NUMBER || number > LottoContant.MAX_LOTTO_NUMBER) {
                throw new RuntimeException(OUT_OF_RANGE_NUMBER);
            }
        });
    }
}
