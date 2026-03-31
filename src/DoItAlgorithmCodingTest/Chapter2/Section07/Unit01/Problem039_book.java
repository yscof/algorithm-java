package DoItAlgorithmCodingTest.Chapter2.Section07.Unit01;

/*
문제039 최솟값을 만드는 괄호 배치 찾기 / 백준 1541번 (실버 2)

answer(정답 변수)
들어온 데이터를 "-" 기호를 기준으로 split() 수행하기
for (나눠진 데이터 개수만큼 반복하기) {
    결괏값 = mySum() 함수 수행하기
    if (가장 앞 데이터일 때) {
        answer에 결괏값 더하기
    } else {
        answer에 결괏값 빼기
    }
}
answer 출력하기
mySum() 함수 구현하기 {       // 현재 String에 있는 수를 모두 더하는 함수
    현재 들어온 String값을 "+"기호 수준으로 split() 수행하기
    for (나눠진 데이터 개수만큼 반복하기) {
        String 값을 Integer형으로 변환해 반환값에 더하기
    }
    전체 합 반환하기
}
*/

import java.util.Scanner;

public class Problem039_book {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String[] str = example.split("-");
        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);
            if (i == 0) {
                answer = answer + temp;     // 가장 앞에 있는 값만 더함
            } else {
                answer = answer - temp;     // 뒷부분은 더한 값들을 뺌
            }
        }
        System.out.println(answer);
    }

    static int mySum(String a) {        // 나뉜 그룹의 더하기 연산 수행 함수
        int sum = 0;
        String temp[] = a.split("[+]");
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
