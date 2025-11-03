package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ResultCalculatorTest {

    @Test
    void 당첨_통계_및_수익률_계산() {
        List<Lotto> purchased = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        int money = 8000;

        ResultCalculator calculator = new ResultCalculator();
        LottoResult result = calculator.calculate(purchased, winningNumbers, bonus);

        assertThat(result.getCount(LottoNumberMapping.FIFTH)).isEqualTo(1);
        assertThat(result.getCount(LottoNumberMapping.FOURTH)).isEqualTo(0);
        assertThat(result.getCount(LottoNumberMapping.THIRD)).isEqualTo(0);
        assertThat(result.getCount(LottoNumberMapping.SECOND)).isEqualTo(0);
        assertThat(result.getCount(LottoNumberMapping.FIRST)).isEqualTo(0);

        assertThat(result.getTotalPrize()).isEqualTo(5_000L);
        double incomePercent = ((double) result.getTotalPrize() / money) * 100.0;
        assertThat(incomePercent).isEqualTo(62.5);
    }
}
