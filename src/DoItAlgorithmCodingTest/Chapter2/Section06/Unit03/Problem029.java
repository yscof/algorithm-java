package DoItAlgorithmCodingTest.Chapter2.Section06.Unit03;

/*
N(노드 갯수) M(엣지 갯수) S(시작점)
A(그래프 데이터 저장 인접 리스트) visited(방문 기록 저장 배열)
for (N의 개수만큼 반복하기) {
    A 인접 리스트의 각 ArrayList 초기화하기
}
for (M의 개수만큼 반복하기) {
    A 인접 리스트에 그래프 데이터 저장하기
}
for (N의 개수만큼 반복하기) {
    각 노드와 관련된 엣지들을 정렬하기
}
visited 배열 초기화하기
DFS(S) 실행하기
visited 배열 초기화하기
BFS(S) 실행하기

DFS {
    현재 노드 출력하기
    visited 배열에 현재 노드 방문 기록하기
    현재 노드의 연결 노드 중 방문하지 않는 노드로 DFS 실행하기(재귀 함수 형태)
}

BFS {
    큐 자료구조에 현재 노드 삽입하기(add 연산)
    visited 배열에 현재 노드 방문 기록하기
    while (큐가 비어 있을 때까지) {
        큐에서 노드 데이터를 가져오기(poll 연산)
        가져온 노드 출력하기
        현재 노드의 연결 노드 중 미방문 노드를 큐에 삽입(add 연산)하고 visited 배열에 방문 기록하기
    }
}
 */

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class Problem029 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[N + 1];
        DFS(S);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(S);
    }

    public static void DFS(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int i : A[node]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            visited[now] = true;
            for (int i : A[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}