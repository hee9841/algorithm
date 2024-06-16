package baekjoon.dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1987
 */
public class 알파벳_mySol_1987 {


    private static boolean[][] visited;
    private static char[][] map;

    private static final int[] diyY = new int[]{-1, 1, 0, 0};
    private static final int[] diyX = new int[]{0, 0, 1, -1};

    private static int count = 0;
    private static Stack<Character> stack;

    private static void dfs(int y, int x) {

        for (int i = 0; i < 4; i++) {
            int toY = y + diyY[i];
            int toX = x + diyX[i];

            if (map[toY][toX] != 0 && !visited[toY][toX] && !stack.contains(map[toY][toX])) {
                visited[toY][toX] = true;
                stack.add(map[toY][toX]);
                dfs(toY, toX);
                count = Math.max(count, stack.size());
                stack.pop();
                visited[toY][toX] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new char[R + 2][C + 2];
        visited = new boolean[R + 2][C + 2];

        for (int i = 1; i < R + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < C + 1; j++) {
                map[i][j] = str.charAt(j-1);
            }
        }

        stack = new Stack<>();
        visited[1][1] = true;
        stack.add(map[1][1]);
        count = 1;
        dfs(1,1);
        System.out.println(count);

    }


}
