package baekjoon.dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 플로이드 -워셜 알고리즘
 * - 음수 사이클이 없는 그래프 내의 각 모든 정점에서 각 모든 정저멩까지의 최단 거리 계산
 * - 다익스트라 알고리즘과 다르게 그래프에 음수 사이클만 존재하지 않으며, 음의 가중치를 갖느 간선이 존재해도 상관 없다는 것
 * - 음수 사이클: 사이클의 모든경로를 지나 원래 지점으로 돌아올 때 최종 비용이 음수가 되는 경우
 * =========================================================================
 * sample input(첫 번째 숫자는 노드의 개수, 두 번째 숫자는 간선의 개수 이다).
 * 5
 * 8
 * 0 1 5
 * 0 4 1
 * 0 2 7
 * 0 3 2
 * 1 2 3
 * 1 3 6
 * 2 3 10
 * =========================
 * 시간 복잡도
 * 모든 노드(V)에 대해 V x V 행렬 갱신해주는 연산을 진행해
 * O(V^3)의 시간 복잡도 됨
 * --> 입력 크기가 100정도만 되어도 백만번의 연산이 수행됨
 * --> 플로이드 알고리즘 사용시 입력 크기 주의깁ㅍ게 살펴보기
 */
public class FloydWarshall {

    static int N, M;
    static int[][] dist;
    static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        //프롤이드 조기 거리 테이블 초기화
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //자기 자신으로 가는 길의 최소 비용은 0
                if (i == j) {
                    dist[i][j] = 0;
                    continue;
                }
                //자기 자신으로 가는 경우를 제외하고 매우 큰값을
                dist[i][j] = INF;
            }
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            //가는 경로가 하나가 아닐 수 있음 그에 따라서 그중 최소 비용을 저장해 두기
            dist[a][b] = Math.min(dist[a][b], cost);
            dist[b][a] = Math.min(dist[b][a], cost);
        }

        //플로이드 워셜 알고리즘
        //노드를 1개부터 N까지 거쳐가는 경우를 모두 고려
        for (int k = 0; k < N; k++) {
            //노드 i에서 j로 가는 경우
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    //k번째 노드를 거쳐가는 비용이 기존비용보다 더 작은 경우 갱신
                    //또는 연결이 안되어 있었던 경우(INF) 연경비용 갱신
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        //출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //연결 안되어 있는 경우
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}
