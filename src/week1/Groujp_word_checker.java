package week1;

//import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Groujp_word_checker {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {


        //첫번째 줄 입력은 100보다 작은 수 N입력(입력할 단어의 개수0

        //그 다음 줄부터 N개의 줄단어가 들어옴

        //알파벳은 소문자, 중복X지 않으면 단어 기이는 최대 100

        for (int j = 0; j < 6; j++) {
            System.out.println("N을 입력하세요.");
            int count = 0;

            //단어 수 스캔
            int n = Integer.parseInt(br.readLine());

            if (n < 1 || n > 100) {
                do {
                    System.out.println("단어수는 100보다 작거나 같은 자연수 입니다.");
                    n = Integer.parseInt(br.readLine());
                } while ( n > 0 && n <= 100);
            }


            for (int i = 0; i < n; i++) {
                if (check()) {
                    count++;
                }
            }

            System.out.println(count);
        }


    }

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
