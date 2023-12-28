package ch01;

public class P10_permuteAndPrint {
    // 문자열의 순열을 출력하는 메서드
    public static void permuteAndPrint(String str) {
        // 초기 호출을 위한 오버로드된 메서드 호출
        permuteAndPrint("", str);
    }

    // 순열을 생성하고 출력하는 재귀적인 도우미 메서드
    private static void permuteAndPrint(String prefix, String str) {
        // 현재 남아 있는 문자열의 길이
        int n = str.length();

        // 남아 있는 문자열이 없으면 현재까지의 순열 출력
        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            // 문자열의 각 문자에 대해 재귀 호출을 수행하여 순열 생성
            for (int i = 0; i < n; i++) {
                // 현재 문자를 prefix에 추가하고 해당 문자를 제외한 나머지 문자열을 재귀 호출로 전달
                permuteAndPrint(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i));
            }
        }
    }

    // 메인 메서드: 주어진 문자열의 순열을 출력
    public static void main(String[] args) {
        // 원하는 문자열로 변경 가능
        String inputString = "abc";

        // 입력 문자열의 순열을 출력
        System.out.println("Permutations of " + inputString + ":");
        P10_permuteAndPrint.permuteAndPrint(inputString);
    }
}
