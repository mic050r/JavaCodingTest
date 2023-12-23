package ch01;

import java.util.HashMap;
import java.util.Scanner;

//주어진 문자열에서 특정 문자의 빈도수를 세는 프로그램을 작성하라.
public class P06_countOccurrencesOfAcertainCharacter {

    public static Integer countOccurrencesOfAcertainCharacter(String str, String ch){
        HashMap<Character, Integer> counts = new HashMap<>(); // 문자, 빈도수
        int result; // 특정 문자의 빈도수를 담을 변수
        char target = ch.charAt(0); // 특정 문자를 target에 담기

        // 빈도수 세기
        for(int i = 0; i < str.length(); i++){
            char cha = str.charAt(i);
            counts.compute(cha, (k, v) -> (v == null) ? 1 : ++v);
        }

        // 특정 문자가 입력한 문자에 없을 때를 대비해 예외처리
        if(str.contains(ch)){
            result = counts.get(target); // 해쉬맵에서 특정문자의 빈도수 가져오기
        } else {
            return 0;
        }

        return result;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String InpputString = sc.next();

        System.out.print("특정 문자 입력 : ");
        String ch = sc.next();

        int result = countOccurrencesOfAcertainCharacter(InpputString, ch);
        System.out.println(ch + "의 빈도수 : " + result);
    }

}
