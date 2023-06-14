package programmers.Kakao_blind_2020;


/**
 * packageName    : programmers.Kakao_blind_2020
 * fileName       : 문자열압축
 * author         : asdfz
 * date           : 2023-06-12
 * description    : 프로그래머스 kakao blind 2020 https://school.programmers.co.kr/learn/courses/30/lessons/60057
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-12        asdfz       최초 생성
 */
public class 문자열압축 {

    public static void main(String[] args) {

        Solution test1 = new Solution();

        int aabbaccc = test1.solution("aabbaccc");

        System.out.println("test1 = " + aabbaccc);


    }
}

//문자열 나누는 단위 수
//  2~입력된문자열길이/2
//가장 짧은 문자 길이 리턴
class Solution {

    public int solution(String s) {

        int answer = s.length();       //최소 문자열 길이를 단어길이로 선언
        
        //단어 단위가 단어길의의 절반을 넘어가면 2번이상 반복하지 않기 때문에 소용 없음
        for (int i = 1; i <= s.length()/2; i++) {
            //비교 시 현재 단어
            String nowStr = s.substring(0, i);
            //단어 count, s.substring(0, i)에 대해서 미리 cnt +1
            int cnt = 1;
            
            //압축한 단어
            StringBuilder resultStr = new StringBuilder();

            //단어 비교하며 단어 압축
            for (int j = i; j <s.length(); j += i) {
                
                //비교할 다음 단어
                String nextStr = s.substring(j ,Math.min(j + i, s.length()));

                if (nowStr.equals(nextStr)) {
                    //현재 단어랑 다음 단어랑 같을 시 cnt++
                    cnt++;
                } else {
                    //다르면 현재 단어 압축
                    if (cnt > 1) {
                        //cnt가 1보다 크면 cnt 앞축한 단어에 append
                        resultStr.append(cnt);
                    }
                    //단어 append
                    resultStr.append(nowStr);
                    nowStr = nextStr;
                    
                    //cnt 초기화
                    cnt = 1;
                }

            }
            //마지막 단어 append
            if (cnt > 1) {
                resultStr.append(cnt);
            }
            resultStr.append(nowStr);

//            System.out.println("단위: " + i + ", 문자열 : " + resultStr + ", strlen: " + resultStr.length());


            answer = Math.min(answer, resultStr.length());
        }
//        System.out.println("answer = " + answer);


        return answer;
    }
}


