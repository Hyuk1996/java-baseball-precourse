package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private String randomNumbers;

    public Computer() {
    }

    public void setRandomNumber() {
        int tempRandomNumbers = 0;
        boolean[] checkDuplicate = new boolean[10];
        int tempRandomNumber;
        int count = 0;
        while (count < 3) {
            tempRandomNumber = Randoms.pickNumberInRange(1, 9);
            if (checkDuplicate[tempRandomNumber]) {
                continue;
            }

            if (count != 0) {
                tempRandomNumbers *= 10;
            }
            tempRandomNumbers += tempRandomNumber;
            ++count;
            checkDuplicate[tempRandomNumber] = true;
        }
        this.randomNumbers = Integer.toString(tempRandomNumbers);
    }


    public String getRandomNumbers() {
        return randomNumbers;
    }

    public boolean compareRandomNumber(String guessNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < guessNumber.length(); ++i) {
            char checkNum = guessNumber.charAt(i);

            if (checkNum == randomNumbers.charAt(i)) {
                ++strike;
                continue;
            }

            if (isBall(checkNum, i)) {
                ++ball;
            }
        }

        showResult(strike, ball);

        if (strike == 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBall(char checkNum, int index) {
        for (int i = 0; i < randomNumbers.length(); ++i) {
            if (i == index) {
                continue;
            }

            if (checkNum == randomNumbers.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public void showResult(int strike, int ball) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println(strike + "스트라이크");
        } else {
            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            System.out.print('\n');
        }
    }
}
