package ch01;

import java.util.Scanner;

public class P07_ConvertStringToNumber {
    // 다음과 같은 문자열을 가정(음수도 가능)
    private static final String TO_INT = "453";
    private static final String TO_LONG = "45234223233";
    private static final String TO_FLOAT = "45.823F";
    private static final String TO_DOUBLE = "13.83423D";

    private static final String WRONG_NUMBER = "138w";

    public static void main(String args){
//        1. String을 int나 long, float, double로 변환하는 방법
//        int toInt = Integer.parseInt(TO_INT);
//        long toLong = Long.parseLong(TO_LONG);
//        float toFloat = Float.parseFloat(TO_FLOAT);
//        double toDouble = Double.parseDouble(TO_DOUBLE);

//        2. String을 Integer나 Long, Float, Double 객체로 변환하는 방법
        Integer toInt = Integer.valueOf(TO_INT);
        Long toLong = Long.valueOf(TO_LONG);
        Float toFloat = Float.valueOf(TO_FLOAT);
        Double toDouble = Double.valueOf(TO_DOUBLE);

//        3. String을 성공적으로 변환하지 못했을 때 -> NumberFormatException 예외 발생
        try{
            Integer toIntWrong1 = Integer.valueOf(WRONG_NUMBER);
        }catch (NumberFormatException e){
            System.err.println(e);
            // 핸들 예외
        }

        try{
            int toIntWrong2 = Integer.parseInt(WRONG_NUMBER);
        }catch (NumberFormatException e){
            System.err.println(e);
            // 핸들 예외
        }


    }
}
