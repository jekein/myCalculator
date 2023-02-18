package com.example.demo;

public final class CalculatorUtil {
    private CalculatorUtil() {

    }
    static String calculate(String expression) {
        while (expression.matches(".*\\(.*")) {
            expression = calculateSubExpression(expression);
        }

        String[] split = expression.replace(",", ".").split(" ");
        double firstNumber = Double.parseDouble(split[0]);
        double secondNumber = Double.MIN_NORMAL;
        char operation;
        int iterator = 1;

        while (iterator < split.length) {
            operation = split[iterator++].charAt(0);

            if (iterator < split.length) {
                secondNumber = Double.parseDouble(split[iterator++]);
            }

            firstNumber = getResult(firstNumber, secondNumber, operation);
        }

        return String.valueOf(firstNumber);
    }

    private static String calculateSubExpression(String expression) {
        if (!expression.matches(".*\\(.*")) {
            return expression;
        }

        int leftIndex = -1;
        int rightIndex = -1;

        char[] chars = expression.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '(') {
                leftIndex = i;
                break;
            }
        }

        for (int i = leftIndex; i < chars.length; i++) {
            if (chars[i] == ')') {
                rightIndex = i;
                break;
            }
        }

        String substring = expression.substring(leftIndex, rightIndex + 1);
        String calculateSubstring = insertBkr(expression.substring(leftIndex + 1, rightIndex));

        return expression.replace(substring, calculate(calculateSubstring));
    }

    private static double getResult(double firstNumber, double secondNumber, char operation) {
        double result;

        switch (operation) {
            case '+' -> result = firstNumber + secondNumber;
            case '-' -> result = firstNumber - secondNumber;
            case '/' -> result = firstNumber / secondNumber;
            case '*' -> result = firstNumber * secondNumber;
            case '#' -> result = sqrt(firstNumber);
            case '^' -> result = sqr(firstNumber, secondNumber);
            case '!' -> result = fact((int) firstNumber);
            default -> result = Double.MIN_NORMAL;
        }

        return result;
    }

    private static double sqrt(double number) {
        double k = 1;

        for (int i = 0; i < 36; i++) {
            k = (k + (number / k)) / 2;
        }

        return k;
    }

    private static double sqr(double number, double degree) {
        if (degree == 0) return 1;

        double res = number;

        for (int i = 1; i < degree; i++) {
            res *= number;
        }

        return res;
    }

    private static double fact(int number) {
        double res = number;

        for (int i = 0; i < number; i++) {
            res *= --number;
        }

        return res;
    }

    private static String insertBkr(String expression) {
        String[] split = expression.split(" ");

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("!") || split[i].equals("#")) {
                String s = split[i - 1] + " " + split[i] + " ";
                expression = expression.replace(s, String.valueOf(getResult(Double.parseDouble(split[i - 1]),
                                                                            0,
                                                                            split[i].charAt(0))));
            }
        }

        split = expression.split(" ");

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("^")) {
                String s = split[i - 1] + " ^ " + split[i + 1];
                expression = expression.replace(s, String.valueOf(getResult(Double.parseDouble(split[i - 1]),
                                                                            Double.parseDouble(split[i + 1]),
                                                                            split[i].charAt(0))));
            }
        }

        split = expression.split(" ");

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("*") || split[i].equals("/")) {
                String s = split[i - 1] + String.format(" %s ", split[i]) + split[i + 1];
                expression = expression.replace(s, String.valueOf(getResult(Double.parseDouble(split[i - 1]),
                                                                            Double.parseDouble(split[i + 1]),
                                                                            split[i].charAt(0))));
            }
        }

        return expression;
    }
}
