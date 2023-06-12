package programmers.week1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * packageName    : programmers.week1
 * fileName       : Electric_grid
 * author         : asdfz
 * date           : 2023-06-12
 * description    : 프로그래머스 전력망 둘로 나누기
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-12        asdfz       최초 생성
 */
public class Electric_grid {
    public static void main(String[] args) {

        Solution1 test1 = new Solution1();
        int solution1 = test1.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});

        System.out.println("solution1 = " + solution1);

        Solution1 test2 = new Solution1();
        int solution2 = test2.solution(4, new int[][]{{1,2}, {2, 3}, {3, 4}});

        System.out.println("solution2 = " + solution2);


        Solution1 test3 = new Solution1();
        int solution3 = test3.solution(7, new int[][]{{1,2}, {2,7},{3,7},{3,4},{4,5},{6,7}});

        System.out.println("solution3 = " + solution3);






    }


}

//1. 인접 행렬 또는 인접리스트를 이용해서 그래프를 표현해줍니다.
//
//2. for(반복문) : 선을 하나씩 끊어보며, 나눠진 두 전력망의 송전탑 개수의 차이를 구할 것입니다.
//
//2-1) 선 하나를 끊습니다.
//
//2-2) bfs 를 이용하여 끊어진 선의 두 노드 중 하나를 선택하여 연결된 송전탑의 개수를 구해줍니다.(=cnt)
//
//- 두 전력망은 각각 (cnt) 와 ( n-cnt )개의 송전탑을 가질 것입니다.
//
//- Math.abs(n-2*cnt) : 두 전력망이 가지고 있는 송전탑의 개수의 차
//
//- 최솟값을 answer에 갱신해줍니다.
//
//2-3) 선을 다시 복구시켜줍니다.
class Solution1 {

    //인접 행렬
    static int[][] arr;

    public int solution(int n, int[][] wires) {

        int answer = n;
        arr = new int[n + 1][n + 1];

        //1. 인접행렬에 intput
        //ex ) [[1,2],[2,3],[3,4]]이면 아래 형태로 인접행렬 생성
        //    | 1 | 2 | 3 | 4 |
        //  -------------------
        //  1 |   | 1 |   |   |
        //  2 | 1 |   | 1 |   |
        //  3 |   | 1 |   | 1 |
        //  4 |   |   | 1 |   |
        for (int[] wire : wires) {
            arr[wire[0]][wire[1]] = 1;
            arr[wire[1]][wire[0]] = 1;
        }

        //2. 선을 하나씩 끊어보면서 순회
        int a,b;
        for (int[] wire : wires) {
            a = wire[0];
            b = wire[1];

            //선을 끊고
            arr[a][b] = 0;
            arr[b][a] = 0;

            //bfs
            answer = Math.min(answer, bfs(n, a));

            //다시 연결
            arr[b][a] = 1;
            arr[a][b] = 1;
        }


        return answer;
    }

    public int bfs(int n, int start) {
        int[] visit = new int[n + 1];
        int cnt =1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int point = queue.poll();
            visit[point] = 1;

            //point와 연결된 애들 중에 방문한적 없는 노드 전부 큐에 넣기
            for (int i = 1; i <= n; i++) {
                if (visit[i] == 1) continue;
                if (arr[point][i] == 1) {
                    queue.offer(i);
                    cnt ++;
                }
            }

        }

        //두개의 차이는 n-2*cnt의 절대값이다.
        return Math.abs(n - 2 * cnt);// cnt - (n-cnt)
    }
}
