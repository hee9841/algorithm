package programmers.week4;

import java.util.*;
import java.util.stream.Collectors;

/**
 * packageName    : programmers.week4
 * fileName       : h_index
 * author         : asdfz
 * date           : 2023-06-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-27        asdfz       최초 생성
 */
public class h_index {

    public static void main(String[] args) {
//        solution2(new int[]{3, 9, 1, 7, 4, 8,});
//        System.out.println(solution2(new int[]{0, 1, 3, 5, 6}));

        System.out.println(solution(new int[]{0,1,1,1,3, 3,  4, 5,6, 6}));
        System.out.println(solution2(new int[]{0,1,1,1,3, 3, 4,5,6,6}));
    }

    public static int solution(int[] citations) {


        //정렬 오름차순
        Arrays.sort(citations);

        int answer = 0;

        for (int i = 0; i < citations.length; i++) {
            //오름차순으로 정렬된 citations에서
            //citations[i]번 이상 인용된 논문수
            int h = citations.length - i;

            //citations의 i번째 논문이 인용된 수가 citations[i]번 이상 인용된 논문수보다 크거나 같으면
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }

    public static int solution2(int[] citations) {


        //정렬 오름차순
        Arrays.sort(citations);

        int answer = 0;

        System.out.println("citations.toString() = " + Arrays.toString(citations));

        for (int i = 0; i < citations.length; i++) {

            if (citations[i] <= (citations.length - i )) {
                System.out.println("i = " + i +", citations[i]:" + citations[i]);
                answer = Math.max(answer, citations[i]);
            }

        }

        return answer;
    }

}
