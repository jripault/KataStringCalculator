package org.dojo.calculator;

public class StringCalculator {

    public final String NEW_LINE = "\n";
    public final String DELIMITER = ",";

    private String numbersStr;
    private int res;
    private String negativeNumbers;

    public int add(String numbers) {
        initialize(numbers);
        computeAddResult();
        return res;
    }

    private void initialize(String numbers) {
        numbersStr = numbers;
        res = 0;
        replaceCustomDelimiter();
        removeNewLines();
    }

    private void replaceCustomDelimiter() {
        if (numbersStr.startsWith("/")) {// Custom delimiter
            String customDelimiter = numbersStr.substring(1, 2);
            numbersStr = numbersStr.substring(2, numbersStr.length());
            numbersStr = numbersStr.replaceAll(customDelimiter, DELIMITER);
        }
    }

    private void removeNewLines() {
        if (numbersStr.equals(NEW_LINE)) {
            numbersStr = "";
        }

        if (numbersStr.startsWith(NEW_LINE)) {
            numbersStr = numbersStr.substring(numbersStr.indexOf(NEW_LINE) + 1, numbersStr.length());
        }

        if (numbersStr.endsWith(NEW_LINE)) {
            numbersStr = numbersStr.substring(0, numbersStr.lastIndexOf(NEW_LINE));
        }

        numbersStr = numbersStr.replaceAll(DELIMITER + NEW_LINE, DELIMITER);
        numbersStr = numbersStr.replaceAll(NEW_LINE + DELIMITER, DELIMITER);
        numbersStr = numbersStr.replaceAll(NEW_LINE, DELIMITER);
    }

    private void computeAddResult() {
        if (!numbersStr.isEmpty()) {
            negativeNumbers = "";
            try {
                for (String number : numbersStr.split(DELIMITER)) {
                    negativeNumbers = checkNegativeNumbers(number);
                    res += Integer.parseInt(number);
                }
                if (!negativeNumbers.isEmpty()) {
                    throw new IllegalArgumentException("Negative numbers not allowed : " + negativeNumbers);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Incorrect input format: one of the args is incorrect");
            }
        }
    }

    private String checkNegativeNumbers(String number) {
        if (Integer.parseInt(number) < 0) {
            if (negativeNumbers.isEmpty()) {
                negativeNumbers = number;
            } else {
                negativeNumbers += ", " + number;
            }
        }
        return negativeNumbers;
    }

}
