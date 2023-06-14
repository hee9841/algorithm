package baekjoon.week2;

import java.util.Scanner;

/**
 * packageName    : baekjoon.week2
 * fileName       : TSP2_10971
 * author         : asdfz
 * date           : 2023-06-12
 * description    : 외판원 순회
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-12        asdfz       최초 생성
 */
public class TSP2_10971 {

    static int n;               //도시 수
    static int[][] W;           //비용 
    static boolean[] visited;   //방문 노드
    static int answer = Integer.MAX_VALUE;      //최소비용

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        W = new int[n][n];
        visited = new boolean[n];

        //비용 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j ++) {
                W[i][j] = sc.nextInt();
            }
        }

        //dfs
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);

        }

        System.out.println(answer);

        sc.close();

    }

    /**
     * dfs
     * @param start 시작 도시
     * @param now   현재 도시
     * @param sum   비용 합
     * @param cnt   이동 수
     */
    public static void dfs(int start, int now, int sum, int cnt) {
        // 탈출조건 : 모든 노드를 방문한 경우,
        if (cnt == n - 1) {
            //마지막 노드에서 맨처음 노드로 가는 비용 더하기
            if (W[now][start] != 0) {
                //마지막 노드에서 현재 노드로 갈 수 있다면
                sum += W[now][start];
                answer = Math.min(answer, sum);
            }
            
            return;
        }

        //수행 동작
        for (int i = 0; i < n; i++) {
            if (!visited[i] && W[now][i] != 0) {
                //현재 노드에서 갈 수 있는 노드 확인
                visited[i] = true;
                dfs(start, i, sum + W[now][i], cnt + 1);
                visited[i] = false;
            }
        }
    }

}
