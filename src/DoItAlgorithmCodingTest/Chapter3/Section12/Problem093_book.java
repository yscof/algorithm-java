package DoItAlgorithmCodingTest.Chapter3.Section12;

/*
문제093 최장 공통 부분 수열 찾기 / 백준 9252번 (골드 4)

DP(2차원 점화식 배열), A(1번째 문자열), B(2번째 문자열)
Path(LCS 저장 리스트)
for (i -> 1 ~ A 문자열 길이) {
    for (j -> 1 ~ B 문자열 길이) {
        A[i]와 B[i]가 같으면 DP[i][j]의 값을 왼쪽 대각선값 +1로 저장하기
        다른 경우에는 왼쪽의 값과 위의 값 중 큰 값으로 DP[i][j] 채우기
    }
}
DP의 마지막 값을 출력하기(LCS 길이)
getTex() 함수를 이용해 LCS 문자열 출력하기
// LCS 문자열을 구하는 함수
getTex(row, column) {       // 재귀 형태로 구현하기
    A[row]와 B[column]이 같으면 LCS에 기록, 대각선 왼쪽 위로 이동
    // getTex(row - 1, column - 1)
    다른 경우 왼쪽 값과 위의 값 중 값이 더 큰 쪽으로 이동하기
    // getTex(row - 1, column) 또는 getTex(row, column - 1)
}
*/

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Problem093_book {
    private static long[][] DP;
    private static ArrayList<Character> Path;
    private static char[] A;
    private static char[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();
        DP = new long[A.length + 1][B.length + 1];
        Path = new ArrayList<Character>();
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;        // 같은 문자열일 때 왼쪽 대각선값 + 1
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);        // 다르면 왼쪽과 위의 값 중 큰 수
                }
            }
        }
        System.out.println(DP[A.length][B.length]);
        getText(A.length, B.length);
        for (int i = Path.size() - 1; i >= 0; i--) {
            System.out.print(Path.get(i));
        }
        System.out.println();
    }

    private static void getText(int r, int c) {     // LCS 출력 함수
        if (r == 0 || c == 0) return;
        if (A[r - 1] == B[c - 1]) {                 // 같으면 LCS에 기록하고 왼쪽 위로 이동
            Path.add(A[r - 1]);
            getText(r - 1, c - 1);
        } else {
            if (DP[r - 1][c] > DP[r][c - 1]) {      // 다르면 왼쪽과 위쪽 중 큰 수로 이동
                getText(r - 1, c);
            } else {
                getText(r, c - 1);
            }
        }
    }
}
