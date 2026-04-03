package DoItAlgorithmCodingTest.Chapter3.Section12;

/*
문제091 계단 수 구하기 / 백준 10844번 (실버 1)

D[N][H](길이가 N일 때 높이 H로 끝나는 계단 수의 모든 경우의 수)
for (i -> 1 ~ 9) {
    D[i][1] = 1     // 길이가 1일 때 만드는 높이 H로 끝나는 계단 수의 모든 경우의 수는 1
                    // 단, 0으로 시작하는 숫자는 없기 때문에 D[1][0]은 0으로 초기화
}
for (i -> 2 ~ N) {
    D[i][0] = D[i - 1][1]       // N에서 높이가 0이면 N - 1에서는 높이가 1이어야 계단 수가 가능
    D[i][9] = D[i - 1][8]       // N에서 높이가 9면 N - 1에서는 높이가 8이어야 계단 수가 가능
    for (j -> 1 ~ 8) {
    // 높이가 1 ~ 8이면 N - 1에서 자신보다 한 단계 위 또는 한 단계 아래 높이에서 올 수 있음
    D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1])
    나온 결과를 1000000000 나머지 연산 수행하기
    }
}
sum(결괏값)
for (i -> 0 ~ 9) {
    sum에 D[N][i]의 값 모두 더하기
}
sum 출력하기
*/

import java.util.Scanner;

public class Problem091_book {
    static long mod = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long D[][] = new long[N + 1][11];
        for (int i = 1; i <= 9; i++) {      // 숫자가 0으로 시작할 수 없으므로 D[1][0]은 0으로 초기화
            D[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            D[i][0] = D[i - 1][1];
            D[i][9] = D[i - 1][8];
            for (int j = 1; j <= 8; j++) {
                D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % mod;
            }
        }
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + D[N][i]) % mod;
        }
        System.out.println(sum);
    }
}
