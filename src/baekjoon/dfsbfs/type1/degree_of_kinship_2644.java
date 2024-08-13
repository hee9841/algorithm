package baekjoon.dfsbfs.type1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 촌수 계산
 * https://www.acmicpc.net/problem/2644
 * ========================================
 * input
 * 1 : 입력받는 사람수(n)
 * 2 : 촌수를 계산해야하는 서로다른 두사람
 * 3 : 부모 자식간의 관계의 수(m)
 * 그 이후의는 부모 자식(부모,자식) x,y
 */
public class degree_of_kinship_2644 {
    private static boolean[] visited;
    private static int N,M;
    private static boolean[][] graph;
    static int answer = -1;

    static void dfs(int idx, int end, int cnt) {
        visited[idx] = true;

        if(idx == end) {
            answer = cnt;
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            if(!visited[i] && graph[idx][i]){
                dfs(i, end, cnt+1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(start, end, 0);

        System.out.println(answer);

    }

}
