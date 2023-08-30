package programmers_coding_test_book_2023.ch4.ch4_2;

/**
 * packageName    : programmers_coding_test_book_2023.ch4.ch4_2
 * fileName       : example3_70129
 * author         : asdfz
 * date           : 2023-08-29
 * description    :이진 변환 반복하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-29        asdfz       최초 생성
 */
public class example3_70129 {

    public int[] solution(String s) {
        //1. s가 1이 될때까지 반복하며 loop, removed 누적
            //1-A. 문자열에 포함된 0의 개수 세기
                //1-A-i. 0의 개수와 제거 횟수 누적
            //1-B. 나머지 1의 개수를 사용해서 2진법으로 변환하여 1부터 반복

        //변환횟수
        int loop = 0;
        //제거된 0의 갯수
        int removed = 0;

        //1. s가 1이 될때까지 반복하며 loop, removed 누적
        while (!s.equals("1")) {
            //1-A-i. 0의 개수와 제거 횟수 누적
            int zeros = countZeros(s);
            loop += 1;
            removed += zeros;

            //1-B. 나머지 1의 개수를 사용해서 2진법으로 변환하여 1부터 반복
            int ones = s.length()- zeros;
            s = Integer.toString(ones, 2);
            
        }
        
        return new int[]{loop, removed};
    }

    //1-A. 문자열에 포함된 0의 개수 세기
    private int countZeros(String s) {
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if(c == '0') zeros++;
        }

        return zeros;
    }
}
