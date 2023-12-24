package ch01;

import java.util.Scanner;

public class P07_ConvertStringToNumber {
    // 다음과 같은 문자열을 가정(음수도 가능)
    private static final String TO_INT = "453";
    private static final String TO_LONG = "45234223233";
    private static final String TO_FLOAT = "45.823F";
    private static final String TO_DOUBLE = "13.83423D";

    private static final String WRONG_NUMBER = "138w";

    public static void main(String[] args) {
        convertToPrimitiveTypes();
        convertToWrapperObjects();
        handleNumberFormatException();
    }

    // 1. String을 기본 데이터 타입으로 변환하는 메소드
    private static void convertToPrimitiveTypes() {
        int toInt = Integer.parseInt(TO_INT);
        long toLong = Long.parseLong(TO_LONG);
        float toFloat = Float.parseFloat(TO_FLOAT);
        double toDouble = Double.parseDouble(TO_DOUBLE);

        // 변환된 값들을 사용할 수 있음
        System.out.println("toInt: " + toInt);
        System.out.println("toLong: " + toLong);
        System.out.println("toFloat: " + toFloat);
        System.out.println("toDouble: " + toDouble);
    }

    // 2. String을 객체로 변환하는 메소드
    private static void convertToWrapperObjects() {
        Integer toInt = Integer.valueOf(TO_INT);
        Long toLong = Long.valueOf(TO_LONG);
        Float toFloat = Float.valueOf(TO_FLOAT);
        Double toDouble = Double.valueOf(TO_DOUBLE);

        // 변환된 객체들을 사용할 수 있음
        System.out.println("toInt: " + toInt);
        System.out.println("toLong: " + toLong);
        System.out.println("toFloat: " + toFloat);
        System.out.println("toDouble: " + toDouble);
    }

    // 3. NumberFormatException을 처리하는 메소드
    private static void handleNumberFormatException() {
        try {
            Integer toIntWrong1 = Integer.valueOf(WRONG_NUMBER);
        } catch (NumberFormatException e) {
            System.err.println("Error converting to Integer: " + e.getMessage());
            // 예외 처리
        }

        try {
            int toIntWrong2 = Integer.parseInt(WRONG_NUMBER);
        } catch (NumberFormatException e) {
            System.err.println("Error converting to int: " + e.getMessage());
            // 예외 처리
        }
    }
}
