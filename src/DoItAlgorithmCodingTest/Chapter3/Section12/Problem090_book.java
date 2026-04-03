package DoItAlgorithmCodingTest.Chapter3.Section12;

/*
문제090 2*N 타일 채우기 / 백준 11726번 (실버 3)

D[N](길이가 2 X N인 직사각형에 2 X 1, 1 X 2 타일을 붙일 수 있는 경우의 수)
D[1] = 1        // 길이가 2 X 1일 때 타일의 경우의 수
D[2] = 2        // 길이가 2 X 2일 때 타일의 경우의 수
for (i -> 3 ~ N) {
    D[i] = D[i - 1] + D[i - 2]      // N - 1 길이일 때 경우의 수 + N - 2 길이일 때 경우의 수
    나온 결과를 10007 나머지 연산 수행하기
}
D[N]값 출력하기
*/

import java.util.Scanner;

public class Problem090_book {
    static long mod = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long D[] = new long[1001];
        D[1] = 1;       // 길이가 2 X 1일 때 타일의 경우의 수
        D[2] = 2;       // 길이가 2 X 2일 때 타일의 경우의 수
        for (int i = 3; i <= N; i++) {
            D[i] = (D[i - 1] + D[i - 2]) % mod;
        }
        System.out.println(D[N]);
    }
}
