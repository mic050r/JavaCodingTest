package ch01;
// 주어진 문자열에서 반복되지 않는 첫 번째 문자를 반환하는 프로그램을 작성하라.

import java.util.Scanner;

public class P02_firstNonRepeatedCharacter {

    private static final int EXTENDD_ASCII_CODES = 256;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 입력
        System.out.print("문자열을 입력하세요: ");
        String str = scanner.nextLine();

        // 첫번째 해법
        // 문자열을 한 번 순회하면서 배열을 생성해 문자열에서 한 번만 나오는 문자들의 인덱스를 저장한다.
        // 이후 반복 되지 않는 문자들을 포함하는 이 배ㅕㄹ에서 가장 작은 인덱스를 반환한다.
        int[] flags = new int[EXTENDD_ASCII_CODES];

        for(int i = 0; i < flags.length; i++){
            flags[i] = -1;
        }

        for(int i = 0; i <str.length(); i++){
            char ch = str.charAt(i);
            if(flags[ch] == -1){
                flags[ch] = i;
            } else {
                flags[ch] = -2;
            }
        }

        int position = Integer.MAX_VALUE;
        for(int i = 0; i < EXTENDD_ASCII_CODES; i++){
            if(flags[i] >= 0){
                position = Math.min(position, flags[i]);
            }
        }

        char result = (position == Integer.MAX_VALUE) ? Character.MIN_VALUE : str.charAt(position);
        // 결과 출력
        System.out.println("반복되지 않는 첫 번째 문자 : " + result);
    }
}
