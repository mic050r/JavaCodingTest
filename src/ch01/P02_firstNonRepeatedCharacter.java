package ch01;
// 주어진 문자열에서 반복되지 않는 첫 번째 문자를 반환하는 프로그램을 작성하라.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P02_firstNonRepeatedCharacter {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 입력
        System.out.print("문자열을 입력하세요: ");
        String str = scanner.nextLine();

        // HashMap 선언
        HashMap<Character, Integer> countChar = new HashMap<>();
        int min = 100000;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // 각 문자의 빈도수 세기
            countChar.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        // 빈도수가 1인 문자 구하기
        ArrayList<Character> index = new ArrayList<>(); // 빈도수가 1인 문자를 담은 배열 선언

        countChar.forEach((key, value) -> { // forecah문으로 HashMap 전체 값 불러오기
//            System.out.println(key +" " + value);
            if (value == 1) {
                index.add(key);
            }
        });

        // 그 문자들 중에서 str의 indexOf를 사용하여 인덱스를 구하기
        for (Character character : index) { // forecah문으로 ArrayList 전체 값 불러오기
//            System.out.println(character);
            int strIndex = str.indexOf(character);
//            System.out.println(strIndex);
            // 제일 작은 인덱스 값을 구하기
            if (min > strIndex) {
                min = strIndex;
            }
        }

        char result = str.charAt(min);


        // 결과 출력
        System.out.println("반복되지 않는 첫 번째 문자 : " + result);
    }
}
