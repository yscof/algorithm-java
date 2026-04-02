package DoItAlgorithmCodingTest.Chapter3.Section09.Unit02;

/*
문제053 집합 표현하기 / 백준 1717번 (골드 4)

N(원소 갯수),  M(연산 갯수) 입력받기
A(리스트 생성. 크기: N + 1)
for (M번 반복) {
    if (0) {
        a가 포함되어 있는 집합과 b가 포함돼 있는 집합을 합침
    } else (1) {
        if (a, b가 같은 집합) {
            YES 출력
        } else {
            NO 출력
        }
    }
}

// union 연산
union(a, b) {
    find(a) == find(b)
}

// find 연산
find(a) {
    if (parent[a] = a) {
        return a;
    } else {
        find(parent[a]
    }
}

// check 메서드
check(a, b) {
    if (find(a) == find(b) {
        true;
    } else {
        false;
    }
}
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem053 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // N: 원소 갯수
        int M = Integer.parseInt(st.nextToken());       // M: 질의 갯수
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {                  // 대표 노드를 자기 자신으로 초기화하기
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (question == 0) {            // 집합 합치기
                union(a, b);
            } else {                        // 같은 집합의 원소인지 확인하기
                if (checkSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    static void union(int a, int b) {       // union 연산: 대표 노드끼리 연결하기
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {                // find 연산
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static boolean checkSame(int a, int b) {        // 두 원소가 같은 집합인지 확인하기
        a = find(a);
        b = find(b);
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
}
