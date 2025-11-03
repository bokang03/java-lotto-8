package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoResult;
import lotto.model.ResultCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;
    private final ResultCalculator calculator;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
        this.outputView = new OutputView();
        this.lottoGenerator = new LottoGenerator();
        this.calculator = new ResultCalculator();
    }

    public void purchaseLotto() {
        int money = readValidMoney();
        List<Lotto> lottos = autoLottoNum(money);
        List<Integer> winningNumbers = inputWinnerNum();
        int bonus = readBonusNumber(winningNumbers);

        LottoResult result = calculator.calculate(lottos, winningNumbers, bonus);
        outputView.printStatistics(result, money);
    }

    public int readValidMoney() {
        while (true) {
            try {
                return inputView.lottoMoneyInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> autoLottoNum(int money) {
        int count = money / 1000;
        List<Lotto> lottos = lottoGenerator.randomGenerate(count);

        outputView.printPurchaseCount(count);
        outputView.printLottos(lottos);
        return lottos;
    }

    public List<Integer> inputWinnerNum() {
        while (true) {
            try {
                System.out.println();
                return inputView.winningNumbersInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int readBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println();
                return inputView.bonusNumberInput(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
