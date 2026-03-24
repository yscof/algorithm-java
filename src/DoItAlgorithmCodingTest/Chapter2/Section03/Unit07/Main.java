package DoItAlgorithmCodingTest.Chapter2.Section03.Unit07;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Edge> list[] = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            list[i] = new ArrayList<Edge>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e, v));
        }

        // 1번 노드에서 시작되는 엣지 데이터 가져오는 코드
        for (int i = 0; i < list[1].size(); i++) {
            Edge tmp = list[1].get(i);
            int next = tmp.endNode;
            int value = tmp.value;
        }
    }
}
