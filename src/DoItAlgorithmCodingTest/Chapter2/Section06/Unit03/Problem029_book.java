package DoItAlgorithmCodingTest.Chapter2.Section06.Unit03;


/*
N(노드 개수) M(에지 개수) Start(시작점)
A(그래프 데이터 저장 인접 리스트) visited(방문 기록 저장 배열)
for(N의 개수만큼 반복하기) {
    A 인접 리스트의 각 ArrayList 초기화하기
}
for (M의 개수만큼 반복하기) {
    A 인접 리스트에 그래프 데이터 저장하기
}
// 방문할 수 있는 노드가 여러 개일 경우에는 번호가 작은 것부터 먼저 방문하기 위해 정렬하기
for (N의 개수만큼 반복하기) {
    각 노드와 관련된 에지를 정렬하기
}
visited 배열 초기화하기
DFS(start) 실행하기
visited 배열 초기화하기
BFS(start) 실행하기

DFS {   // DFS 구현하기
    현재 노드 출력하기
    visited 배열에 현재 노드 방문 기록하기
    현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행하기(재귀 함수 형태)
}
BFS {   // BFS 구현하기
    큐 자료구조에 시작 노드 삽입하기(add 연산)
    visited 배열에 현재 노드 방문 기록하기
    while(큐가 비어 있을 때까지) {
        큐에서 노드 데이터를 가져오기(poll 연산)
        가져온 노드 출력하기
        현재 노드의 연결 노드 중 미방문 노드를 큐에 삽입(add 연산)하고 방문 배열에 기록하기
    }
}
 */

// 문제029 DFS와 BFS 프로그램 / 백준 1260번 (빈출)
public class Problem029_book {
}
