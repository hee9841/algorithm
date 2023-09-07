package programmers_coding_test_book_2023.ch5;

/**
 * packageName    : programmers_coding_test_book_2023.ch5
 * fileName       : example1_68936
 * author         : asdfz
 * date           : 2023-09-04
 * description    : 쿼드압축 후 개수 세기
 * https://school.programmers.co.kr/learn/courses/30/lessons/68936
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-04        asdfz       최초 생성
 */
public class example1_68936 {
    public int[] solution(int[][] arr) {
        //1. 상태
        // 정사각혀의 범위가 분할되어야 해서 정사각혀의 범위를 상태로 나타냄
        // 정사각형의 범위는 정사각형이 시작되는 좌표와 한변의 크기 => (offsetX, offsetY, size)
        //-> 해당 상태가 나타내는 부분문제는 남아 있는 0과 1의 개수를 구하는 것
        
        //2. 종료 조건
        // 범위안의 원소들이 모두 0이나 1일때 종료

        //3. 점화식
        Count count = count(0, 0, arr.length, arr);
        return new int[]{count.zero, count.one};
    }

    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size/2;

        //종료
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    //원소가 섞여 있는 경우
                    return count(offsetX, offsetY, h, arr)
                        .add(count(offsetX +h, offsetY, h,arr))
                        .add(count(offsetX, offsetY + h, h,arr))
                        .add(count(offsetX + h, offsetY + h, h,arr));
                }
            }
        }
        //정사각형의 모든 원소가 같을 경우 종료
        if (arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }
        return new Count(1, 0);
    }

    private static class  Count{
        public final int zero;
        public final int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) {
            return new Count(zero + other.zero, one + other.one);
        }
    }

}

