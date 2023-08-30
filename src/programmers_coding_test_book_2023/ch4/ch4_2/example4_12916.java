package programmers_coding_test_book_2023.ch4.ch4_2;

/**
 * packageName    : programmers_coding_test_book_2023.ch4.ch4_2
 * fileName       : example4_12916
 * author         : asdfz
 * date           : 2023-08-29
 * description    : 문자열 내 p와 y의 개수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12916
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-29        asdfz       최초 생성
 */
public class example4_12916 {

    
    //내 솔루션
    boolean my_solution(String s) {
        boolean answer = true;
        //1. 문자열을 lower로 바꿈
        s = s.toLowerCase();
        //2. 'p'의 갯수 세기
        int pCnt = findChar("p", s);
        //3. 'y'의 갯수 세기
        int yCnt = findChar("y", s);


        if(pCnt != 0 || yCnt !=0) {
            System.out.println("ffff");
        }


        return answer;
    }


    int findChar(String c, String s) {
        int cnt = 0;
        while(s.contains(c)) {
            s = s.replaceFirst(c, "");
            cnt++;
        }

        return cnt;
    }



    /*
    * *****************************/

    boolean solution(String s) {
        boolean answer = true;
        //1. 문자열을 lower로 바꿈
        s = s.toLowerCase();
        //2.p의 개수 세기
        //2-1."p"를 ""로 치환
        //2-2. 원본 문자열과 치환된 문자열의 길이 차이 가 p의 개수
        int ps = s.length() - (s.replace("p", "")).length();
        //3. y이도 같은 방식으로
        int ys = s.length() - (s.replace("y", "")).length();

        return ps == ys;
    }

}
