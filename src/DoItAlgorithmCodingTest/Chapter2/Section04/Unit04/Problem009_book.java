package DoItAlgorithmCodingTest.Chapter2.Section04.Unit04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제009 DNA 비밀번호
// 백준 12891번

/*
        S(문자열 크기), P(부분 문자열의 크기)
        A(문자열 데이터)
        checkArr(비밀번호 체크 배열)
        myArr(현재 상태 배열)
        checkSecret(몇 개의 문자가 개수 조건을 충족했는지 나타내는 변수)
        P 범위(0 ~ P - 1)만큼 S 배열에 적용하고, 유효한 비밀번호인지 판단하기
        for (i를 P에서 S까지 반복)
        {
            j 선언(i - P)
            // 이 부분은 함수로 별도 구현하기
            한 칸씩 이동하면서 제거되는 문자열과 새로 들어오는 문자열을 처리하기
            유효한 비밀번호인지(checkSecret == 4) 판단해 결괏값에 업데이트하기
        }
        결괏값 출력하기

        별도 함수
        Add()
        {
            새로 들어온 문자를 myArr에 업데이트하고 checkSecret 값 변경하기
        }
        Remove(문자 빼기 함수)
        {
            제거되는 문자를 myArr에 업데이트하고 checkSecret 값 변경하기
        }
         */
public class Problem009_book {
    static int checkArr[];
    static int myArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result = 0;
        char A[] = new char[S];
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;
        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }
        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }
        if (checkSecret == 4) {
            Result++;
        }
        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) {
                Result++;
            }
        }
        System.out.println(Result);
        bf.close();
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
}
