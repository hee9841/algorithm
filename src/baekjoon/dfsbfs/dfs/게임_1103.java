package baekjoon.dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1103
 * ========================================
 * 싸이클 들어가면 -> 무한으로 리턴
 */
public class 게임_1103 {
    private static int[][] map;
    private static boolean[][] visited;
    private static boolean[][] done;
    private static int N,M;

    private static final int[] diyY = {1, -1, 0, 0};
    private static final int[] diyX = {0, 0, 1, -1};

    private static int max = -1;
    private static final int INF = Integer.MAX_VALUE;

    private static void dfs(int y, int x, int cnt) {
        if (done[y][x]) {
            max = INF;
            return;
        }
        if (visited[y][x]) {
            done[y][x] = true;
        }

        if (map[y][x] == -1) {
            max = Math.max(cnt, max);
            return;
        }
        int dis = map[y][x];
        for (int i = 0; i < 4; i++) {
            int ny = y + diyY[i] * dis;
            int nx = x + diyX[i] * dis;

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                max = Math.max(cnt + 1, max);
            } else {
                visited[y][x] = true;
                dfs(ny, nx, cnt+1);
                visited[y][x] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        done = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                map[i][j] = (c == 'H') ? -1 : Integer.parseInt(String.valueOf(c));
            }
        }

        dfs(0, 0, 0);
        System.out.println(max == INF ? -1 : max);

        br.close();
    }
}
