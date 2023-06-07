package week1;

/**
 * 백준 - 그룹 단어 체커 (https://www.acmicpc.net/problem/1316)
 *
 * =========================================================
 * 문제
 * ----------------------------------------------------------
 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
 * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
 * aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 *
 * =========================================================
 * 입력
 * ----------------------------------------------------------
 * 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다.
 * 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
 *
 * =========================================================
 * 출력
 * ----------------------------------------------------------
 * 첫째 줄에 그룹 단어의 개수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Group_word_checker {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {


        //첫번째 줄 입력은 100보다 작은 수 N입력(입력할 단어의 개수0

        //그 다음 줄부터 N개의 줄단어가 들어옴

        //알파벳은 소문자, 중복X지 않으면 단어 기이는 최대 100


            System.out.println("N을 입력하세요.");
            int count = 0;

            //단어 수 스캔
            int n = Integer.parseInt(br.readLine());

            //필요없음
//            if (n < 1 || n > 100) {
//                do {
//                    System.out.println("단어수는 100보다 작거나 같은 자연수 입니다.");
//                    n = Integer.parseInt(br.readLine());
//                } while ( n > 0 && n <= 100);
//            }


            for (int i = 0; i < n; i++) {
                if (check()) {
                    count++;
                }
            }

            System.out.println(count);


    }


    /**
     * 단어 체크
     * @return boolean (그룹단어일 경우 true, 아니면 flase 리턴)
     * @throws IOException IOException
     */
    public static boolean check() throws IOException {
        //알파벳 수 만큼(a~z까지, a)
        boolean[] check = new boolean[26];
        int prev = 0;

        //글자 입력
        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {

            int nowChar = word.charAt(i);

            //앞의 문자와 혖재 문자가 같지 않으면
            if (prev != nowChar) {
                //현재 문자가 처음 나오는 경우
                if (!check[nowChar - 'a']) {
                    check[nowChar - 'a'] = true;
                    prev = nowChar;
                } else {
                    //이미 나온적 있으면
                    //그룹단어가 아님
                    return false;
                }
            }

        }

        return true;
    }
}
