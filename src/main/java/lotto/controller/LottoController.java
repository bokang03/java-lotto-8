package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
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
    }
}
