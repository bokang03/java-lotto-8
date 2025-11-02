package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;

public class InputView {

    public int lottoMoneyInput(){
        System.out.println("구입금액을 입력해주세요.");
        String InputMoney = Console.readLine();
        validateIntegerInput(InputMoney);
        return Integer.parseInt(InputMoney);
    }

    public void validateIntegerInput(String validateString){
        try {
            Integer.parseInt(validateString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }
}
