package baekjoon.week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * packageName    : baekjoon.week1
 * fileName       : miro_2178
 * author         : asdfz
 * date           : 2023-06-08
 * description    :  https://www.acmicpc.net/problem/2178
 * bfs 방식으로
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-08        asdfz       최초 생성
 */
public class miro_2178 {

    static int[][] miro;
    static boolean[][] visited;
    static int N, M;
    //4방향(상하좌우)
    static int[] dx = {1, 0, -1, 0}; //x방향배열
    static int[] dy = {0, -1, 0, 1}; //y방향배열


    //현제 상테 클래스
    private static class State {
        public final int x;
        public final int y;
        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int a, int b) {

        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(a, b));        //시작 위치

        while (!queue.isEmpty()) {
            
            State now = queue.poll();

            visited[a][b] = true;
            
            //4방향 탐색
            for (int i = 0; i < 4; i++) {

                int nx = dx[i] +  now.x;
                int ny = dy[i] + now.y;

                //그래프 벗어났을 경우 continue
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                //방문을 했거나, (x,Y)가 0인 죄표일때  continue
                if (visited[nx][ny] || miro[nx][ny] == 0) {
                    continue;
                }

                //위의 조건이 모두 아니면
                visited[nx][ny] = true;     //방문 표시
                miro[nx][ny] = miro[now.x][now.y] +1; //뎁스를 넣어줌
                queue.offer(new State(nx, ny));     //큐에 추가

            }
        }
    }

    public static void main(String[] args) {
        //0. 입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        miro = new int[N][M];
        visited = new boolean[N][M];

        //미로 셋팅
        for (int y = 0; y < N; y++) {
            String line = sc.nextLine();
            for (int x = 0; x < M; x++) {
                miro[y][x] = line.charAt(x) - '0';
            }
        }

        bfs(0,0);
        System.out.println(miro[N - 1][M - 1]);

    }
}
