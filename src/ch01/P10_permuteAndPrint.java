package ch01;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class P10_permuteAndPrint {
    // 문자열의 순열을 출력하는 메서드
    public static Set<String> permuteAndStore(String str) {
        // 초기 호출을 위한 오버로드된 메서드 호출
        return permuteAndStore("", str);
    }

    // 순열을 생성하고 출력하는 재귀적인 도우미 메서드
    private static Set<String> permuteAndStore(String prefix, String str) {
        Set<String> permutations = new HashSet<>();
        // 현재 남아 있는 문자열의 길이
        int n = str.length();

        // 남아 있는 문자열이 없으면 현재까지의 순열 출력
        if (n == 0) {
            permutations.add(prefix + " ");
        } else {
            // 문자열의 각 문자에 대해 재귀 호출을 수행하여 순열 생성
            for (int i = 0; i < n; i++) {
                // 현재 문자를 prefix에 추가하고 해당 문자를 제외한 나머지 문자열을 재귀 호출로 전달
                permutations.addAll(permuteAndStore(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i)));
            }
        }
        return permutations;
    }

    private static void permutendPrintStream(String prefix, String str){
        int n = str.length();

        if(n == 0){
            System.out.print(prefix + " ");
        } else {
            IntStream.range(0, n)
                    .parallel()
                    .forEach(i -> permutendPrintStream(prefix + str.charAt(i),
                            str.substring(i+1, n) + str.substring(0,i)));
        }
    }
    public static void main(String[] args) {
        // 원하는 문자열로 변경 가능
        String inputString = "abc";

        // 주어진 문자열의 순열을 생성하고 저장하는 메서드 호출
        Set<String> permutations = P10_permuteAndPrint.permuteAndStore(inputString);

        // 결과 출력
//        System.out.println("Permutations of " + inputString + ":");
//        for (String permutation : permutations) {
//            System.out.print(permutation);
//        }

        System.out.println("Permutations of " + inputString + ":");
        permutendPrintStream("", inputString);
    }
}
