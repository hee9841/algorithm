package programmers_coding_test_book_2023.ch4.ch4_2;

/**
 * packageName    : programmers_coding_test_book_2023.ch4.ch4_2
 * fileName       : example5_81301
 * author         : asdfz
 * date           : 2023-08-30
 * description    : 숫자 문자열과 영단어
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-30        asdfz       최초 생성
 */
public class example5_81301 {
    public int solution(String s) {

        for(int i =0; i < words.length; i++) {
            s = s.replace(words[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }

    private static final String[] words = {
        "zero", "one", "two", "three", "four", "five", "six",
        "seven", "eight", "nine"
    };
}
