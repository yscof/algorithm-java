package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 n을 입력하세요: ");
        long n = sc.nextLong();

        String str = String.valueOf(n);
        String[] strArr = str.split("");

        Arrays.sort(strArr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (String s : strArr) {
            sb.append(s);
        }

        long answer = Long.parseLong(sb.toString());

        System.out.println("결과: " + answer);
    }
}
