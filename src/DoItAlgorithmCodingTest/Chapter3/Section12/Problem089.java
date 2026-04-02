package DoItAlgorithmCodingTest.Chapter3.Section12;

/*
문제089 이친수 구하기 / 백준 2193번 (실버 3)

D(점화식 배열)
D[i][0]: 길이 i에서 끝이 0으로 끝나는 이친수의 개수
D[i][1]: 길이 i에서 끝이 1로 끝나는 이친수의 개수
N(자릿수)
D 배열 초기화
D[1][1] = 1     // 1은 이친수
D[1][0] = 0     // 이친수는 0으로 시작하지 않기 때문에 1자리 0으로 끝나는 이친수는 없음
for (i -> 2 ~ N) {
    i번째 0으로 끝나는 개수 = i - 1에서 0으로 끝나는 개수 + i - 1에서 1로 끝나는 개수
    i번째 1로 끝나는 개수 = i - 1에서 0으로 끝나는 개수
}
N번째에서 0으로 끝나는 개수 + N번째에서 1로 끝나는 개수 출력하기
*/

import java.util.Scanner;

public class Problem089 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] D = new long[N + 1][2];
        D[1][0] = 0;    // 0으로 끝나는 수
        D[1][1] = 1;    // 1로 끝나는 수
        for (int i = 2; i <= N; i++) {
            D[i][0] = D[i - 1][0] + D[i - 1][1];
            D[i][1] = D[i - 1][0];
        }
        System.out.println(D[N][0] + D[N][1]);
    }
}
