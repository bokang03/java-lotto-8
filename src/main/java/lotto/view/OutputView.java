package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumberMapping;
import lotto.model.LottoResult;

import java.util.List;

public class OutputView {

    public void printPurchaseCount(int count) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printStatistics(LottoResult result, int money) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(LottoNumberMapping.FIFTH.getDisplay() + " - " + result.getCount(LottoNumberMapping.FIFTH) + "개");
        System.out.println(LottoNumberMapping.FOURTH.getDisplay() + " - " + result.getCount(LottoNumberMapping.FOURTH) + "개");
        System.out.println(LottoNumberMapping.THIRD.getDisplay() + " - " + result.getCount(LottoNumberMapping.THIRD) + "개");
        System.out.println(LottoNumberMapping.SECOND.getDisplay() + " - " + result.getCount(LottoNumberMapping.SECOND) + "개");
        System.out.println(LottoNumberMapping.FIRST.getDisplay() + " - " + result.getCount(LottoNumberMapping.FIRST) + "개");

        double incomePercent = result.calculateIncomePercent(money);
        System.out.println("총 수익률은 " + String.format("%.1f", incomePercent) + "%입니다.");
    }
}
