package baekjoon.dfsbfs.type2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

/**
 * 섬의 개수
 * https://www.acmicpc.net/problem/4963
 */
public class 섬의_개수_4963 {
    private static boolean[][] map;

    private static final int[] dirY = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};
    private static final int[] dirX = new int[]{0, 0, -1, 1, -1, 1, -1, 1};

    static void dfs(int y, int x) {
        map[y][x] = false;

        for (int i = 0; i < 8; i++) {
            int toX = x + dirX[i];
            int toY = y + dirY[i];

            if (map[toY][toX]) {
                dfs(toY, toX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new boolean[h + 2][w + 2];

            for (int i = 1; i < h+1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < w + 1; j++) {
                    map[i][j] = (Integer.parseInt(st.nextToken()) == 1);
                }
            }

            int answer = 0;
            for (int i = 1; i < h+1; i++) {
                for (int j = 1; j < w + 1; j++) {
                    if (map[i][j]) {
                        dfs(i,j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
