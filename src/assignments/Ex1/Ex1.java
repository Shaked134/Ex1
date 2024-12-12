package assignments.Ex1;

import assignments.Ex1.Ex1;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        if (!isNumber(num)) {
            return -1;
        }
        // If there is no base, treat it as a regular decimal number
        if (!num.contains("b")) {
            int numberValue = 0;
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c >= '0' && c <= '9') {
                    numberValue = numberValue * 10 + (c - '0');
                }
            }
            return numberValue;
        }

// Splitting the parts of the number and the base
        int baseIndex = num.lastIndexOf('b');
        String numberPart = num.substring(0, baseIndex);
        String basePart = num.substring(baseIndex + 1);

        // Identifying the base from the second part of the string
        int base = 0;
        char c = basePart.charAt(0);
        if (c >= '2' && c <= '9') {
            base = c - '0';
        } else if (c >= 'A' && c <= 'G') {
            base = c - 'A' + 10;
        }

// Calculating the number in decimal base
        int result = 0;
        for (int i = 0; i < numberPart.length(); i++) {
            char x = numberPart.charAt(i);
            int decimalValue;
            if (x >= '0' && x <= '9') {
                decimalValue = x - '0';
            } else if (x >= 'A' && x <= 'G') {
                decimalValue = x - 'A' + 10;
            } else {
                return -1;
            }

            if (decimalValue >= base) {
                return -1;
            }

            result = result * base + decimalValue;
        }

        return result;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        // whether the string is empty, contains spaces, or is null
        if (a == null || a.isEmpty() || a.contains(" ")) {
            return false;
        }

// If there is no "b", check that the string contains only digits
        if (!a.contains("b")) {
            for (int i = 0; i < a.length(); i++) {
                if (!Character.isDigit(a.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
// Check if there is more than one "b"
        int countB = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'b') {
                countB++;
                if (countB > 1) {
                    return false;
                }
            }
        }

        if (countB != 1) {
            return false;
        }

        String[] parts = a.split("b", 2);

        String numberPart = parts[0];
        String basePart = parts[1];


        if (numberPart.isEmpty() || basePart.isEmpty()) {
            return false;
        }
// If one of the parts is empty, the format is invalid
        if (!((basePart.charAt(0) >= '2' && basePart.charAt(0) <= '9') || (basePart.charAt(0) >= 'A' && basePart.charAt(0) <= 'G'))) {
            return false;
        }

        for (int x = 0; x < numberPart.length(); x++) {
            char c = numberPart.charAt(x);
            if (c < basePart.charAt(0)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        if (num < 0 || base < 2 || base > 16) {
            return "";
        }
        if (num == 0) {
            return "0b" + base;
        }
        // Converts the number to a string in the desired base
        while (num > 0) {
            int rest = num % base;
            char gnum;
            if (rest >= 10) {
                gnum = (char) ('A' + (rest - 10));
            } else {
                gnum = (char) ('0' + rest);
            }
            ans = gnum + ans;

            num /= base;
        }
        char Base = ' ';
        if (base >= 10 && base <= 16) {
            Base = (char) ('A' + base - 10);
        }
        if (base >= 2 && base <= 9) {
            Base = (char) ('0' + base);
        }

        return ans + "b" + Base;


    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        if (n1 == null || n2 == null) {
            return false;
        }

        int value1 = number2Int(n1);
        int value2 = number2Int(n2);
        if (value1 == value2) {
            return ans;
        } else {
            return false;
        }
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            String num = arr[i];// get the current string from the array
            if (isNumber(num)) {
                int value = number2Int(num);// Convert the string to its decimal value
                if (value > maxValue) {
                    maxValue = value;
                    ans = maxValue;
                }
            }
        }
        return ans;
    }
}
