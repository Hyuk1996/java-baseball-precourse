package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private int randomNumber;

    public Computer() {
    }

    public void setRandomNumber() {
        int tempRandomNumber;
        do {
            tempRandomNumber = Randoms.pickNumberInRange(1, 999);
        } while(isValidate(tempRandomNumber));
        this.randomNumber = tempRandomNumber;
    }

    public boolean isValidate(int randomNumber) {
        int firstNum = randomNumber % 10;
        randomNumber /= 10;
        int secondNum = randomNumber % 10;
        randomNumber /= 10;
        int thirdNum = randomNumber;

        if(firstNum == 0 || secondNum == 0 || thirdNum == 0)
            return true;

        if(firstNum != secondNum && secondNum != thirdNum && thirdNum != firstNum) {
            return false;
        } else {
            return true;
        }
    }

    public int getRandomNumber() {
        return randomNumber;
    }



}
