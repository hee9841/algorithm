package baekjoon.dfsbfs.type1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1260
 * <p>
 * input
 * ===================================
 * N M V (N:노드수, M:간선수, V: 시작 노드)
 * 이후 M번째 간선의 정보(노드번호, 노드번호)
 * ====================================
 * <p>
 * output
 * ===================================
 * dfs경로
 * bfs경로
 */
public class DFS_BFS_1260 {

    static boolean graph[][];
    static boolean visited[];
    static Queue<Integer> q;

    static int N,M,V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[N+1][N+1];
        visited = new boolean[N + 1];

        //input 체우기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(V);
        System.out.println();


        bfs();
        System.out.println();

    }

    static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i] && graph[start][i]) {
                dfs(i);
            }
        }
    }

    static void bfs() {
        visited = new boolean[N + 1];
        q = new LinkedList<Integer>();
        q.add(V);
        visited[V] = true;

        while (q.peek() != null) {
            Integer node = q.poll();
            System.out.print(node+" ");

            for (int i = 1; i < N + 1; i++) {
                if (!visited[i] && graph[node][i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
