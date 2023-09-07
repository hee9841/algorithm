package programmers_coding_test_book_2023.ch5;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : programmers_coding_test_book_2023.ch5
 * fileName       : example3_84512
 * author         : asdfz
 * date           : 2023-09-07
 * description    : 모음사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-07        asdfz       최초 생성
 */
public class example3_84512 {

    //1. 상태 : (word)
    //2. 종료조건 : 길이가 5인 word
    //3. 점화식 (word) =  [word] + (word+'A') + (word+'E') + (word+'I') + (word+'O') + (word+'U')

    private static final char[] CHARS = "AEIOU".toCharArray();

    public int pre_solution(String word) {
        return pre_generate("").indexOf(word);
    }

    private List<String> pre_generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        if (word.length() == 5) {
            return words;
        }

        for (char c : CHARS) {
            words.addAll(pre_generate(word + c));
        }

        return words;
    }


    //************* 최적화 **************
    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }

    private void generate(String word, List<String> words) {
        words.add(word);

        if (word.length() == 5) return;

        for (char c : CHARS) {
            generate(word + c, words);
        }

    }


}
