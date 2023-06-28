package programmers.week4;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * packageName    : programmers.week4
 * fileName       : heap
 * author         : asdfz
 * date           : 2023-06-26
 * description    : 더 맵게 (heap), https://school.programmers.co.kr/learn/courses/30/lessons/42626
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-26        asdfz       최초 생성
 */
public class heap {

    public static void main(String[] args) {
        //낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
        PriorityQueue<Integer> q = new PriorityQueue<>();
//1, 2, 3, 9, 10, 12
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(9);
        q.add(10);
        q.add(12);

        PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());

        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(9);
        q2.add(10);
        q2.add(12);

        for (Integer i : q) {
            System.out.println(i);
        }

        System.out.println("------------------");

        for (Integer i : q2) {
            System.out.println(i);
        }
    }


    public int solution(int[] scoville, int K) {

        int answer = 0;
        //우선 순의 큐, 낮은 숫자가 우선 순위인 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        //높은 숫자가 우선 순위인 큐 선언 방법
        //PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int j : scoville) {
            queue.add(j);
        }

        while(queue.peek() < K) {
            //모든 음식을 K 이상으로 만들 수 없는 경우
            if (queue.size() == 1) {
                return -1;
            }
            
            //섞은 음식의 스코빌 지수 추가
            queue.add(queue.poll() + queue.poll() * 2);
            //섞은 횟수
            answer++;
        }

        return answer;
    }


}
