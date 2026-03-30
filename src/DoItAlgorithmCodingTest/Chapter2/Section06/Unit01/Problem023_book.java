package DoItAlgorithmCodingTest.Chapter2.Section06.Unit01;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem023_book {
    static ArrayList<Integer>[] A;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0 ; i < n + 1; i++) {      // 인접 리스트 초기화하기
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);        // 양방향 에지이므로 양쪽에 에지를 더하기
            A[e].add(s);
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (!visited[i]) {      // 방문하지 않은 노드가 없을 때까지 반복하기
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    static void DFS(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : A[v]) {        // 연결 노드 중 방문하지 않았던 노드만 탐색하기
            DFS(i);
        }
    }
}

/*
문제023 연결 요소의 개수 구하기 / 백준 11724번 (실버 5)

n(노드 개수) m(에지 개수)
A(그래프 데이터 저장 인접 리스트)
visited(방문 기록 저장 배열)
for (n의 개수만큼 반복하기) {
    A 인접 리스트의 각 ArrayList 초기화하기
}
for (m의 개수만큼 반복하기) {
    A 인접 리스트에 그래프 데이터 저장하기
}

for (n의 개수만큼 반복하기) {
    if (방문하지 않은 노드가 있다면) {
        연결 노드 개수++
        DFS 실행하기
    }
}
// DFS 구현하기
DFS {
    if (현재 노드 == 방문 노드) {
        visited 배열에 현재 노드 방문 기록하기
        현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행하기(재귀 함수 형태)
    }
}
*/
