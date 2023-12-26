package ch01;
import java.util.*;
import java.util.stream.Collectors;

public class P9_joinByDelimiter {
    public static String joinByDelimiter(String[] str, String delimiter) {
        StringBuilder resultBuilder = new StringBuilder();

        // 배열의 모든 요소에 대해 반복
        for (int i = 0; i < str.length - 1; i++) {
            // 현재 요소를 StringBuilder에 추가하고 구분자를 뒤에 붙임
            resultBuilder.append(str[i]).append(delimiter);
        }

        // 배열의 마지막 요소에 대한 처리
        if (str.length > 0) {
            // 마지막 요소를 구분자와 함께 StringBuilder에 추가
            resultBuilder.append(str[str.length - 1]);
        }

        // StringBuilder를 String으로 변환하여 최종 결과 반환
        return resultBuilder.toString();
    }

    public static String joinByDelimiter1(String[] str, String delimiter) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        for(i = 0; i < str.length -1; i++){
            result.append(str[i]).append(delimiter);
//            Hello,world,Java,
        }
        result.append(str[i]); // i = 3
        return result.toString();
//        Hello,world,Java,programming
    }

    public static String joinByDelimiter2(String[] str, String delimiter) {
        StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));

        for (String arg : str){
            joiner.add(arg);
        }
        return joiner.toString();
    }

    public static String joinByDelimiter3(String[] str, String delimiter) {
        // 배열을 스트림으로 변환하고, 지정된 범위 내에서 요소를 가져온 후 구분자를 사용하여 문자열로 결합
        return Arrays.stream(str, 0, str.length)
                .collect(Collectors.joining(String.valueOf(delimiter)));
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String inputString[] = {"Hello", "world", "Java", "programming"};

        System.out.print("구분자 입력 : ");
        String delimiter = sc.nextLine();

        String result = joinByDelimiter2(inputString, delimiter);
        System.out.println(result);

        // StringJoin(CharSequence delimiter, CharSequence ...elems)
        String result3 = String.join(" ", "Hello", "world", "Java");
    }
}
