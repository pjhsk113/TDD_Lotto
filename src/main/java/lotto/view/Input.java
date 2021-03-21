package lotto.view;

import java.util.Scanner;

public class Input {
    private static final String ENTER_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String ENTER_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner sc = new Scanner(System.in);

    public static int enterAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT_MESSAGE);
        return sc.nextInt();
    }

    public static String enterWinningNumber() {
        System.out.println(ENTER_WINNING_NUMBER_MESSAGE);
        sc.nextLine();
        return sc.nextLine();
    }
}
