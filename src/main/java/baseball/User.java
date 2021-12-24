package baseball;

public class User {
	private String guessNumber;
	private boolean gaming;
	private static final String REGEX = "^[0-9]*$";

	public User() {
		this.gaming = true;
	}

	public boolean isGaming() {
		return gaming;
	}

	public void setGuessNumber(String guessNumber) throws IllegalArgumentException {
		if (!validateGuessNumber(guessNumber))
			throw new IllegalArgumentException();

		this.guessNumber = guessNumber;
	}

	public boolean validateGuessNumber(String guessNumber) {
		if (guessNumber.length() != 3) {
			return false;
		}
		if (!guessNumber.matches(REGEX)) {
			return false;
		}
		boolean[] duplicateCheckArray = new boolean[10];
		for (int i = 0; i < guessNumber.length(); ++i) {
			int num = Character.getNumericValue(guessNumber.charAt(i));
			if (duplicateCheckArray[num]) {
				throw new IllegalArgumentException("숫자간 중복이 있습니다.");
			} else {
				duplicateCheckArray[num] = true;
			}
		}
		return true;
	}

	public String getGuessNumber() {
		return guessNumber;
	}

	public void setGaming(String gaming) throws IllegalArgumentException {
		if (!validateGaming(gaming))
			throw new IllegalArgumentException();

		if (gaming.charAt(0) == '2') {
			this.gaming = false;
		}
	}

	public boolean validateGaming(String gaming) {
		if (gaming.length() > 1) {
			return false;
		}
		if (gaming.charAt(0) != '1' && gaming.charAt(0) != '2') {
			return false;
		}
		return true;
	}
}
