package DoItAlgorithmCodingTest.Chapter2.Section04.Unit02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

// 백준 10986번
public class Problem005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] S = new long[N];
        st = new StringTokenizer(br.readLine());
        S[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }
        long answer = 0;
        long[] C = new long[M];
        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);
            if (remainder == 0) {
                answer++;
            }
            C[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (C[i] >= 2) {
                answer += C[i] * (C[i] - 1) / 2;
            }
        }

        System.out.println(answer);
    }
}
