package programmers_coding_test_book_2023.ch3_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * packageName    : main.book.ch3
 * fileName       : example1
 * author         : asdfz
 * date           : 2023-08-04
 * description    : 별 만들기
 *                  https://school.programmers.co.kr/learn/courses/30/lessons/87377
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-04        asdfz       최초 생성
 */
public class example1_87377 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{
            {2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}
        })));

        System.out.println(Arrays.toString(solution(new int[][]{
            {0, 1, -1}, {1,0,-1}, {1,0,1}
        })));

        System.out.println(Arrays.toString(solution(new int[][]{
            {1, -1, 0}, {2, -1, 0}
        })));

        System.out.println(Arrays.toString(solution(new int[][]{
            {1, -1, 0}, {2, -1, 0}, {4, -1, 0}
        })));



    }

    /*
    *   * 참고 사항 *
    * Ax + By + E = 0
    * Cx + Dy + F = 0
    * 일때
    * x = BF - ED / AD - BC
    * y = EC - AF / AD - BC
    *  AC- BC 일경우 평행
    *
    * ==================================================
    *           * 문제 풀이 흐름 *
    * 1. 모든 직선 쌍에 대해 반복
    *   1-1. 교점 좌표 구하기
    *   1-2. 정수 좌표만 저장
    * 2. 저장된 정수들에 대해 x,y 좌표의 최대값, 최솟값 구하기
    * 3. 구한 최대값 최솟값을 이용하여 2차원 배열의 크기 결정
    * 4. 2차원 배열에 별 표시
    * 5. 문자열 배열로 변환 후 반환
    *
    * */

    private static class Point{

        /**
         * description
         * 0. 좌표를 표현하기 위한 클레스
         */

        // 좌표의 범위가 주어지지 않았고, 실제 자표값이 작다는 의미가 없기 때문에,
        // 오버플로우가 발생하지 않게 long 타입으로 선언
        // final : 데이터를 나타내는 클래스로 불변성을 가지게 함
        public final long x, y;


        //생성자로 초기화
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }



    /**
     *
     * @param line int[][]: 직선의 A,B,C의 정보가 담긴 배열, [[2,3,4], [4,2,8], ...]
     * @return  좌표에 별을 그린 문자열
     */
    public static String[] solution(int[][] line) {

        List<Point> points = new ArrayList<>();

        // 1. 모든 직선 쌍에 대해 반복
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                // 1-1. 교점 좌표 구하기

                Point intersection = intersection(line[i][0], line[i][1], line[i][2],
                    line[j][0], line[j][1], line[j][2]);

                // 1-2. 정수 좌표만 저장
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }



        // 2. 저장된 정수들에 대해 x,y 좌표의 최대값, 최솟값 구하기
        Point min = getMinimalPoint(points);
        Point max = getMaximumPoint(points);

        // 3. 구한 최대값 최솟값을 이용하여 2차원 배열의 크기 결정
        int width = (int) (max.x - min.x + 1);
        int height = (int) (max.y - min.y + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 4. 2차원 배열에 별 표시
        for (Point p : points) {
            int x = (int) (p.x - min.x);
            int y = (int) (max.y - p.y);
            arr[y][x] = '*';
        }
        // 5. 문자열 배열로 변환 후 반환
        String[] answer = new String[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);
        }

        return answer;
    }

    /**
     * 두 직선의 교점을 구하는 메소드
     */
    private static Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {

        // 1-1. 교점 좌표 구하기
        double x = (double) (b1 * c2 - b2*c1) / (a1*b2 - a2*b1);
        double y = (double) (a2*c1 - a1*c2) / (a1*b2 - a2*b1);

        /*
         *   * 자바에서 비교규칙
         * 1) 음의 무한대 < 음수 < 0 < 양수 < 양의 무한대
         * 2) 양의 무한대 비교는 모두 같음(true), 음의 무한대 비교는 모두 같음(true)
         * 3) NaN과의 비교는 무조건 거짓(false)
         *
         * */
        //정수 좌표만 저장하기 위해
        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) x, (long) y);
    }


    private static Point getMinimalPoint(List<Point> points) {
        //가장 작은 좌표 찾기
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if (p.x < x) {
                x = p.x;
            }
            if (p.y < y) {
                y = p.y;
            }
        }


        return new Point(x, y);
    }

    private static Point getMaximumPoint(List<Point> points) {
        //가장 큰은 좌표 찾기
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point p : points) {
            if (p.x > x) {
                x = p.x;
            }
            if (p.y > y) {
                y = p.y;
            }
        }


        return new Point(x, y);
    }


}





