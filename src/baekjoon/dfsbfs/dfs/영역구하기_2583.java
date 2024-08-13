package baekjoon.dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2583
 */
public class 영역구하기_2583 {

    private static boolean[][] map;
    private static final int[] diyY = new int[]{1, -1, 0, 0};
    private static final int[] diyX = new int[]{0, 0, 1, -1};

    private static ArrayList<Integer> answer;

    private static int dfs(int y, int x, int size) {
        map[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int toY = y + diyY[i];
            int toX = x + diyX[i];

            if (toY >= 0 && toY < map.length &&
                toX >= 0 && toX < map[0].length &&
                !map[toY][toX]) {
                size = dfs(toY, toX, size + 1);
            }
        }

        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        //입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[y][x] = true;
                }
            }
        }

        answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!map[i][j]) {
                    answer.add(dfs(i, j, 1));
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (Integer size : answer) {
            System.out.print(size + " ");
        }
    }
}
