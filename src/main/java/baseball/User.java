package baseball;

public class User {
    private String guessNumber;
    private boolean isGaming;
    private static final String REGEX = "^[0-9]*$";

    public User() {
        this.isGaming = true;
    }

    public boolean isGaming() {
        return isGaming;
    }

    public void setGuessNumber(String guessNumber) throws IllegalArgumentException {


        if (guessNumber.length() != 3) {
            throw new IllegalArgumentException("입력 문자열의 길이가 3이 아닙니다.");
        }
        if (!guessNumber.matches(REGEX)) {
            throw new IllegalArgumentException("입력 문자열이 숫자로 구성되어 있지 않습니다.");
        }

        boolean[] duplicateCheckArray = new boolean[10];
        for(int i = 0; i < guessNumber.length(); ++i) {
            int num = Character.getNumericValue(guessNumber.charAt(i));
            if(duplicateCheckArray[num]) {
                throw new IllegalArgumentException("숫자간 중복이 있습니다.");
            } else {
                duplicateCheckArray[num] = true;
            }
        }

        this.guessNumber = guessNumber;
    }

    public String getGuessNumber() {
        return guessNumber;
    }
}
