package DoItAlgorithmCodingTest.Chapter3.Section12;

/*
문제095 빌딩 순서 구하기 / 백준 1328번 (골드 1)

D[N][L][R](빌딩 N개를 왼쪽에서 L개, 오른쪽에서 R개가 보이도록 배치할 수 있는 모든 경우의 수)
D[1][1][1] = 1      //건물이 1개일 때 배치될 경우의 수는 1개
for (i -> 2 ~ N) {
    for (j -> 1 ~ L) {
        for (k -> 1 ~ R) {
            D[i][j][k] = D[i - 1][j][k] * (i - 2) +     // 가장 작은 빌딩을 가운데에 놓는 경우
            D[i - 1][j][k - 1] +                        // 가장 작은 빌딩을 오른쪽에 놓는 경우
            D[i - 1][j - 1][k]                          // 가장 작은 빌딩을 왼쪽에 놓는 경우
            나온 결과에 1000000007 나머지 연산 수행하기
        }
    }
}
D[N][L][R] 값 출력하기
*/

import java.util.Scanner;

public class Problem095_book {
    static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();
        long D[][][] = new long[101][101][101];
        D[1][1][1] =1 ;         // 빌딩이 1개이면 놓을 수 있는 경우의 수는 1개
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                for (int k = 1; k <= R; k++) {
                    D[i][j][k] = (D[i - 1][j][k] * (i - 2) + D[i - 1][j][k - 1] + D[i - 1][j - 1][k]) % mod;
                }
            }
        }
        System.out.println(D[N][L][R]);
    }
}
