package programmers_coding_test_book_2023.ch6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * packageName    : programmers_coding_test_book_2023.ch6
 * fileName       : example1_42840
 * author         : asdfz
 * date           : 2023-09-18
 * description    : 모의고사
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-18        asdfz       최초 생성
 */
public class example1_42840 {

    private static int[][] RANDOM_ANSWER = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    int max_score = Integer.MIN_VALUE;
    int[] scores = new int[3];


    public int[] my_solution(int[] answers) {
        //1. rule
        //   1 : 1,2,3,4,5
        //   2 : (2,1), (2,3), (2,4), (2,5)
        //   3 : (3,3), (1,1), (2,2), (4,4), (5,5)
        // 맞춘답 갯수 세기
        for (int p = 0; p < RANDOM_ANSWER.length; p++) {
            scores[p] = getScore(answers, p);
            max_score = Math.max(max_score, scores[p]);

        }

        return IntStream.range(0, 3)
            .filter(i -> scores[i] == max_score)
            .map(i -> i + 1).toArray();
    }

    private int getScore(int[] answers, int person) {
        int score = 0;
        //수포자별 맞춘 점수
        int iterative_count = RANDOM_ANSWER[person].length;
        for (int answer_idx = 0; answer_idx < answers.length; answer_idx++) {
            if (answers[answer_idx] == RANDOM_ANSWER[person][answer_idx % iterative_count]) {
                score++;
            }
        }
        return score;
    }


    // *****  책풀이 *****
    private static int[][] RULES = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };


    public int[] solution(int[] answers) {
        int[] corrects = new int[3];
        int max = 0;
        for (int problem = 0; problem < answers.length; problem++) {
            int answer = answers[problem];

            //수포자별 정답 개수 세기
            for (int person = 0; person < 3; person++) {
                int picked = getPicked(person, problem);
                if (answer == picked) {
                    //max 업데이트
                    if (++corrects[person] > max) {
                        max = corrects[person];
                    }
                }
            }
        }

        final int maxCorrects = max;

        return IntStream.range(0,3)
            .filter(i -> corrects[i] == maxCorrects)
            .map(i -> i +1).toArray();
    }

    //찍은 답
    private int getPicked(int person, int problem) {
        int[] rule = RULES[person];
        int index = problem % rule.length;
        return rule[index];

    }
}
