package ch01;

import java.util.Scanner;

public class P08_removeWhitespaces {

    public static String removeWhitespaces(String str) {
        str = str.replaceAll(" ", "");
        return str;
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열 입력 : " );
        String InputString = sc.nextLine();

        String result = removeWhitespaces(InputString);
        System.out.println(result);
    }
}
