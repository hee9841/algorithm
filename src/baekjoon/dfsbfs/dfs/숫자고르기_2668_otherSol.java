package baekjoon.dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.acmicpc.net/problem/2668
 */
public class 숫자고르기_2668_otherSol {

    private static boolean[] visited;
    private static boolean[] done;
    private static int[] map;

    private static ArrayList<Integer> list;

    public static void dfs(int start) {
        if(done[start]) return;
        if (visited[start]) {
            done[start] = true;
            list.add(map[start]);
        }
        visited[start] = true;
        dfs(map[start]);
        done[start] = true;
        visited[start] = false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N + 2];
        visited = new boolean[N + 2];
        done = new boolean[N + 2];

        for (int i = 1; i < N + 1; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            if (done[i]) continue;
            dfs(i);
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (Integer i : list) {
            System.out.println(i);
        }
    }

}
