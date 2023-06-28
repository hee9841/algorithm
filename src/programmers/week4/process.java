package programmers.week4;

import java.util.*;

/**
 * packageName    : programmers.week4
 * fileName       : process
 * author         : asdfz
 * date           : 2023-06-28
 * description    : https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-28        asdfz       최초 생성
 */
public class process {

    public static void main(String[] args) {
        //CD
        //AB

        System.out.println(Solution.solution(new int[]{2, 1, 3, 2} , 2));

    }

    class Solution {
        public static int solution(int[] priorities, int location) {


            int answer = 0;

            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

            for (int i : priorities) {
                queue.add(i);
            }

            while (!queue.isEmpty()) {
                for (int i = 0; i < priorities.length; i++) {
                    //값이 같으면
                    if (priorities[i] == queue.peek()) {
                        queue.poll();
                        answer ++;

                        if (i == location) {
                            //i값과 location값 까지 같으면
                            return answer;
                        }
                    }
                }
            }

            return answer;
        }
    }

}



