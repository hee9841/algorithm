package baekjoon.dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2667
 */
public class 단지번호붙이기_2667 {
    private static boolean[][] map;
    private static ArrayList<Integer> complexes;

    private static final int[] diyY = new int[]{1, -1, 0, 0};
    private static final int[] diyX = new int[]{0, 0, 1, -1};

    static int dfs(int y, int x, int cnt) {
        map[y][x] = false;

        for (int i = 0; i < 4; i++) {
            int toY = y + diyY[i];
            int toX = x + diyX[i];

            if (map[toY][toX]) {
                cnt = dfs(toY, toX, cnt + 1);
            }
        }


        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new boolean[N + 2][N + 2];
        for (int i = 1; i < N + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = str.charAt(j - 1) == '1';
            }
        }

        //dfs
        complexes = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (map[i][j]) {
                    int size = dfs(i, j, 1);
                    if (size != 0) {
                        complexes.add(size);
                    }
                }

            }
        }

        System.out.println(complexes.size());

        Collections.sort(complexes);
        for (Integer complex : complexes) {
            System.out.println(complex);
        }
    }
}
