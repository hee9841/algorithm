package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7568
 */
public class 덩치_7568 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];
        int[] rank = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people[i][0] = weight;
            people[i][1] = height;
        }

        for (int i = 0; i < N; i++) {
            int[] nowP = people[i];
            for (int j = i + 1; j < N; j++) {
                int[] nextP = people[j];
                if (nowP[0] > nextP[0] && nowP[1] > nextP[1]) {
                    rank[i]++;
                    continue;
                }
                if (nowP[0] < nextP[0] && nowP[1] < nextP[1]) {
                    rank[j]++;
                    continue;
                }
                rank[i]++;
                rank[j]++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(N - rank[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

