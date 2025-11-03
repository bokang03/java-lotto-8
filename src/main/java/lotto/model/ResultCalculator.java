package lotto.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultCalculator {

    public LottoResult calculate(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult();
        Set<Integer> winSet = winningNumbers.stream().collect(Collectors.toSet());

        for (Lotto lotto : purchasedLottos) {
            List<Integer> nums = lotto.getNumbers();
            int matchCount = (int) nums.stream().filter(winSet::contains).count();
            boolean bonusMatch = nums.contains(bonusNumber);
            LottoNumberMapping mapping = LottoNumberMapping.of(matchCount, bonusMatch);
            result.incrementCount(mapping);
        }
        return result;
    }
}
