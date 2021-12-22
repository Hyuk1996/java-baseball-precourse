package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private String randomNumber;

    public Computer() {
    }

    public void setRandomNumber() {
        int tempRandomNumber;
        do {
            tempRandomNumber = Randoms.pickNumberInRange(1, 999);
        } while (isValidate(tempRandomNumber));
        this.randomNumber = Integer.toString(tempRandomNumber);
    }

    public boolean isValidate(int randomNumber) {
        int firstNum = randomNumber % 10;
        randomNumber /= 10;
        int secondNum = randomNumber % 10;
        randomNumber /= 10;
        int thirdNum = randomNumber;

        if (firstNum == 0 || secondNum == 0 || thirdNum == 0)
            return true;

        if (firstNum != secondNum && secondNum != thirdNum && thirdNum != firstNum) {
            return false;
        } else {
            return true;
        }
    }

    public String getRandomNumber() {
        return randomNumber;
    }

    public boolean compareRandomNumber(String guessNumber) {
        int strike = 0;
        int ball = 0;

        for(int i=0; i<guessNumber.length(); ++i) {
            char checkNum = guessNumber.charAt(i);

            if(checkNum == randomNumber.charAt(i)) {
                ++strike;
                continue;
            }

            if(isBall(checkNum, i)) {
                ++ball;
            }
        }

        if(ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return false;
        } else if (strike == 3) {
            System.out.println(strike + "스트라이크");
            return true;
        } else {
            if(ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if(strike > 0) {
                System.out.println(strike + "스트라이크");
            }
            System.out.print('\n');
            return false;
        }
    }

    public boolean isBall(char checkNum, int index) {
        for(int i=0; i<randomNumber.length(); ++i) {
            if(i == index) {
                continue;
            }

            if(checkNum == randomNumber.charAt(i)) {
                return true;
            }
        }
        return false;
    }

}
