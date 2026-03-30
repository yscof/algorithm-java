package DoItAlgorithmCodingTest.Chapter2.Section06.Unit02;

import java.util.Scanner;

public class Problem026_book {
    static int N, M;
    static boolean[] V;     // 숫자 사용 여부 저장하기
    static int[] S;         // 숫자 정보 저장하기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        S = new int[N];
        V = new boolean[N];
        backtracking(0);
    }

    private static void backtracking(int length) {
        if (length == M) {      // 길이가 M인 수열이 만들어진 경우
            printArray();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!V[i]) {
                V[i] = true;        // 수 사용 저장하기
                S[length] = i;      // 수열에 수 사용하기
                backtracking(length + 1);
                V[i] = false;       // 수 반납 저장하기
            }
        }
    }

    private static void printArray() {      // 수열 내용 출력하기
        for (int i = 0; i < M; i++) {
            System.out.print(S[i] + 1 + " ");
        }
        System.out.println();
    }
}

/*
문제026 N과 M / 백준 15649번 (실버 3)

N, M(1~N까지 자연수를 선택하여 길이가 M인 수열 모두 구하기)
V(숫자 사용 여부 저장 배열)
S(수열 정보 저장 배열)
백트래킹 실행(매개변수: 수열의 길이)

// 백트래킹 상세 구현하기
backtracking(수열 길이) {
    if (길이가 M인 수열이 만들어진 경우) {
        수열 정보 출력 및 함수 반환
    }
    for (1~N까지 자연수 탐색) {        // 자연스럽게 사전순으로 출력되도록 탐색 기준 설정하기
        if (아직 수열에 포함되지 않은 수인 경우) {
            V 배열에 수 사용  표시
            수열에 수 추가
            수열 길이는 1증가시키고 backtracking 함수 재귀 호출
            V 배열에 수 사용 표시 제거
        }
    }
}
*/