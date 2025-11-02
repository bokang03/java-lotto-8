package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;

public class InputView {

    public int lottoMoneyInput(){
        String money;

        while(true) {
            System.out.println("구입금액을 입력해주세요.");
            money = Console.readLine();
            try {
                validateIntegerInput(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return Integer.parseInt(money);
        }
    }

    public void validateIntegerInput(String validateString){
        try {
            Integer.parseInt(validateString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }
}
