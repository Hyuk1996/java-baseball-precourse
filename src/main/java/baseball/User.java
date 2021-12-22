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

    public void setGuessNumber (String guessNumber) throws IllegalArgumentException {

        if(guessNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
        if(!guessNumber.matches(REGEX)) {
            throw new IllegalArgumentException();
        }

        this.guessNumber = guessNumber;
    }

    public String getGuessNumber() {
        return guessNumber;
    }
}
