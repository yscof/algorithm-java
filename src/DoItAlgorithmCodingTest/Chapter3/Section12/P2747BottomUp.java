package DoItAlgorithmCodingTest.Chapter3.Section12;

/*
피보나치수 / 백준 2747번 (브론즈 2)

Bottom-Up 방식

*/

import java.util.Scanner;

public class P2747BottomUp {
    static int[] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        D = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            D[i] = -1;
        }
        D[0] = 0;
        D[1] = 1;
        for (int i = 2; i <= n; i++) {
            D[i] = D[i - 1] + D[i - 2];
        }
        System.out.println(D[n]);
    }
}
