package baekjoon.dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10026
 */
public class 적록색약_10026 {

    private static char[][] normal;
    private static char[][] redGreen;

    private static final int[] diyY = new int[]{1, -1, 0, 0};
    private static final int[] diyX = new int[]{0, 0, 1, -1};


    private static void dfs(char[][] map, int y, int x) {
        char c = map[y][x];
        map[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int toy = diyY[i] + y;
            int tox = diyX[i] + x;

            char nextColor = map[toy][tox];
            if (nextColor != 0 && nextColor == c) {
                dfs(map, toy, tox);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        normal = new char[N + 2][N + 2];
        redGreen = new char[N + 2][N + 2];

        for (int i = 1; i < N + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < N + 1; j++) {
                char c = str.charAt(j - 1);
                normal[i][j] = c;
                if (c == 'G') {
                    c = 'R';
                }
                redGreen[i][j] = c;
            }
        }

        int normalCnt = 0;
        int redGreenCnt = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                //normal
                if (normal[i][j] != 0) {
                    dfs(normal, i, j);
                    normalCnt++;
                }

                if (redGreen[i][j] != 0) {
                    dfs(redGreen, i, j);
                    redGreenCnt++;
                }


            }
        }

        System.out.printf("%d %d", normalCnt, redGreenCnt);
    }


}
