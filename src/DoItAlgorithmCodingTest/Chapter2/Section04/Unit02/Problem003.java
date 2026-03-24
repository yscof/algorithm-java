package DoItAlgorithmCodingTest.Chapter2.Section04.Unit02;

import java.util.Scanner;

public class Problem003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N+1];
        int[] S = new int[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
            S[i] = S[i-1] + A[i];
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(S[end] - S[start - 1]);
        }
    }
}
