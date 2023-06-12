package baekjoon.week1;

import java.util.Scanner;

/**
 * packageName    : baekjoon.week1
 * fileName       : startLink_14889
 * author         : asdfz
 * date           : 2023-06-09
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-09        asdfz       최초 생성
 */
public class startLink_14889 {

    //축구 하는 사람 N(N은 짝수)
    // N/2으로 나누어서 팀을 나눔
    //두 팀의 능력치 차이를 최소로

    static int N;               //입력
    static int[][] map;         //조합 점수 표
    static boolean[] visited;   //방문 여부

    static int Min = Integer.MAX_VALUE;     //팀사이 능력 차이


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        visited = new boolean[N];

        //S입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        sc.close();

        dfs(0, 0);
        System.out.println(Min);

    }

    /**
     * dfs 함수
     * @param idx 인덱스
     * @param count 조합 개수(=재귀 길이)
     */
    private static void dfs(int idx, int count) {
        //팀 조합이 완성될 경우
        if (count == N / 2) {
            //방문한 팀과 방문하지 않은 티믕ㄹ 가각 나누어서
            //각 팀의 점수를 구한 뒤 최솟값을 찾음
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            //방문 안했으면
            if ((!visited[i])) {
                visited[i] = true;  //방문으로 변환
                dfs(i + 1, count + 1);  //재귀 호출
                visited[i] = false;     //재귀가 완료 되면 비방문으로 변경
            }
        }

    }


    /**
     * 두 팀의 능력 차이를 계산하는 함수
     */
    private static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                //i번와 j번째 살마이 true면 start팀으로 점수 플러스
                if (visited[i] && visited[j]) {
                    team_start += map[i][j];
                    team_start += map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    //i번와 j번째 살마이 false면 link팀으로 점수 플러스
                    team_link += map[i][j];
                    team_link += map[j][i];
                }
            }
        }


        //두 팀의 점수 차이
        int val = Math.abs(team_start - team_link);

        //두 팀의 점수차이가 0이면 가장 낮은 최솟값으로
        //더이상 탐색 필요X
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        Min = Math.min(val, Min);
    }
}
