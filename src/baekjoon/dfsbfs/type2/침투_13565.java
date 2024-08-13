package baekjoon.dfsbfs.type2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 침투
 * https://www.acmicpc.net/problem/13565
 * ========================================
 */
public class 침투_13565 {

    private static boolean[][] map;
    private static boolean isPercolate;

    private static int M;

    private static final int[] dirY = new int[]{-1, 1, 0, 0};
    private static final int[] dirX = new int[]{0, 0, -1, 1};

    private static void dfs(int y, int x) {
        if (M == y) {
            isPercolate = true;
            return;
        }

        map[y][x] = false;

        for (int i = 0; i < 4; i++) {
            int toX = x + dirX[i];
            int toY = y + dirY[i];
            if (map[toY][toX]) {
                dfs(toY,toX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        map = new boolean[M + 2][N + 2];
        for (int i = 1; i < M+1; i++) {
            String str = br.readLine();
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = (str.charAt(j - 1) == '0');
            }
        }


        isPercolate = false;
        for (int j = 1; j < N + 1; j++) {
            dfs(1, j);
        }

        System.out.println(isPercolate ? "YES" : "NO");
        br.close();
    }
}
