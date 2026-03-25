package DoItAlgorithmCodingTest.Chapter2.Section04.Unit04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

// 문제009 DNA 비밀번호
// 백준 12891번
public class Problem009 {
    static char[] A;
    static int[] acgtCount;
    static int[] acgtCheck;
    static int check;

    public static void main(String[] args) throws IOException {
        // N(DNA 문자열 길이), M(부분 문자열 길이) 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = st.nextToken().toCharArray();
        int answer = 0;
        acgtCheck = new int[4];
        acgtCount = new int[4];
        check = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            acgtCheck[i] = Integer.parseInt(st.nextToken());
            if (acgtCheck[i] == 0) {
                check++;
            }
        }

        for (int i = 0; i < M; i++) {
            Add(A[i]);
        }

        if (check == 4) {
            answer++;
        }

        for (int i = M; i < N; i++) {
            int j = i - M;
            Add(A[i]);
            Remove(A[j]);
            if (check == 4) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void Add(char c) {
        switch (c) {
            case 'A':
                acgtCount[0]++;
                if (acgtCount[0] == acgtCheck[0]) {
                    check++;
                }
                break;
            case 'C':
                acgtCount[1]++;
                if (acgtCount[1] == acgtCheck[1]) {
                    check++;
                }
                break;
            case 'G':
                acgtCount[2]++;
                if (acgtCount[2] == acgtCheck[2]) {
                    check++;
                }
                break;
            case 'T':
                acgtCount[3]++;
                if (acgtCount[3] == acgtCheck[3]) {
                    check++;
                }
                break;
        }
    }

    static void Remove(char c) {
        switch (c) {
            case 'A':
                if (acgtCount[0] == acgtCheck[0]) {
                    check--;
                }
                acgtCount[0]--;
                break;
            case 'C':
                if (acgtCount[1] == acgtCheck[1]) {
                    check--;
                }
                acgtCount[1]--;
                break;
            case 'G':
                if (acgtCount[2] == acgtCheck[2]) {
                    check--;
                }
                acgtCount[2]--;
                break;
            case 'T':
                if (acgtCount[3] == acgtCheck[3]) {
                    check--;
                }
                acgtCount[3]--;
                break;
        }
    }
}
