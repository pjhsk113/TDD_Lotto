package lotto.view;

import java.util.Scanner;

public class Input {
    private static final String ENTER_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해주세요.";
    private static final Scanner sc = new Scanner(System.in);

    public static int enterAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT_MESSAGE);
        return sc.nextInt();
    }
}
