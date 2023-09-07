package programmers_coding_test_book_2023.ch5;

import java.util.ArrayList;
import java.util.List;
import main.programmers.week4.process;

/**
 * packageName    : programmers_coding_test_book_2023.ch5
 * fileName       : example2_12946
 * author         : asdfz
 * date           : 2023-09-07
 * description    : 하노이의 탑
 * https://school.programmers.co.kr/learn/courses/30/lessons/12946
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-07        asdfz       최초 생성
 */
public class example2_12946 {
    public int[][] solution(int n) {
        //1.상태
        // 제시된 문제는 원판 n개를 기둥 1에서 3으로 옮기는 과정
        //  -> 정의하는 변수는 3개임 : 옮기려는 원판 갯수 n, 원판이 현재 위치한 기둥 from, 원판이 이동해야하는 기중 to
        //  -> (n, from, to)

        // 2. 종료 조건
        //  가장 작은 부분 문제 : 원판을 1개만 옮길 때 -> (1, from, to) 일경우 -> [[from, to]]
        // 즉 원판이 1일경우가 종료 조건

        //3. 점화식
        // 가장 작은 상태가 n이 1일경우 이미로 상태변수 n이 n-1이 되어야함
        // 즉 n개를 이동시키는 부분문제는 n-1개를 이동시키는 부분문제로 해결할 수 있음
        // (n, from, to) = (n-1, from, empty) + (1, from ,to) + (n-1, empty, to)

        //비효율적
//        return hanoi_1(n, 1, 3).toArray(new int[0][]);
        List<int[]> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        return process.toArray (new int[0][]);
    }

    private List<int[]> hanoi_1(int n, int from, int to) {
        if (n == 1) {
            return List.of(new int[]{from, to});
        }
        int empty = 6 - from - to;

        List<int[]> result = new ArrayList<>();
        result.addAll(hanoi_1(n - 1, from, empty));
        result.addAll(hanoi_1(1, from, to));
        result.addAll(hanoi_1(n - 1, empty, to));
        return  result;
    }

    private void hanoi(int n, int from, int to, List<int[]> process) {
        if (n == 1) {
            process.add(new int[]{from, to});
            return;
        }
        int empty = 6 - from - to;

        hanoi(n - 1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n - 1, empty, to, process);
    }

}
