package DoItAlgorithmCodingTest.Chapter2.Section04.Unit04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

// 문제010 최솟값 찾기
// 백준 11003번
public class Problem010 {

    public static void main(String[] args) throws IOException {
        /*
        N(데이터 갯수), M(최솟값을 구하는 범위) 입력 받기
        Deque<Node> mydeque(데이터를 담을 덱 자료구조)

        for (N만큼 반복) {
            덱의 마지막 위치에서부터 now 값보다 큰 값은 제거
            덱의 마지막 위치에 now 값 저장
            덱의 첫번째 위치에서부터 now - M 보다 작거나 같은 위치에 있는 값 제거
            덱의 첫번째 값 출력
        }
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> mydeque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!mydeque.isEmpty() && now < mydeque.getLast().value) {
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(i, now));
            if (mydeque.getFirst().index <= i - M) {
                mydeque.removeFirst();
            }
            bw.write(String.valueOf(mydeque.getFirst().value) + " ");
        }

        bw.flush();
        br.close();
    }

    // 노드 클래스 정의
    static class Node {
        int index;
        int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
