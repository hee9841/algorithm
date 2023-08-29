package programmers_coding_test_book_2023.ch4.ch4_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * packageName    : programmers_coding_test_book_2023.ch4.ch4_1
 * fileName       : example_12932
 * author         : asdfz
 * date           : 2023-08-29
 * description    : 자연수 뒤집어 배열 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12932?language=java
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-29        asdfz       최초 생성
 */
public class example_12932 {

    public static void main(String[] args) {
        System.out.println((Arrays.toString(my_solution(12345))));
    }

    public static int[] my_solution(long n) {

        List<Integer> arrList = new ArrayList<>();
        while (n > 0) {
            arrList.add((int) (n % 10));
            n = n/10;
        }
        return arrList.stream().mapToInt(i -> i).toArray();
    }

    public static int[] book_solution(long n) {

        /**
         * 배열로 구성한 후 배열을 뒤집는 문제이지만
         * 문자열을 이용하면 더 쉽게 간단하게 구현 가능
         * **/
        //1. 입력받은 숙자를 문자열로 변환
        String str = Long.toString(n);

        //2. 문자열을 뒤집음
        String reversed = new StringBuilder(str).reverse().toString();

        //3. 뒤집힌 문자열을 무자의 배열로 반환
        char[] arr = reversed.toCharArray();

        //4.배열의 각 문자를 정수로 변환
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i] - '0';
        }

        return result;
    }

}
