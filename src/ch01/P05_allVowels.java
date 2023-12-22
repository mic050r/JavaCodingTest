package ch01;

import java.util.*;

//주어진 문자열에서 모음과 자음 개수를 세는 프로그램을 작성하라.
//        대상은 자음이 5개(a,e,i,o,u)인 영어이다.
public class P05_allVowels {

    private static Map<Integer, Integer> allVowels(String str) {
        Map<Integer, Integer> result = new HashMap<>(); // 모음, 자음
        int cnt = 0;
        str = str.toLowerCase();

        for(int i = 0; i < str.length(); i++){
            switch (str.charAt(i)){
                case ('a'): cnt++; break;
                case ('e'): cnt++; break;
                case ('i'): cnt++; break;
                case ('o'): cnt++; break;
                case ('u'): cnt++; break;
            }
        }

        result.put(cnt, str.length() - cnt );
        return result;
    }

    private static final Set<Character> allVowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    public static Pair<Integer, Integer> countVowelsAndConsonants(String str){
        str = str.toLowerCase();
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(allVowels.contains(ch)) {
                vowels++;
            }
            else if((ch >= 'a' && ch <= 'z')) {
                consonants++;
            }
        }
        return Pair.of(vowels, consonants);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 입력
        System.out.print("문자열을 입력하세요: ");
        String inputString = scanner.nextLine();


        Map<Integer, Integer> result = allVowels(inputString);

        // 3. 결과 출력
        result.forEach((vowel, consonant) -> System.out.println("모음 : " +vowel + "개, 자음 : " + consonant+ "개"));
    }


}
