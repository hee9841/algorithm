package baekjoon.dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9466
 */
public class 팀프로젝트_9466 {
    private static int[] map;
    private static boolean[] visited;
    private static boolean[] done;

    private static int sum;

    private static void dfs(int start) {
        if (done[start]) return;
        if (visited[start]) {
            //이미 방문한 애들이면 싸이클에 들어간거니까
            done[start] = true;
            sum++;
        }
        visited[start] = true;
        dfs(map[start]);
        done[start] = true; //싸이클에 들어가지 않은 애들도 검사완료했으니까
        visited[start] = false; //방문체크 한거 초기화

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(br.readLine());
            map = new int[N+1];
            visited = new boolean[N+1];
            done = new boolean[N + 1];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) {
                int s = Integer.parseInt(st.nextToken());
                map[i] = s;
            }

            sum = 0;
            for (int i = 1; i < N + 1; i++) {
                if (done[i]) continue;
                dfs(i);
            }

            System.out.println(N - sum);
        }
    }
}
