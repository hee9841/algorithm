package baekjoon.dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2468
 */
public class 안전지역_2468 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int N;
    private static final int[] diyY = new int[]{1, -1, 0, 0};
    private static final int[] diyX = new int[]{0, 0, 1, -1};

    private static int maxSafeZoneCnt = Integer.MIN_VALUE;

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int toX = x + diyX[i];
            int toY = y + diyY[i];
            if (toY >= 0 && toY < N && toX >= 0 && toX < N) {
                if (!visited[toY][toX]) {
                    dfs(toY, toX);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, height);
                map[i][j] = height;
            }
        }

        //높이에 따라 땅의 수계산
        for (int h = 0; h < maxHeight; h++) {
            visited = new boolean[N][N];
            //visited 채우기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= h) {
                        visited[i][j] = true;
                    }
                }
            }

            //dfs
            int safeZoneCnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        dfs(i,j);
                        safeZoneCnt++;
                    }
                }
            }
            maxSafeZoneCnt = Math.max(safeZoneCnt, maxSafeZoneCnt);
        }

        System.out.println(maxSafeZoneCnt);
    }

}
