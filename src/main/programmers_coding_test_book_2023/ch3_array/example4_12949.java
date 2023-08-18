package main.programmers_coding_test_book_2023.ch3_array;

/**
 * packageName    : main.book.ch3_array
 * fileName       : example4
 * author         : asdfz
 * date           : 2023-08-07
 * description    : 행렬의 곱
 *                  https://school.programmers.co.kr/learn/courses/30/lessons/12949
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-07        asdfz       최초 생성
 */
public class example4_12949 {

    /**
     * 내가 푼 풀이
     * description :
     *  1. arr1[y][x], arr2[b][a]라고 하면 answer[y][a]를 리턴
     *  2. for y {
     *        for a {
     *
     *                 for x {
     *                   for b
     *                        {if x==b -> answer[y][a] +=  arr1[y][x] * arr2[b][a]}
     *                 }
     *        }
     *    }
     */
    public int[][] my_solution(int[][] arr1, int[][] arr2) {

        int[][] answer = new int[arr1.length][(arr2[0]).length];

        for(int y =0; y < arr1.length; y++) {
            for(int a = 0; a < arr2[0].length; a++) {
                for(int x = 0;  x <arr1[0].length; x++) {
                    for(int b = 0; b <arr2.length; b++) {
                        if (x == b) {
                            answer[y][a] += (arr1[y][x] * arr2[b][a]);
                        }
                    }
                }
            }
        }

        return answer;
    }


    /**
     * 교제 솔루션
     * description :
     *  왼쪽 행렬의 행과 오른쪽 열이 짝을 이루어서 수행
     *  a11 a12 a13     *     b11  b12          (a11* b11) + (a21 * b21) .....
     *  a21 a22 a23           b21  b22      =
     *                        b31  b23
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        //새 행렬
        int[][] answer = new int[arr1.length][(arr2[0]).length];

        for(int i =0; i < answer.length; i++) { // 새 행렬의 행 == arr1의 행
            for(int j = 0 ; j <answer[0].length; j++) { //새 행렬의 열 == arr2의 열
                answer[i][j] = 0;
                for(int k = 0; k <arr1[i].length; k++) {
                    //새 행렬의 (i, j) 성분은
                    //while k < arr의 열의 길이 arr1[i][k] arr[k][j]의 합임
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }

            }
        }


        return answer;
    }

}
