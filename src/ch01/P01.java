package ch01;
import java.util.Scanner;
public class P01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); System.out.print("문자입력 : ");
        String str = sc.nextLine();
        System.out.println("주어진 문자열의 문자 개수 : " + str.length());
    }
}
