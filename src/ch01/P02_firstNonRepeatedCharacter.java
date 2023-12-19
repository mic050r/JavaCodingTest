package ch01;
// 주어진 문자열에서 반복되지 않는 첫 번째 문자를 반환하는 프로그램을 작성하라.

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02_firstNonRepeatedCharacter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 입력
        System.out.print("문자열을 입력하세요: ");
        String str = scanner.nextLine();

        // 세 번째 해법 : 스트림 사용
        Map<Integer, Long> chs = str.codePoints()
                .mapToObj(cp -> cp)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));

        int cp = chs.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));

        String result = String.valueOf(Character.toChars(cp));

        System.out.println(result);
    }
}
