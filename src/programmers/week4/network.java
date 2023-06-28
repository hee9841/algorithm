package programmers.week4;

/**
 * packageName    : programmers.week4
 * fileName       : network
 * author         : asdfz
 * date           : 2023-06-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-26        asdfz       최초 생성
 */
public class network {

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(computers, visit, i);
                answer++;
            }
        }

        return answer;


    }

    /**
     * dfs
     * @param computers 연결정보
     * @param visit 방문여부
     * @param start 시작노드
     */
    void dfs(int[][] computers, boolean[] visit, int start) {
        visit[start] = true;

        for (int i = 0; i < computers.length; i++) {
            if (start != i && computers[start][i] == 1 && !visit[i]) {
                dfs(computers, visit, i);
            }
        }
    }



}
