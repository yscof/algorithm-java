package DoItAlgorithmCodingTest.Chapter2.Section04.Unit05;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem013_book {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {       // 카드를 큐에 저장하기
            myQueue.add(i);
        }
        while (myQueue.size() > 1) {        // 카드가 1장 남을 때까지
            myQueue.poll();                 // 맨 위의 카드를 버리기
            myQueue.add(myQueue.poll());    // 맨 위의 카드를 가장 아래 카드 밑으로 이동하기
        }
        System.out.println(myQueue.poll()); // 마지막으로 남은 카드 출력하기
    }
}

/*
문제 013 카드 게임 / 백준 2164번

N(카드의 개수) myQueue(카드 저장 자료구조)
for (카드의 개수만큼 반복) {
    큐에 카드 저장하기
}
while (카드가 1장 남을 때까지) {
    맨 위의 카드를 버림: poll()
    맨 위의 카드를 가장 아래의 카드 밑으로 이동: poll() -> add()
}
마지막으로 남은 카드 출력
*/