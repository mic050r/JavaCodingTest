package ch01;

import java.util.Scanner;
//주어진 문자열이 숫자만 포함하는지 검사하는 프로그램을 작성하라.

public class P04_countainsOnlyDigits {
    public static Boolean P04_countainsOnlyDigits(String str){
        Boolean result = true;
        for(int i = 0; i < str.length(); i++){
            int cp = str.codePointAt(i);
            if(!(cp >= 48 && cp <= 57)) {
                result = false;
            }
        }
        return result;
    }

    public static Boolean P04_countainsOnlyDigits1(String str){
        for(int i = 0; i< str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static Boolean P04_countainsOnlyDigits2(String str){
        return !str.chars()
                .anyMatch(n -> !Character.isDigit(n));
    }

    public static Boolean P04_countainsOnlyDigits3(String str){
        return str.matches("[0-9]+");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 입력
        System.out.print("문자열을 입력하세요: ");
        String inputString = scanner.nextLine();

        Boolean result = P04_countainsOnlyDigits3(inputString);

        // 3. 결과 출력
        System.out.println(result);

    }

}
