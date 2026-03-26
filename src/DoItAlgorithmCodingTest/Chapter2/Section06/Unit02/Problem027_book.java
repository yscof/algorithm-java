package DoItAlgorithmCodingTest.Chapter2.Section06.Unit02;

/*
A(퀀 배치 정보 저장 배열)
N(체스판 크기 N*N)
cnt(퀸을 배치하는 경우의 수 저장 변수)

백트래킹 실행(매개변수: 행)
경우의 수 출력

// 백트래킹 상세 구현하기
backtracking(현재 행) {
    if (퀸 N개를 모두 배치한 경우) {
        경우의 수 1 증가 및 함수 반환
    }
    for (1~N까지 모든 열 탐색) {
        i열에 퀸 배치
        if (이번 행에 배치한 퀸이 이전 퀸들과 공격할 수 없는 경우) { // check 함수로 판단하기
            행의 값을 1 증가시키고 backtracking 함수 재귀 호출
        }
    }
}

// 공격 불가능 여부 체크 함수 상세 구현하기
check (현재 행) {
    for (0행부터 현재 행 전까지 배치된 모든 퀸 탐색) {
        if (이번에 배치한 퀸과 일직선 배치가 있는 경우) { 공격 가능 반환 }
        if (이번에 배치한 퀸과 대각선 배치가 있는 경우) { 공격 가능 반환 }
    }
    공격 불가능 반환
}
 */

import java.util.Scanner;

// 문제 027 N-Queen 배치하기 / 백준 9663번 (빈출)
public class Problem027_book {
    static int[] A;         // 퀸 배치 정보 저장하기
    static int N;           // 체스판 크기 N*N
    static int cnt = 0;     // 퀸을 배치하는 경우의 수 저장하기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        backtracking(0);
        System.out.println(cnt);
    }

    private static void backtracking(int row) {
        if (row == N) {     // 퀸 N개를 모두 배치한 경우
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            A[row] = i;
            if (check(row)) {       // 배치한 퀸이 이전 퀸들과 서로 공격할 수 없는지 체크하기
                backtracking(row + 1);
            }
        }
    }

    private static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (A[i] == A[row]) return false;       // 일직선 배치
            if (Math.abs(row - i) == Math.abs(A[row] - A[i])) return false;     // 대각선 배치
        }
        return true;
    }
}
