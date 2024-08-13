package baekjoon.dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.acmicpc.net/problem/2668
 */
public class 숫자고르기_2668 {

    private static boolean[] visited;
    private static int[] map;

    private static ArrayList<Integer> firstLine;
    private static ArrayList<Integer> secondLine;
    private static int idx = -1;

    public static boolean dfs(int first) {
        visited[first] = true;

        boolean isAddValue = false;
        if (first == map[first]) {
            return true;
        }
        if (secondLine.contains(first)) {
            return true;
        }
        for (int i = 1; i < map.length; i++) {
            if (!visited[i] && map[i] == first) {
                boolean addCurValue = dfs(i);
                if (addCurValue) {
                    isAddValue = true;
                    idx++;
                    firstLine.add(idx, i);
                    secondLine.add(idx, map[i]);
                }
            }
        }

        return isAddValue;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N + 2];
        visited = new boolean[N + 2];

        for (int i = 1; i < N + 1; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        firstLine = new ArrayList<>();
        secondLine = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                idx++;
                firstLine.add(idx, i);
                secondLine.add(idx, map[i]);
                boolean dfs = dfs(i);
                if (!dfs) {
                    firstLine.remove(idx);
                    secondLine.remove(idx);
                    idx--;
                }
            }
        }

        Collections.sort(firstLine);

        System.out.println(firstLine.size());
        for (Integer a : firstLine) {
            System.out.println(a);
        }
    }

}
