package programmers.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : programmers.week2
 * fileName       : VowelDictionary
 * author         : asdfz
 * date           : 2023-06-14
 * description    : 프로그래머스 모음 사전 (https://school.programmers.co.kr/learn/courses/30/lessons/84512)
 * 완전탐색
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-14        asdfz       최초 생성
 */
public class VowelDictionary {

    public static void main(String[] args) {

    }



    //내풀이
    public static int solution(String word) {
        String vowel = "AEIOU";
        //index 별 곱해지는 인자
        int[] a = new int[]{781, 156, 31, 6, 1};
        int answer = word.length();
        for (int i = 0; i < word.length(); i++) {
            int idx = vowel.indexOf(word.charAt(i));
            answer += a[i] * idx;
        }
        return answer;
    }

    // 다른사람 - 수학적
    public int solution1(String word) {
        int answer = 0, per = 3905;
        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        return answer;
    }

    //다른사람 - dfs 이용
    List<String> list = new ArrayList<>();
    void dfs(String str, int len) {
        if(len > 5) return;
        list.add(str);
        for(int i = 0; i < 5; i++) dfs(str + "AEIOU".charAt(i), len + 1);
    }
    public int solution2(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }


   
}
