package ch01;
// 주어진 문자열에서 반복되지 않는 첫 번째 문자를 반환하는 프로그램을 작성하라.

import java.util.*;

public class P02_firstNonRepeatedCharacter {

    private static final int EXTENDD_ASCII_CODES = 256;
    public static Character main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 입력
        System.out.print("문자열을 입력하세요: ");
        String str = scanner.nextLine();

        // 두번째 해법
        // 각 문자마다 문자열을 순회하며 빈도수를 세고, 문자가 중복이면 루프를 종료하고 다음 문자로 넘어가도록
        // LinkedHashMap 이용

        // HashMap 선언
        LinkedHashMap<Character, Integer> chars = new LinkedHashMap<>();
        int min = 100000;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // 각 문자의 빈도수 세기
            chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        for(Map.Entry<Character, Integer> entry : chars.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }
}
