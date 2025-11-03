package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<Integer> winningNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winnerLottoNum = Console.readLine();
        return parseLottoNumbers(winnerLottoNum);
    }

    private List<Integer> parseLottoNumbers(String winnerLottoNum) {
        String[] parts = splitParts(winnerLottoNum);
        validatePartsCount(parts);
        List<Integer> nums = parsePartsToIntegers(parts);
        validateNoDuplicate(nums);
        validateRange(nums);
        return toSortedUnmodifiableList(nums);
    }

    private String[] splitParts(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        return input.split(",");
    }

    private void validatePartsCount(String[] parts) {
        if (parts.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private List<Integer> parsePartsToIntegers(String[] parts) {
        List<Integer> nums = new ArrayList<>();
        for (String p : parts) {
            try {
                nums.add(Integer.parseInt(p.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
            }
        }
        return nums;
    }

    private void validateNoDuplicate(List<Integer> nums) {
        Set<Integer> set = new HashSet<>(nums);
        if (set.size() != nums.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    private void validateRange(List<Integer> nums) {
        for (int n : nums) {
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    private List<Integer> toSortedUnmodifiableList(List<Integer> nums) {
        return nums.stream().sorted().collect(Collectors.toUnmodifiableList());
    }

    public int bonusNumberInput(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();

        if (bonus == null || bonus.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }

        if (bonus.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }

        validateIntegerInput(bonus);

        int num = Integer.parseInt(bonus.trim());
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }

        if (winningNumbers != null && winningNumbers.contains(num)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_DUPLICATE.getMessage());
        }

        return num;
    }

}
