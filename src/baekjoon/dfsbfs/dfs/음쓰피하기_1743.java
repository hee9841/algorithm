package baekjoon.dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1743
 */
public class 음쓰피하기_1743 {

    private static boolean[][] map;
    private static int maxTrashSize = 0;

    private static final int[] diyY = new int[]{1, -1, 0, 0};
    private static final int[] diyX = new int[]{0, 0, 1, -1};

    private static int N,M;

    static int dfs(int y, int x, int size) {
        map[y][x] = false;

        for (int i = 0; i < 4; i++) {
            int toY = y + diyY[i];
            int toX = x + diyX[i];
            if (toY > 0 && toY < N + 1 && toX > 0 && toX < M + 1) {
                if (map[toY][toX]) {
                    size = dfs(toY, toX, size+1);
                }
            }
        }

        return size;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[N + 2][M + 2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = true;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (map[i][j]) {
                    int size = dfs(i, j, 1);
                    maxTrashSize = Math.max(size, maxTrashSize);
                }
            }
        }

        System.out.println(maxTrashSize);

    }


}
