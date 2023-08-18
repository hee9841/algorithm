package main.programmers_coding_test_book_2023.ch3_array;

/**
 * packageName    : main.book.ch3_array
 * fileName       : example2
 * author         : asdfz
 * date           : 2023-08-07
 * description    : 삼각 달팽이
 *                  https://school.programmers.co.kr/learn/courses/30/lessons/68645
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-07        asdfz       최초 생성
 */

public class example2_68645 {

    //아래, 오른쪽, 왼쪽위로 이동하는 변화량
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public static int[] solution(int n) {

        //1. nxn 차원 배열 선언
        int[][] arr = new int[n][n];

        int v = 1;  // arr에 채워 넣을 숫자 arr에 기록할때마다 1씩 증가
        int x=0, y = 0;
        int d = 0;

        //2. [0][0]부터 [1][0],...[n-1][0]까지 채운 다음
        //      [n-1][n-1]까지 채우고, -> ....
        //      2-1. 아래로 내러가면서 채우기
        //      2-2. 오른쪽으 가면서 채우기
        //      2-3. 왼쪽 위로 가면서 채우기 (-1 ,+1)
        while (true) {
            arr[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0) {
                d = (d+1) %3;
                nx = x + dx[d];
                ny = y + dy[d];
                if(nx ==n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0) break;

            }
            x = nx;
            y = ny;

        }

        int[] answer = new int[v - 1];
        int idx = 0;
//        for (int[] a : arr) {
//            for (int i : a) {
//                if (i != 0) {
//                    answer[idx++] = i;
//                }
//            }
//        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }


}