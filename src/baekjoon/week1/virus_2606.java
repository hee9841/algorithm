package baekjoon.week1;

import java.util.Scanner;

/**
 * packageName    : baekjoon.week1
 * fileName       : virus_2606
 * author         : asdfz
 * date           : 2023-06-07
 * description    : 백준 2606번
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-07        asdfz       최초 생성
 */
public class virus_2606 {


    //간선 정보 입력 graph
    static boolean[][] graph;
    static boolean[] visited;

    static int N, M;    //N : 컴퓨터 수, M :간선수
    static int cnt; //바이러스 수

    public static void dfs(int idx) {
        //idx번째 노드를 방분한 것으로 answer하나 증가
        cnt++;
        //재방문을 방지하기 위해
        visited[idx] = true;

        //노드 방문
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[idx][i]) {
                //dfs 호출
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        //0. 입력 및 초기화
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        //1. 그래프 정보 입력
        for (int i = 0; i < M; i++) {
            int x =sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = true;
            graph[y][x] = true;
        }


        //2. dfs 및 결과 출력
        dfs(1);

        System.out.println(cnt - 1);
        sc.close();

    }
}
