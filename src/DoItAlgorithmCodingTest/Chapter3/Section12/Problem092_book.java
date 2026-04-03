package DoItAlgorithmCodingTest.Chapter3.Section12;

/*
문제092 연속된 정수의 합 구하기 / 백준 13398번 (골드 5)

M(배열 크기) A(수열 데이터 저장 배열)
L(왼쪽에서 오른쪽 방향으로 index를 포함한 최대 연속 합을 나타내는 배열)
R(오른쪽에서 왼쪽 방향으로 index를 포함한 최대 연속 합을 나타내는 배열)
for (i -> 0 ~ N) {
    A 배열 저장하기
}
for (i -> 1 ~ N) {
    L[i] = Math.max(A[i], L[i - 1] + A[i]);     // 왼쪽 합 배열(L) 저장하기
    L 배열의 최대값을 정답 변수에 저장하기               // 1개도 삭제하지 않을 때 최댓값
}
for (i -> N - 2 ~ 0) {
    R[i] = Math.max(A[i], R[i + 1] + A[i]);     // 오른쪽 합 배열(R) 저장하기
}
for (i -> 1 ~ N - 1) {
    기존 정답 변숫값과 L[i - 1] + R[i + 1]로 계산한 값 중 최댓값
    // L[i - 1] + R[i - 1]은 수열에서 i번째 수를 삭제했을 때 구할 수 있는 최대 연속 합
}
최대값 출력하기
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem092_book {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 오른쪽 방향으로 index를 포함한 최대 연속 합 구하기
        int[] L = new int[N];
        L[0] = A[0];
        int result = L[0];
        for (int i = 1; i < N; i++) {
            L[i] = Math.max(A[i], L[i - 1] + A[i]);
            result = Math.max(result, L[i]);        // 1개도 제거하지 않았을 때를 기본 최댓값으로 저장하기
        }
        // 왼쪽 방향으로 index를 포함한 최대 연속 합 구하기
        int[] R = new int[N];
        R[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            R[i] = Math.max(A[i], R[i + 1] + A[i]);
        }
        // L[i - 1] + R[i + 1] 2개의 구간 합 배열을 더하면 i번째 값을 제거한 효과를 얻음
        for (int i = 1; i < N - 1; i++) {
            int temp = L[i - 1] + R[i + 1];
            result = Math.max(result, temp);
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
