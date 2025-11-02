package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;

public class InputView {

    public int lottoMoneyInput(){
        System.out.println("구입금액을 입력해주세요.");
        String inputMoney = Console.readLine();
        validateIntegerInput(inputMoney);

        int money = Integer.parseInt(inputMoney.trim());
        validateLottoDividePrice(money);
        return money;
    }

    public void validateIntegerInput(String validateString){
        try {
            Integer.parseInt(validateString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }

    public void validateLottoDividePrice(int money){
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_DIVIDE_PRICE.getMessage());
        }
    }
}
