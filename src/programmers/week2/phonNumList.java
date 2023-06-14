package programmers.week2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * packageName    : programmers.week2
 * fileName       : phonNumList
 * author         : asdfz
 * date           : 2023-06-14
 * description    : 프로그래머스 (https://school.programmers.co.kr/learn/courses/30/lessons/42577)
 * hash
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-14        asdfz       최초 생성
 */
public class phonNumList {


    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123","456","189"}));
        System.out.println(solution(new String[]{"12","123","1235","567","88"}));

    }


    
    //hash 문제는 hash로, 시간 복잡도
    public static boolean solution(String[] phone_book) {

        Map<String, Integer> map = new HashMap<>();

        for (String value : phone_book) {
            map.put(value, 0);
        }

        for (String num : phone_book) {
            for (int i = 1; i < num.length(); i++) {
                //num 접두어가 map에 있는지 확인
                if (map.containsKey(num.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }

    //1.문자열 길이순으로 정렬
    //2. 반복문으로 확인


    public static boolean solution1(String[] phone_book) {


        //1.문자열 길이순으로 정렬
        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });


        for (int i = 0; i < phone_book.length; i++) {
            String prefix = phone_book[i];

            //0 1 2 3 4 5
            for (int j = i + 1; j < phone_book.length; j++) {
                if (prefix.equals(phone_book[j].substring(0, prefix.length()))) {
                    return false;
                }
            }

        }

        return true;
    }

    public static boolean solution3(String[] phone_book) {
        

        //1.문자열 길이순으로 정렬
        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });


        for (int i = 0; i < phone_book.length; i++) {
            String prefix = phone_book[i];

            //0 1 2 3 4 5
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(prefix)) {
                    return false;
                }
            }

        }

        return true;
    }

}
