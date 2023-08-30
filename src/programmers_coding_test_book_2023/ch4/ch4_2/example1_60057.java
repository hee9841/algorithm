package programmers_coding_test_book_2023.ch4.ch4_2;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : programmers_coding_test_book_2023.ch4.ch4_2
 * fileName       : example1_60057
 * author         : asdfz
 * date           : 2023-08-29
 * description    : 문자열 압축
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-29        asdfz       최초 생성
 */
public class example1_60057 {

    public static void main(String[] args) {

    }


    public static int solution(String s) {
        //1. 1부터 입력 문자열 s의 길이만큼 자를 문자열의 길이를 설정하며 반복 
        int min =Integer.MAX_VALUE;
        for (int len = 1; len <= s.length()/2; len++) {
            //문자열 압축 후 가장 짧은 길이 선택

            int compressed = compress(s, len);
            if (compressed < min) {
                min = compressed;
            }
        }

        //3. 문자열을 비교하여 token의 배열을 하나의 문자열로 압축
        //4. 1~3과정으로 압축된 문자열중 가장 짧은 기이 반환

        return min;

    }

    //문자열 압축 후 문자열 길이 반환하는 메서드
    private static int compress(String source, int len) {
        StringBuilder builder = new StringBuilder();

        String last = "";
        int cnt = 0;

        for (String token : split(source, len)) {
            //압축 문자열 구성
            //3. 문자열을 비교하여 token의 배열을 하나의 문자열로 압축
            if (token.equals(last)) {
                cnt++;
            } else {
                //새로운 토큰 등장
                //직전까지의 문자열을 압축한걸 더해줌
                if (cnt > 1) {
                    builder.append(cnt);
                }
                builder.append(last);

                last = token;
                cnt = 1;
            }

        }
        //for무능ㄹ 나오면 마지막 토큰을 포함시킴
        if (cnt > 1) {
            builder.append(cnt);
        }
        builder.append(last);

        return builder.length();
        
    }

    //2. 설정된 길이만큼 문자열을 자라 낸 token 배열 생성
    private static List<String> split(String source, int len) {
        List<String> tokens = new ArrayList<>();
        
        //source를 len만큼씩 잘라 tokens 리스트에 추가
        for (int startIdx = 0; startIdx < source.length(); startIdx += len) {
            //문자열을 startIdx부터 잘라 token 리스트에 추가
            int endIdx = startIdx + len;
            if (endIdx > source.length()) {
                endIdx = source.length();
            }
            tokens.add(source.substring(startIdx, endIdx));
        }

        return tokens;
    }



}
