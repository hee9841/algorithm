package programmers_coding_test_book_2023.ch4.ch4_2;

/**
 * packageName    : programmers_coding_test_book_2023.ch4.ch4_2
 * fileName       : example_2
 * author         : asdfz
 * date           : 2023-08-29
 * description    : 3진법 뒤집기
 * https://school.programmers.co.kr/learn/courses/30/lessons/68935
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-29        asdfz       최초 생성
 */
public class example2_68935 {

    public int solution(int n) {
        //1. 정수를 3진법으로 변환
        String str = Integer.toString(n, 3);
        //2. 변환된 문자열 뒤집기
        String reversed = new StringBuilder(str).reverse().toString();
        //3.뒤집은 문자열를 정수로 변환 (10진법으로)
        return Integer.parseInt(reversed,3);
    }

}
