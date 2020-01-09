package com.pjwstk.util;

public class NumberUtils {

    private NumberUtils() {

    }

    public static int[] parseNumbers(String[] numberStrings) throws NumberFormatException {
        int counter = 0;
        int[] numbers = new int[numberStrings.length];
        for (String s : numberStrings) {
            numbers[counter++] = parseNumber(s);
        }
        return numbers;
    }

    private static int parseNumber(String number) throws NumberFormatException {
        int num = Integer.parseInt(number);
        if (num <= 0) {
            throw new NumberFormatException("Error: Number " + num + " is not higher than 0!");
        }
        return num;
    }
}
