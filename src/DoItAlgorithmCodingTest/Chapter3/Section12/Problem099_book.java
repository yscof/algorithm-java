package DoItAlgorithmCodingTest.Chapter3.Section12;

/*
문제099 가장 길게 증가하는 부분 수열 찾기 / 백준 14003번 (플래티넘)

N(수열 개수) maxLength(최대 길이 저장 변수), A[](수열 데이터 저장), ans[](정답 수열 저장)
D[](0 ~ i까지 i를 포함하는 최장 증가 수열의 길이 저장), B[](현재 가장 유리한 증가 수열 저장)
수열 데이터를 입력받아 A 배열에 값 저장하기
B[1] = A[1], D[1] = 1       // 초기화하기
for (i -> 2 ~ N) {
    if (가장 마지막 수열보다 현재 수열이 클 때) {
        B 배열의 끝에 A[i]값 추가하기
        maxLength = maxLength + 1로 변경하고, D 배열에 maxLength를 저장하기
    } else {
        이진 탐색을 이용해 현재 수열이 들어갈 index 찾기
        B[index] = 현재 수열의 값을 저장하고, D[i] = index
    }
}
가장 긴 증가하는 부분 수열 길이 출력하기(maxLength)
for (i -> N ~ 1) {      // D 배열의 뒤에서부터 탐색하기
    최초 maxLength와 같은 값을 지니고 있는 D 배열 index를 찾아 이 수열을 정답 배열에 저장하기
    maxLength값을 1 감소
}
저장된 정답 배열 출력하기

binarysearch(l, r, now) {       // 현재 수열이 들어갈 수 있는 위치를 빠르게 찾기 위한 함수
    while (l이 r보다 작을 때까지 반복하기) {
        중앙값 = l + r / 2
        B[중앙값]이 now보다 작으면 l값을 중앙값 + 1로 변경
        B[중앙값]이 now보다 크면 r값을 중앙값 - 1로 변경
    }
    l값을 반환하기
}
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem099_book {
    static int N, maxLength;
    static int B[] = new int[1000001];
    static int A[] = new int[1000001];
    static int D[] = new int[1000001];
    static int ans[] = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int index;
        B[++maxLength] = A[1];
        D[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (B[maxLength] < A[i]) {      // 가장 마지막 수열보다 현재 수열이 클 때
                B[++maxLength] = A[i];
                D[i] = maxLength;
            } else {
                // B 배열에서 A[i]보다 처음으로 크거나 같아지는 원소의 index 찾기
                index = binarysearch(1, maxLength, A[i]);
                B[index] = A[i];
                D[i] = index;
            }
        }
        System.out.println(maxLength);      // 가장 길고, 증가하는 부분의 수열 길이 출력하기
        index = maxLength;
        int x = B[maxLength] + 1;
        for (int i = N; i >= 1; i--) {      // 뒤에서부터 탐색하면서 정답 수열 저장하기
            if (D[i] == index && A[i] < x) {
                ans[index] = A[i];
                x = A[i];
                index--;
            }
        }
        for (int i = 1; i <= maxLength; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    // 현재 수열이 들어갈 수 있는 위치를 빠르게 찾기 위한 이진 탐색 구현하기
    static int binarysearch(int l, int r, int now) {
        int mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (B[mid] < now) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
