package DoItAlgorithmCodingTest.Chapter2.Section04.Unit03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

// 백준 2018번
public class Problem006 {
    public static void main(String[] args) throws IOException {
        // N 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long answer = 1;
        int startPointer = 0;
        int endPointer = 0;
        long sum = 0;

        while (endPointer != N) {
            if (sum == N) {
                answer++;
                sum += ++endPointer;
            } else if (sum < N) {
                sum += ++endPointer;
            } else if (sum > N) {
                sum -= startPointer++;
            }
        }

        System.out.println(answer);

    }
}
