package DoItAlgorithmCodingTest.Chapter3.Section12;

/*
문제097 행렬 곱 연산 횟수의 최솟값 구하기 / 백준 11049번 (골드 3)

D[i][j](i ~ j번째 행렬까지 최소 연산 횟수를 저장하는 배열)
N(행렬 개수)
Matrix M[N](행렬 저장 클래스 배열)
D 배열 초기화(-1로 저장하기)
행렬 데이터 저장하기
excute(1, N)            // DP 함수 호출하기
정답 출력하기

// DP 함수(s: 시작 행렬 index, e: 종료 행렬 index)
int excute(s, e) {
    result(결괏값)
    if (이미 계산한 구간일 때) { DP[i][j]값 바로 반환 }
    if (1개 행렬일 때) { 연산 횟수 0 반환 }
    if (행렬 2개일 때) { 2개 행렬 연산값 반환 }
    if (행렬이 3개 이상일 때) {
        for (i -> s ~ e) {      // 재귀 형태로 구현하기
            excute(s, i) + excute(i + 1, e) + 앞뒤 구간의 행렬을 합치기 위한 연산 횟수
        }
    }
}
class Matrix {      // 행렬 정보 저장하기
    x(행의 개수)
    y(열의 개수)
}
*/

import java.util.Scanner;

public class Problem097_book {
    static int N;
    static Matrix[] M;
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = new Matrix[N + 1];
        D = new int[N + 1][N + 1];
        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D.length; j++) {
                D[i][j] = -1;
            }
        }
        for (int i = 1; i <= N; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            M[i] = new Matrix(y, x);
        }
        System.out.println(excute(1, N));
    }

    // 탑-다운 방식으로 점화식 함수 구현하기
    static int excute(int s, int e) {
        int result = Integer.MAX_VALUE;
        if (D[s][e] != -1) {
            return D[s][e];         // 계산했던 부분이면 다시 계산핮지 않음(메모이제이션)
        }
        if (s == e) {               // 행렬 1개의 곱셈 연산의 수
            return 0;
        }
        if (s + 1 == e) {           // 행렬 2개의 곱셈 연산의 수
            return M[s].y * M[s].x * M[e].x;
        }
        for (int i = s; i < e; i++) {                    // 행렬이 3개 이상일 때 곱셈 연산의 수 -> 점화식 처리
            result = Math.min(result, M[s].y * M[i].x * M[e].x + excute(s, i) + excute(i + 1, e));
        }
        return D[s][e] = result;
    }

    // 행렬 정보 저장 클래스
    static class Matrix {
        private int y;
        private int x;

        Matrix(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
