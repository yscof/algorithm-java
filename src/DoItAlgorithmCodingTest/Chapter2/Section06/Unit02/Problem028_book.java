package DoItAlgorithmCodingTest.Chapter2.Section06.Unit02;

/*
문제028 색종이 붙이기 / 백준 17136번 (골드 2)

M(종이 상태 저장 배열)
S(남은 색종이 수 저장 배열)
result(최소로 사용한 개수 저장)

10x10 크기의 종이 데이터 저장하기
백트래킹 실행(매개변수: 탐색 위치, 사용한 색종이 수)
if (1을 모두 덮지 못할 경우) {
    -1을 출력
} else {
    최소로 사용한 색종이 개수 출력
}

// 백트래킹 상세 구현하기
backtracking(탐색 위치, 사용한 색종이 수) {
    if (1이 적힌 모든 칸을 색종이로 붙이고 x, y 좌표를 끝까지 탐색한 경우) {
        최소로 사용한 개수 업데이트 및 함수 반환
        if (최소로 사용한 색종이 수보다 현재 탐색에서 사용한 색종이 수가 많으면) {
            함수 반환
        }
        if (현재 위치가 1이면) {
            크기가 큰 순서부터 색종이 5종류 중 재고가 있는 색종이 붙여 보기
            if (붙일 수 있으면) {
                해당 크기의 색종이 재고 1 감소
                종이 붙이기: 종이로 덮이는 부분 1 -> 0으로 변경
                현재 사용한 색종이 수를 1증가시키고 다음 위치로 좌표를 이동하여
                backtracking 함수 재귀 호출
                해당 크기의 색종이 재고 1 증가
                종이 떼어 내기: 기존에 덮인 부분 0 -> 1로 변경
            }
        }
    } else {
        좌표를 다음 위치로 이동하여 backtracking 함수 재귀 호출
    }
}
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem028_book {
    static int[][] M = new int[10][10];
    static int[] S = {0, 5, 5, 5, 5, 5};       // 남은 색종이 수
    static int result = Integer.MAX_VALUE;      // 최소로 사용한 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1이 적힌 모든 칸을 붙일 때 사용한 색종이 개수에 대한 경우의 수를 백트래킹으로 탐색
        backtracking(0, 0);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static void backtracking(int xy, int useCnt) {
        // 색종이로 1이 적힌 모든 칸을 붙였을 때(x, y 좌표를 끝까지 탐색한 경우) 탐색 종료
        if (xy == 100) {
            result = Math.min(useCnt, result);
            return;
        }
        int x = xy % 10;
        int y = xy / 10;

        // 가지치기: 이전에 최소로 사용한 색종이 수보다 현재 탐색에서 사용한 색종이 수가 많으면 탐색 중단
        if (result <= useCnt) {
            return;
        }
        if (M[y][x] == 1) {
            for (int i = 5; i > 0; i--) {
                if (S[i] > 0 && check(x, y, i)) {
                    S[i]--;                      // 종이 사용하기
                    fill(x, y, i, 0);       // 종이 붙이기: 종이로 덮이는 부분 1 -> 0으로 변경
                    backtracking(xy + 1, useCnt + 1);
                    S[i]++;                      // 사용한 종이 다시 채우기
                    fill(x, y, i, 1);       // 종이 떼어 내기: 기존에 덮인 부분을 0 -> 1로 변경
                }
            }
        } else {
            backtracking(xy + 1, useCnt);   // 현재 좌표의 값이 0이면 바로 다음 칸으로 이동
        }
    }

    static void fill(int x, int y, int size, int num) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                M[i][j] = num;
            }
        }
    }

    static boolean check(int x, int y, int size) {
        if (x + size > 10 || y + size > 10) {
            return false;
        }
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (M[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
