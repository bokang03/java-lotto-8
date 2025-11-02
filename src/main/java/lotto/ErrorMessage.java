package lotto;

public enum ErrorMessage {
    INVALID_NUMBER_INPUT("[ERROR] 숫자만 입력해주세요."),
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_DIVIDE_PRICE("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해주세요."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
