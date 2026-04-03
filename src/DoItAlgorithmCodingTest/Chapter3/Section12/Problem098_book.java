package DoItAlgorithmCodingTest.Chapter3.Section12;

/*
문제098 외판원의 순회 경로 짜기 / 백준 2098번 (골드 1)

N(도시 개수)
W[i][j](i 도시에서 j 도시로 가는 데 드는 비용을 저장하는 배열)
D[c][v]: 현재 도시가 c, 현재까지 방문한 모든 도시 리스트가 v일 때 앞으로 남은 모든 도시를 경유하는 데 필요한 최소 비용
for (i -> 0 ~ N) {
    for (j -> 0 ~ N) {
        W 배열에 값 저장하기
    }
}
for (i -> 0 ~ N) {
    for (j -> 0 ~ 1 << N) {
        D 배열을 충분히 큰 수로 저장하기
    }
}
tsp(0, 1)                   // 완전 탐색 함수 수행
정답 출력하기

tsp(c, v) {                 // 모든 경우의 수와 관련해 완전 탐색하고 재귀 구현하기
    if (모든 도시를 방문할 때) {
        시작 도시로 돌아갈 수 있을 때 -> return W[c][시작 도시]
        시작 도시로 돌아갈 수 없을 때 -> return 무한대          // 정답이 될 수 없음
    }
    if (이미 계산한 적이 있을 때) { return d[c][v] }          // 재계산할 필요 없음
    for (i -> 0 ~ N) {
        if (방문한 적이 없고, 갈 수 있는 도시일 때) {
            d[c][v] = Math.min(d[c][v], tsp(i, (v | (1 << i))) + W[c][i]);
        }
    }
    return d[c][v];
}
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem098_book {
    private static final int INF = 1000000 * 16 + 1;
    private static int N;
    private static int[][] W;
    private static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine().trim());
        W = new int[16][16];
        d = new int[16][1 << 16];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tsp(0, 1));
    }

    private static int tsp(int c, int v) {      // 모든 경우의 수와 관련해 완전 탐색과 재귀 구현하기
        if (v == (1 << N) - 1) {                // 모든 노드를 방문할 때
            return W[c][0] == 0 ? INF : W[c][0];
        }
        if (d[c][v] != 0) {                     // 이미 방문한 노드일 때 -> 바로 반환(메모이제이션)
            return d[c][v];
        }
        int min_val = INF;
        for (int i = 0; i < N; i++) {
            if ((v & (1 << i)) == 0 && W[c][i] != 0) {      // 방문한 적이 없고, 갈 수 있는 도시일 때
                min_val = Math.min(min_val, tsp(i, (v | (1 << i))) + W[c][i]);
            }
        }
        d[c][v] = min_val;
        return d[c][v];
    }
}
