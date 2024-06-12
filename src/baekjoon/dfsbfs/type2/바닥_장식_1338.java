package baekjoon.dfsbfs.type2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 바닥 장식
 * https://www.acmicpc.net/problem/1388
 * ======================================
 *
 */
public class 바닥_장식_1338 {

    private static char[][] map;
//    private static boolean[][] visited;

    public static void dfs(int y, int x) {
//        visited[y][x] = true;
        char cur = map[y][x];
        map[y][x] = 0;

        if (cur == '-' && map[y][x+1] == '-') dfs(y, x+1);
        if (cur == '|' && map[y+1][x] == '|') dfs(y+1, x);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N + 2][M + 2];
//        visited = new boolean[N + 2][M + 2];

        for (int i = 1; i < N + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = str.charAt(j-1);
            }
        }

        int tileCount = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
//                if (!visited[i][j]) {
                if (map[i][j] != 0) {
                    dfs(i,j);
                    tileCount++;
                }
            }
        }

        System.out.println(tileCount);


        br.close();

    }
}
