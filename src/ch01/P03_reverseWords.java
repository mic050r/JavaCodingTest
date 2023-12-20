package ch01;

import java.util.Map;
import java.util.Scanner;

public class P03_reverseWords {

    public static String reverseWords(String str) {
        String result = "";
        for(int i = str.length() -1 ; i >= 0; i--){
            result += str.charAt(i);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 입력
        System.out.print("문자열을 입력하세요: ");
        String inputString = scanner.nextLine();

        String result = reverseWords(inputString);

        // 3. 결과 출력
        System.out.println("뒤집은 문자 : " + result);
    }

}
