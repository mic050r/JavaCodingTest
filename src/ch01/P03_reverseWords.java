package ch01;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P03_reverseWords {

    // 공백 문자 상수 정의
    private static final String WHITESPACE = " ";
    // 단어를 뒤집어 반환하는 메서드
    public static String reverseWords1(String str) {
        // 입력 문자열을 공백을 기준으로 분리하여 배열에 저장
        String[] words = str.split(WHITESPACE);
        // 결과를 저장할 StringBuilder 객체 생성
        StringBuilder reversedString = new StringBuilder();

        // 각 단어를 반복하며 뒤집은 후 결과 문자열에 추가
        for (String word : words) {
            // 단어를 뒤집기 위한 StringBuilder 객체 생성
            StringBuilder reverseWord = new StringBuilder();

            // 단어의 각 문자를 끝에서부터 시작하여 뒤집어서 reverseWord에 추가
            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }

            // 결과 문자열에 뒤집은 단어와 공백 추가
            reversedString.append(reverseWord).append(WHITESPACE);
        }

        // 최종 결과 문자열 반환
        return reversedString.toString();
    }

    // 정규표현식 패턴: 하나 이상의 공백을 찾음
    private static final Pattern PATTERN = Pattern.compile(" +");

    // 단어를 뒤집어 반환하는 메서드
    public static String reverseWords(String str) {
        // 정규표현식을 사용하여 문자열을 공백을 기준으로 분리하고 스트림으로 변환
        return PATTERN.splitAsStream(str)
                // 각 단어를 뒤집은 후 스트림으로 반환
                .map(w -> new StringBuilder(w).reverse())
                // 뒤집은 단어를 공백으로 연결하여 문자열로 반환
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 1. 입력
        System.out.print("문자열을 입력하세요: ");
        // 사용자로부터 문자열 입력 받기
        String inputString = scanner.nextLine();

        // 입력 받은 문자열을 뒤집은 결과를 얻음
        String result = reverseWords(inputString);

        // 3. 결과 출력
        System.out.println("뒤집은 문자 : " + result);
    }
}
