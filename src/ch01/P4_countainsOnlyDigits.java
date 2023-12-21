package ch01;

import java.util.Map;
import java.util.Scanner;
//주어진 문자열이 숫자만 포함하는지 검사하는 프로그램을 작성하라.

public class P4_countainsOnlyDigits {
    public static Boolean P4_countainsOnlyDigits(String str){
        Boolean result = true;
        for(int i = 0; i < str.length(); i++){
            int cp = str.codePointAt(i);
            if(!(cp >= 48 && cp <= 57)) {
                result = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 입력
        System.out.print("문자열을 입력하세요: ");
        String inputString = scanner.nextLine();

        Boolean result = P4_countainsOnlyDigits(inputString);

        // 3. 결과 출력
        System.out.println(result);

    }

}
