package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1157
 */
public class 단어공부_1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = (br.readLine()).toUpperCase();

        int[] alpha = new int[26];

        for (char c : str.toCharArray()) {
            alpha[c - 'A'] += 1;
        }

        int max = -1;
        boolean moreThanTwo = false;
        int maxCase = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (max < alpha[i]) {
                moreThanTwo = false;
                max = alpha[i];
                maxCase = i;
                continue;
            }
            if (max == alpha[i]) {
                moreThanTwo = true;
            }
        }

        System.out.println(moreThanTwo ? "?" : (char) (maxCase + 'A'));
    }

}
