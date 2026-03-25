package DoItAlgorithmCodingTest.Chapter2.Section04.Unit03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

// 문제 008 '좋은 수 구하기'
// 백준 1253번
public class Problem008 {
    public static void main(String[] args) throws IOException {
        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        // N개의 정수 배열 입력받기
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 배열 정렬
        Arrays.sort(A);
        int answer = 0;
        // 투 포인터로 탐색
        for (int i = 0; i < N; i++) {
            int startPointer = 0;
            int endPointer = N - 1;
            while (startPointer < endPointer) {
                if (A[startPointer] + A[endPointer] == A[i]) {
                    if (startPointer != i && endPointer != i) {
                        answer++;
                        break;
                    } else if (startPointer == i) {
                        startPointer++;
                    } else if (endPointer == i) {
                        endPointer--;
                    }
                } else if (A[startPointer] + A[endPointer] > A[i]) {
                    endPointer--;
                } else {
                    startPointer++;
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}
