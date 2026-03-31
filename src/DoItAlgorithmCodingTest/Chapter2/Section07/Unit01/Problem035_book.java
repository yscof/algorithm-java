package DoItAlgorithmCodingTest.Chapter2.Section07.Unit01;

/*
문제035 동전 개수의 최솟값 구하기 / 백준 11047번 (실버 3)

N(동전 개수) K(목표 금액)
A(동전 데이터 배열)
for (N만큼 반복하기) {
    A 배열 저장하기
}
// 가치가 큰 동전부터 선택해야 개수를 최소로 구성할 수 있음
for (N만큼 반복 -> N - 1 ~ 0 으로 역순으로 반복하기) {
    if (현재 K보다 동전 가치가 작으면) {
        동전 수 += 목표 금액 / 현재 동전 가치
        목표 금액 = 목표 금액 % 현재 동전 가치
    }
}
누적된 동전 수 출력하기
*/

import java.util.Scanner;

public class Problem035_book {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (A[i] <= K) {        // 현재 동전의 가치가 K보다 작거나 같으면 구성에 추가
                count += K / A[i];
                K = K % A[i];       // K를 현재 동전을 사용하고 남은 금액으로 갱신
            }
        }
        System.out.println(count);
    }
}
