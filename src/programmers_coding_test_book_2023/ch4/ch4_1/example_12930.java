package programmers_coding_test_book_2023.ch4.ch4_1;

/**
 * packageName    : programmers_coding_test_book_2023.ch4.ch4_1
 * fileName       : example_12930
 * author         : asdfz
 * date           : 2023-08-29
 * description    : 이상한 문자 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12930
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-29        asdfz       최초 생성
 */
public class example_12930 {
    
    
    public String solution(String s) {
        //1. 문자열의 모든 문자에 대해 반복
            // 1-1. 문자가 공백ㅇ 문자일 경우
                //1-1-1. 그대로 이어 붙이기
                //1-1-2. 다음 등장하는 알파벳은 대문자
            //1-2. 공백 문자가 아닌 경우
                //1-2-1. 대소문자 변환하며 이어붙이기
                //다음 등장하는 알파벳의 대소문자는 현재 변환하는 문자와 반ㄷ애
        //2. 구성한 문자열 반환

        //1. 문자열의 모든 문자에 대해 반복
        StringBuilder builder = new StringBuilder();
        boolean toUppere = true;
        for (char c : s.toCharArray()) {
            //c를 변환하여 builder에 추가
            //1-1. 문자가 공백 문자일 경우
            if (!Character.isAlphabetic(c)) {
                //공백 처리
                //1-1-1. 그대로 이어 붙이기
                builder.append(c);
                toUppere = true;
            } else {
                //알파벳 처리
                if (toUppere) {
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(Character.toLowerCase(c));
                }

                toUppere = !toUppere;
            } 
                
        }
        return builder.toString();
    }
    
    

}
