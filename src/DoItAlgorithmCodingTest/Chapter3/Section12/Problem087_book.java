package DoItAlgorithmCodingTest.Chapter3.Section12;

/*
문제087 정수를 1로 만들기 / 백준 1463번 (실버 3)

N(구하고자 하는 수)
D[1] = 0 초기화                                              // 1일 때 연산 불필요
for (i -> 2 ~ N) {
    D[i] = D[i - 1] + 1                                    // -1 연산 표현
    if (2의 배수) D[i / 2] + 1이 D[i]보다 작으면 변경하기)        // 나누기 2연산
    ㅑㄹ (3의 배수) D[i / 3] + 1이 D[i]보다 작으면 변경하기        // 나누기 3 연산
}
D[N] 출력하기
*/

import java.util.Scanner;

public class Problem087_book {
    static int N;
    static int D[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = new int[N + 1];
        D[1] = 0;
        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + 1;
            if (i % 2 == 0) D[i] = Math.min(D[i], D[i / 2] + 1);
            if (i % 3 == 0) D[i] = Math.min(D[i], D[i / 3] + 1);
        }
        System.out.println(D[N]);
    }
}
