package ch01;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_CountDuplicateCharacters {
    // 첫 번째 해법 : 문자열 내 문자를 순회하며 Map을 사용해  문자를 키로, 빈도수를 값으로 저장하는 방법
    // 현재 문자가 Map에 없으면 (character, 1)을 추가한다. 현재 문자가 Map에 있으면 (character, occurrences+1)처럼 빈도수를 1증가시킨다.
//    public static Map<Character, Integer> countDuplicateCharacters(String str){
//        Map<Character, Integer> result = new HashMap<>();
//
//        for (int i = 0; i < str.length(); i++) {
//            int cp = str.codePointAt(i);
//            char ch = Character.toChars(cp)[0];
//
//            if (Character.charCount(cp) == 2) { // 2는 대리쌍을 뜻함
//                i++;
//            }
//
//            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
//        }
//
//        return result;
//    }

    // 두 번째 해법 : 자바 8의 스트림 기능 활용
    public static Map<String, Long> countDuplicateCharacters(String str){
        Map<String, Long> result = str.codePoints()
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(c->c,Collectors.counting()));

        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 문자열을 입력 받습니다.
        System.out.print("문자열을 입력하세요: ");
        String inputString = scanner.nextLine();

        // countDuplicateCharacters 메서드를 호출하여 중복 문자의 빈도수를 계산합니다.
        Map<String, Long> result = countDuplicateCharacters(inputString);

        // 결과를 출력합니다.
        System.out.println("각 문자의 빈도수:");
        result.forEach((character, count) -> System.out.println(character + ": " + count));
    }
}
