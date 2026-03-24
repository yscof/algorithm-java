package DoItAlgorithmCodingTest.Chapter2.Section04.Unit03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

// 백준 1940
public class Problem007 {
    public static void main(String[] args) throws IOException {
        // N(재료의 개수), M(갑옷을 만드는데 필요한 수) 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        // 재료들 입력 받기
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 재료들 오름차순으로 정렬
        Arrays.sort(A);

        // 투 포인터 start=0 end=N-1
        int start = 0;
        int end = N - 1;
        long sum = 0;
        int answer = 0;
        // sum == M 이면 answer++; start++
        // sum < M 이면 start++
        // sum > M 이면 end--
        while (start != end) {
            sum = A[start] + A[end];
            if (sum == M) {
                answer++;
                start++;
            } else if (sum > M) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(answer);
    }
}
