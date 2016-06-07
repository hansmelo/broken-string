package br.com.ita;

public class StringTool {

	private static final String MSG_ERROR = "invalid string";

	private static final String REGEX_ALPHANUMERICS = "^[a-zA-Z0-9]*$";

	private static final String REGEX_CAMEL_CASE = "(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])|(?<!(^|[0-9]))(?=[0-9])";

	private static final String REGEX_UPCASE_MOST_ONE_FOLLOW = "^(.*?[A-Z]){2,}.*$";

	public String[] converterCamelCase(String input) {
		checkValidFormat(input);
		String[] words = splitCamelCase(input);
		return convertLowerCase(words);
	}

	private void checkValidFormat(String input) {
		if (Character.isDigit(input.charAt(0))) {
			throw new InvalidInitialWithNumberException(MSG_ERROR);
		}
		if (isContainNotAlphanumeric(input)) {
			throw new InvalidCharacterException(MSG_ERROR);
		}
	}

	private boolean isContainNotAlphanumeric(String input) {
		return !input.matches(REGEX_ALPHANUMERICS);
	}

	private String[] splitCamelCase(String input) {
		return input.split(REGEX_CAMEL_CASE);
	}

	private String[] convertLowerCase(String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (isCanLowerCase(words[i])) {
				words[i] = words[i].toLowerCase();
			}
		}
		return words;
	}

	private boolean isCanLowerCase(String word) {
		return !word.matches(REGEX_UPCASE_MOST_ONE_FOLLOW);
	}

}
