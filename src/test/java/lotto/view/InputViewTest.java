// java
package lotto.view;

import lotto.ErrorMessage;
import org.junit.jupiter.api.Test;

import static lotto.ErrorMessage.INVALID_NUMBER_INPUT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {

    private final InputView inputView = new InputView();

    @Test
    void 로또_금액_정수_검증() {
        // 정수 변환이 가능한 경우
        assertDoesNotThrow(() -> inputView.validateIntegerInput("1000"));
        // 정수 변환이 안되는 경우
        assertThatThrownBy(() -> inputView.validateIntegerInput("1000a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
    }

    @Test
    void 로또_금액_단위_검증() {
        // 1,000원 단위가 아닌 경우 IllegalArgumentException 및 메시지 검증
        assertThatThrownBy(() -> inputView.validateLottoDividePrice(2500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_DIVIDE_PRICE.getMessage());
    }
}
