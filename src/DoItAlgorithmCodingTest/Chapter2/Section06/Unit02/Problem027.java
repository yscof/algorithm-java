package DoItAlgorithmCodingTest.Chapter2.Section06.Unit02;
/*
N: 체스판의 크기 및 놓아야하는 퀸의 갯수
answer: 가능한 경우의 수
queen 배열: 퀸의 위치. 인덱스는 행, 값은 열

main {
    N 입력 받기
    queen 배열의 크기 = N
    backtrack 진행
    결과(answer) 출력
}

backtracking {
    if (퀸을 모두 배치한 경우) { answer++ }
    for (현재 행의 모든 열. 즉, N번) {
        열마다 퀸을 배치해보고 배치할 수 있으면 행+1 해서 계속 진행. 배치 가능한지는 check 메서드 사용
    }
}

check(row: 행) {
    일직선 확인. 있으면 false
    대각선 확인. 있으면 false
    둘 다 없으면 true
}

 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem027 {
    static int N;
    static int answer = 0;
    static int[] queen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        queen = new int[N];

        backtracking(0);
        System.out.println(answer);
    }

    private static void backtracking(int row) {
        if (row == N) {
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            queen[row] = i;
            if (check(row)) {
                backtracking(row + 1);
            }
        }
    }

    private static boolean check(int row) {
        for (int i  = 0; i < row; i++) {
            if (queen[i] == queen[row]) {
                return false;
            }
            if (Math.abs(i - row) == Math.abs(queen[i] - queen[row])) {
                return false;
            }
        }
        return true;
    }
}
