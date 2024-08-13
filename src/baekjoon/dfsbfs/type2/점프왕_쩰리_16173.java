package baekjoon.dfsbfs.type2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16173
 */
public class 점프왕_쩰리_16173 {

    private static int[][] map;
    private static int N;
    private static final int[] dirY = new int[]{1, 0};
    private static final int[] dirX = new int[]{0, 1};

    private static void dfs(int y, int x) {
        int moveCount = map[y][x];
        map[y][x] = 0;

        if (y == N-1 && x == N-1) {
            return;
        }

        //좌우
        for (int i = 0; i < 2; i++) {
            int toY = y + dirY[i] * moveCount;
            int toX = x +  dirX[i] * moveCount;
            if (toX < N && toY < N && map[toY][toX] != 0) {
                dfs(toY, toX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(map[N - 1][N - 1] == 0 ? "HaruHaru" : "Hing");

        br.close();

    }
}
