package DoItAlgorithmCodingTest.Chapter3.Section12;

/*
문제096 DDR을 해보자 / 백준 2342번 (골드 3)

dp[N][L][R](N개 입력까지 수행했고, 왼쪽 다리가 L, 오른쪽 다리가 ㄱR에 있을 때 힘의 최솟값)
mp(한 발을 이동할 때 드는 힘을 미리 저장하기(mp[1][2] -> 1에서 2로 이동할 때 드는 힘))
dp를 충분히 큰 수로 초기화
dp[0][0][0]을 0으로 초기화 -> 처음에는 아무 힘이 들지 않은 상태로 시작
while (모든 수열을 수행할 때까지) {
    for (i -> 0 ~ 4) {      // 오른쪽 다리를 이동해 현재 다리 위치로 만들 수 있는 경우의 수
        바로 직전 오른쪽 다리가 있을 수 있는 5가지 경우 누적 합 구하기
        dp 배열에 오른쪽 다리 이동에 필요한 힘 합산 값 중 최솟값 저장하기
    }
    for (i -> 0 ~ 4) {      // 왼쪽 다리를 이동해 현재 다리 위치로 만들 수 있는 경우의 수
        바로 직전 왼쪽 다리가 있을 수 있는 5가지 경우 누적 합 구하기
        dp 배열에 왼쪽 다리 이동에 필요한 힘 합산 값 중 최솟값 저장하기
    }
}
for (i -> 0 ~ 4) {
    for (j -> 0 ~ 4) {
        min = Math.min(min, dp[s][i][j]);       // s개의 수열을 수행했을 때 최솟값 찾기
    }
}
최솟값 출력하기
*/

import java.util.Scanner;

public class Problem096_book {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // dp[N][L][R] = N개 수열을 수행했고, 왼쪽이 L 오른쪽이 R에 있을 때 최소 누적 힘
        int dp[][][] = new int[100001][5][5];
        // 한 발을 이동할 때 드는 힘을 미리 저장하기(mp[1][2] -> 1에서 2로 이동할 떄 드는 힘)
        int mp[][] = { {0, 2, 2, 2, 2},
                       {2, 1, 3, 4, 3},
                       {2, 3, 1, 3, 4},
                       {2, 4, 3, 1, 3},
                       {2, 3, 4, 3, 1} };
        int n = 0, s = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 100001; k++) {
                    dp[k][i][j] = 100001 * 4;       // 충분히 큰 수로 초기화
                }
            }
        }
        dp[0][0][0] = 0;
        while (true) {
            n = sc.nextInt();
            if (n == 0) {           // 입력의 마지막이면 종료
                break;
            }
            for (int i = 0; i < 5; i++) {
                if (n == i) {       // 두 발이 같은 자리에 있을 수 없음
                    continue;
                }
                for (int j = 0; j < 5; j++) {
                    // 오른발을 옮겨 현재 모습이 됐을 때 최소의 힘 저장하기
                    dp[s][i][n] = Math.min(dp[s - 1][i][j] + mp[j][n], dp[s][i][n]);
                }
            }
            for (int j = 0; j < 5; j++) {
                if (n == j) {
                    continue;          // 두 발이 같은 자리에 있을 수 없음
                }
                for (int i = 0; i < 5; i++) {
                    // 왼발을 옮겨 현재 모습이 됐을 때 최소의 힘 저장하기
                    dp[s][n][j] = Math.min(dp[s - 1][i][j] + mp[i][n], dp[s][n][j]);
                }
            }
            s++;
        }
        s--;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                min = Math.min(min, dp[s][i][j]);;          // 모두 수행했을 때 최솟값 찾기
            }
        }
        System.out.println(min);
    }
}
