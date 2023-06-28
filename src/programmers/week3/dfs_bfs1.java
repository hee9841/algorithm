package programmers.week3;

import java.util.*;

/**
 * packageName    : programmers.week3
 * fileName       : dfs_bfs1
 * author         : asdfz
 * date           : 2023-06-20
 * description    : 여향 경로  https://school.programmers.co.kr/learn/courses/30/lessons/43164
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-20        asdfz       최초 생성
 */
public class dfs_bfs1 {

    public static void main(String[] args) {

        Solution testCase1 = new Solution();

        String[] solution1 = testCase1.solution(
            new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});

        System.out.println("solution1.toString() = " + Arrays.toString(solution1));

        Solution testCase2 = new Solution();

        String[] solution2 = testCase2.solution(
            new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},
                {"ATL", "SFO"}});

        System.out.println("Arrays.toString(solution2) = " + Arrays.toString(solution2));


    }



}


class Solution {

    boolean[] visited;

    ArrayList<String> answers;


    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answers = new ArrayList<>();


        //dfs
        dfs("ICN", "ICN", tickets, 0);

        
        //모든 경로 중 알파벳 순으로 배열 정렬
        Collections.sort(answers);

        //알파벳 순으로 가장 첫번째 경로 리턴
        return answers.get(0).split(",");
    }

    /**
     * dfs
     * @param present 현재 공항
     * @param route 경로
     * @param tickets 공항권 정보
     * @param cnt 방분 횟수
     */
    private void dfs(String present, String route, String[][] tickets, int cnt) {

        //탈출조건
        //전체 경로를 방문했을 경우
        if (cnt == tickets.length) {
            answers.add(route);
            return;
        }

        //동작
        for (int i = 0; i < tickets.length; i++) {
            //공항 방문 안했고, 시작 공항이 현재 공항이랑 같을 경우
            if (!visited[i] && tickets[i][0].equals(present)) {
                visited[i] = true;
                dfs(tickets[i][1], route + "," + tickets[i][1], tickets, cnt + 1);
                visited[i] = false;
            }
        }

    }
}
