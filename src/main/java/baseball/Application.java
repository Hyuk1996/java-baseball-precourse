package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        User user = new User();
        Computer computer = new Computer();
        computer.setRandomNumber();

        while (user.isGaming()) {
            System.out.print("숫자를 입력해주세요 : ");
            try {
                user.setGuessNumber(Console.readLine());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

        }

    }
}
