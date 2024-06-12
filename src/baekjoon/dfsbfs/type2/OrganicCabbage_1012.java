package baekjoon.dfsbfs.type2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 유기농 배추
 * https://www.acmicpc.net/problem/1012
 * =====================================
 *
 */
public class OrganicCabbage_1012 {

    private static boolean[][] map;
    private static boolean[][] visited;
    //상하좌우
    private static int[] dirY = new int[]{-1, 1, 0, 0};
    private static int[] dirX = new int[]{0, 0, -1, 1};
    //M:가로, N:세로, T:testCase, K:심어진 배추 수
    private static int T, M, N;

    static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int toX = x + dirX[i];
            int toY = y + dirY[i];
            if (!visited[toY][toX] && map[toY][toX]) {
                dfs(toY, toX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new boolean[N + 2][M + 2];
            visited = new boolean[N + 2][M + 2];

            for (int i = 0; i <K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y + 1][x + 1] = true;
            }


            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (!visited[i][j] && map[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            bw.write(String.valueOf(cnt));
            bw.newLine();
        }

        bw.flush();

        bw.close();
        br.close();

    }

}
