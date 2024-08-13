package baekjoon.dfsbfs.type1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 트리의 부모 찾기
 * https://www.acmicpc.net/problem/11725
 * ======================================
 */
public class find_parent_tree_11725 {

    private static ArrayList<ArrayList<Integer>> trees;
    private static boolean[] visited;
    private static int[] parent;
    private static int N;

    static void dfs(int idx) {
        ArrayList<Integer> tree = trees.get(idx);
        for (Integer node : tree) {
            if (!visited[node]) {
                visited[node] = true;
                parent[node] = idx;
                dfs(node);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        parent = new int[N+1];
        trees = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            trees.add(i, new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            trees.get(x).add(y);
            trees.get(y).add(x);
        }

        dfs(1);

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }

    }

}
