package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
        this.outputView = new OutputView();
        this.lottoGenerator = new LottoGenerator();
    }

    public void purchaseLotto() {
        int money;

        while(true) {
            try {
                money = inputView.lottoMoneyInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        int count = money / 1000;
        List<Lotto> lottos = lottoGenerator.randomGenerate(count);

        outputView.printPurchaseCount(count);
        outputView.printLottos(lottos);
    }
}
