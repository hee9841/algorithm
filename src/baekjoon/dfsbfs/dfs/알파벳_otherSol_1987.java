package baekjoon.dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1987
 */
public class 알파벳_otherSol_1987 {


    private static boolean[] alpha;
    private static int[][] map;

    private static final int[] diyY = new int[]{-1, 1, 0, 0};
    private static final int[] diyX = new int[]{0, 0, 1, -1};

    private static int count = 0;

    private static void dfs(int y, int x, int len) {
        alpha[map[y][x]] = true;
        count = Math.max(len, count);

        for (int i = 0; i < 4; i++) {
            int toY = y + diyY[i];
            int toX = x + diyX[i];

            if (toY >= 0 && toX >= 0 && toY < map.length && toX < map[0].length) {
                if (!alpha[map[toY][toX]]) {
                    dfs(toY, toX, len + 1);
                    alpha[map[toY][toX]] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        alpha = new boolean[26];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }
        dfs(1, 1, 1);
        System.out.println(count);
    }
}
