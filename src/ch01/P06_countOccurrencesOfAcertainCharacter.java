package ch01;

import java.util.HashMap;
import java.util.Scanner;

//주어진 문자열에서 특정 문자의 빈도수를 세는 프로그램을 작성하라.
public class P06_countOccurrencesOfAcertainCharacter {

    public static Integer countOccurrencesOfAcertainCharacter(String str, String ch) {
        HashMap<Character, Integer> counts = new HashMap<>(); // 문자, 빈도수
        int result; // 특정 문자의 빈도수를 담을 변수
        char target = ch.charAt(0); // 특정 문자를 target에 담기

        // 빈도수 세기
        for (int i = 0; i < str.length(); i++) {
            char cha = str.charAt(i);
            counts.compute(cha, (k, v) -> (v == null) ? 1 : ++v);
        }

        // 특정 문자가 입력한 문자에 없을 때를 대비해 예외처리
        if (str.contains(ch)) {
            result = counts.get(target); // 해쉬맵에서 특정문자의 빈도수 가져오기
        } else {
            return 0;
        }

        return result;
    }

    public static int countOccurrencesOfAcertainCharacter1(String str, char ch) {
        // 1. 주어진 문자열에서 해당 문자를 전부 ""로 치환
        // 2. 원래 문자열의 길이에서 첫 번쨰 단계에서 얻은 문자열의 길이를 뺀다.
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    public static int countOccurrencesOfAcertainCharacter2(String str, String ch) {

        if(ch.codePointCount(0, ch.length()) > 1){
            // 주어진 문자열에 유니코드 문자가 둘 이상이면
            return -1;
        }

        int result = str.length() - str.replace(ch, "").length();

        // ch.length()가 2를 반환하면 유니코드 대리 쌍이라는 뜻
        return ch.length() == 2 ? result/2 : result;
    }


    public static int countOccurrencesOfAcertainCharacter3(String str, char ch) {
       int count = 0;

       for(int i = 0; i < str.length(); i++){
           if(str.charAt(i) == ch) { // 특정 문자와 입력받은 문자열의 문자와 같으면 count 1 증가
               count++;
           }
       }
       return count;
    }

    public static int countOccurrencesOfAcertainCharacter4(String str, char ch) {
        // 1. filter() 사용
        // str.chars() 메서드를 사용하여 문자열을 IntStream으로 변환하고,
        // filter 메서드를 이용하여 특정 문자와 일치하는 문자들만 남기고 나머지는 제거.
        // 최종적으로 count 메서드를 사용하여 일치하는 문자의 개수를 세어 반환
        return (int) str.chars().filter(c -> c == ch).count();

    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String inputString = sc.next();

        System.out.print("특정 문자 입력 : ");
        char ch = sc.next().charAt(0);

        int result = countOccurrencesOfAcertainCharacter3(inputString, ch);
        System.out.println(ch + "의 빈도수 : " + result);

        sc.close(); // Scanner 객체 닫기
    }
}
