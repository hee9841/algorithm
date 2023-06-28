package programmers.week3;

import java.util.Stack;

/**
 * packageName    : programmers.week3
 * fileName       : Stock_stackNqueue
 * author         : asdfz
 * date           : 2023-06-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-23        asdfz       최초 생성
 */
public class Stock_stackNqueue {



}

class Solution1 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length]; //최대기간
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < prices.length; i++) {
            // prices[stack.peek()] 과 비교해
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                //감소하면
                // i(현재 주식이 감소한 시점) - stack.peek()(주식이 처음 들어간 시점)
                answer[stack.peek()] = i - stack.peek();
                stack.pop(); // 답을 구했기 때문에 stack에서 제거
            }
            //주식이 감소하지 않으면 stack에 idx push
            stack.push(i);
        }

        while (!stack.isEmpty()) { 
            // 값을 구하지 못한 주식, 즉 index == 끝까지 가격이 떨어지지 않은 주식
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }



    //다름ㄴ 사람 풀이
    public int[] solution2(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}
