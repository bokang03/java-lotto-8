package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoNumberMapping, Integer> counts = new EnumMap<>(LottoNumberMapping.class);

    public LottoResult() {
        for (LottoNumberMapping num : LottoNumberMapping.values()) {
            counts.put(num, 0);
        }
    }

    public void incrementCount(LottoNumberMapping num) {
        if (num == null) return;
        counts.put(num, counts.get(num) + 1);
    }

    public int getCount(LottoNumberMapping num) {
        return counts.getOrDefault(num, 0);
    }

    public long getTotalPrize() {
        long sum = 0L;
        for (LottoNumberMapping num : LottoNumberMapping.values()) {
            sum += num.getPrize() * getCount(num);
        }
        return sum;
    }

    public double calculateIncomePercent(int money) {
        if (money <= 0) return 0.0;
        return ((double) getTotalPrize() / money) * 100.0;
    }
}
