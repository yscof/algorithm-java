package DoItAlgorithmCodingTest.Chapter2.Section04.Unit02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem004 {
    public static void main(String[] args) throws IOException {
        // N(2차원 배열의 크기), M(구간 합 질의 갯수) 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N+1][N+1];
        int[][] S = new int[N+1][N+1];
        // 2차원 배열 생성
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + A[i][j];
            }
        }
        // 구간 합 질의 답 구하기
        for (int i = 0; i < M; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(S[x2][y2] - S[x2][y1-1] - S[x1-1][y2] + S[x1-1][y1-1]);
        }
    }
}
