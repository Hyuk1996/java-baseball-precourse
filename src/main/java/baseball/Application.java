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

            if(computer.compareRandomNumber(user.getGuessNumber())) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                try{
                    user.setGaming(Console.readLine());
                } catch(Exception e) {
                    e.printStackTrace();
                    return;
                }

                if(user.isGaming())
                    computer.setRandomNumber();
            }
        }
    }
}
