package programmers.week4;

import java.util.Stack;

/**
 * packageName    : programmers.week4
 * fileName       : bracket
 * author         : asdfz
 * date           : 2023-06-27
 * description    : https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-27        asdfz       최초 생성
 */
public class bracket {


    boolean solution(String s) {
        //괄호에 관한 cnt로
        //"("이면 +1, ")"이면 -1함
        int cnt = 0;
        for(int i =0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt ++;
            }
            if (s.charAt(i) == ')') {
                cnt --;
            }

            //cnt가 0보다 작은 경우 짝이 안맞는 경우로 break
            if(cnt < 0) {
                break;
            }
        }
        //cnt가 0이면 true, 아니면 false 리턴
        return (cnt == 0);
    }

    boolean solution2(String s) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push("(");
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }



        return stack.isEmpty();
    }



}
