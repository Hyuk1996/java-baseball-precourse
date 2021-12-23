package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private Computer computer;
    private User user;

    public BaseballGame () {
        this.computer = new Computer();
        this.user = new User();
    };

    public void play() throws IllegalArgumentException {
        computer.setRandomNumber();

        while (user.isGaming()) {
            System.out.print("숫자를 입력해주세요 : ");
            user.setGuessNumber(Console.readLine());

            if(computer.compareRandomNumber(user.getGuessNumber())) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                user.setGaming(Console.readLine());

                if(user.isGaming())
                    computer.setRandomNumber();
            }
        }
    }
}
