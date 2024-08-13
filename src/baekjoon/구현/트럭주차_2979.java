package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2979
 */
public class 트럭주차_2979 {
    private static int maxTime = Integer.MIN_VALUE;
    private static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] carsCnt = new int[100];

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            maxTime = Math.max(maxTime, endTime);
            minTime = Math.min(minTime, startTime);

            for (int t = startTime; t < endTime; t++) {
                carsCnt[t] += 1;
            }
        }


        int answer =0;

        for (int i = minTime; i < maxTime; i++) {
            if (carsCnt[i] == 1) {
                answer += A;
            }
            if (carsCnt[i] == 2) {
                answer += (B * 2);
            }
            if (carsCnt[i] == 3) {
                answer += (C * 3);
            }
        }

        System.out.println(answer);
    }
}
