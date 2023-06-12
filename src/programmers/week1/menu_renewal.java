package programmers.week1;

import java.util.*;

/**
 * packageName    : programmers
 * fileName       : menu_renewal
 * author         : asdfz
 * date           : 2023-06-09
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-09        asdfz       최초 생성
 */
public class menu_renewal {
    public static void main(String[] args) {
        //test case 1
//        String[] order1 = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] course1 = new int[]{2, 3, 4};
//        String[] solution1 = Solution.solution(order1, course1);
//        System.out.println("solution1 = " + Arrays.toString(solution1));


        //test case 2
//        String[] order2 = new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course2 = new int[]{2, 3, 5};
//        String[] solution2 = Solution.solution(order2, course2);
//        System.out.println("solution2 = " + Arrays.toString(solution2));


        //test case 3
        String[] order3 = new String[]{"XYZ", "XWY", "WXA"};
        int[] course3 = new int[]{2, 3, 4};
        String[] solution3 = Solution.solution(order3, course3);
        System.out.println("solution3 = " + Arrays.toString(solution3));

    }
}

class Solution {

    static List<String> answerList = new ArrayList<>();
    static Map<String, Integer> hashMap = new HashMap<>();


    public static String[] solution(String[] orders, int[] course) {
        //1. 각 order 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();   //order[i]를 char array로 변환 후
            Arrays.sort(arr);   //정렬
            orders[i] = String.valueOf(arr);    //정렬한 값을 다시 넣어줌
        }


        // 2. 코스 길이 별 조합 생성
        for (int courseLen : course) {
            // 2-1. 각 order 별로 조합, 재귀합수로 구현
            for (String order : orders) {
                //처음에는 아지까지 조합된게 없어서 order는 ""으로
                combination("", order, courseLen);  //재귀합수
            }
            // 3. 가장 많은 조합 저장
            if (!hashMap.isEmpty()) {
                //hashMap value 중에서 Max값
                List<Integer> countList = new ArrayList<>(hashMap.values());
                //조합중에 max 값
                int max = Collections.max(countList);

                //2개 이상의 조합에서만 유효하다고 해서
                if (max > 1) {
                    for (String key : hashMap.keySet()) {
                        if (hashMap.get(key) == max) {
                            //해당 조합의 개수가 max이면
                            answerList.add(key);
                        }
                    }
                }
                //다음 코스 length의 조합을 위해
                hashMap.clear();
            }
        }
        //정렬
        Collections.sort(answerList);


        return answerList.toArray(new String[0]);
    }

    /**
     * 메뉴 조합 (재귀합수)
     *
     * @param order  현재까지 조합된 코스
     * @param others 아직까지 사용되지 않는 알파벳
     * @param count  몇개로 조합되어야 하는지
     */
    public static void combination(String order, String others, int count) {
        //모든 재귀함수의 필요조건은
        //1. 탈출 조건
        //2. 수행 동작

        //11. 탈출 조건 : count가 0이 되었을 때
        if (count == 0) {
            //getOrDefault order라는 키가 존재하 지 않으면 defaultValue 반환
            //처음 hashMap에 들어가면 1로,
            //그 이후 부터는 +1되어서
            hashMap.put(order, hashMap.getOrDefault(order, 0) + 1);
            return;
        }

        //2. 수행 동작 : 0 부터 length까지 조합한다.
        for (int i = 0; i < others.length(); i++) {
            //재귀 호출
            // order : 현재까지 조합 + 아직 사용되지 안는 알파벳들의 i번쨰 char
            // others : others 의 i+1 이후 문자들
            combination(order + others.charAt(i), others.substring(i + 1), count - 1);
        }
    }
}
