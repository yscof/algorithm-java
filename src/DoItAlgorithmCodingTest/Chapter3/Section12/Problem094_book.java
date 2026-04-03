package DoItAlgorithmCodingTest.Chapter3.Section12;

/*
문제094 가장 큰 정사각형 찾기 / 백준 1915번 (골드 4)

D[i][j] (i, j 위치에서 왼쪽 위로 만들 수 있는 최대 정사각형 길이를 저장하는 배열)
n(배열의 세로 길이)
m(배열의 가로 길이)
max(최댓값 저장하기)
for (i -> 0 ~ n) {
    for (j -> 0 ~ m) {
        D[i][j]의 값이 1이면 자신의 위, 왼쪽, 대각선 위의 값들 중 최솟값 +1 값을 저장하기
        D[i][j]의 값이 최댓값보다 크다면 최댓값 업데이트
    }
}
정답(최댓값 * 최댓값) 출력하기
*/

import java.util.Scanner;

public class Problem094_book {
    public static void main(String[] args) {
        long[][] D = new long[1001][1001];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long max = 0;
        for (int i = 0; i < n; i++) {
            String mline = sc.next();
            for (int j = 0; j < m; j++) {
                D[i][j] = Long.parseLong(String.valueOf(mline.charAt(j)));
                if (D[i][j] == 1 && i > 0 && j > 0) {
                    D[i][j] = Math.min(D[i -1][j -1], Math.min(D[i -1][j], D[i][j -1])) + 1;
                }
                if (D[i][j] > max) {
                    max = D[i][j];
                }
            }
        }
        System.out.println(max * max);
    }
}
