package baekjoon.autover;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 2024 하반기 오토에버 코테 1번문제 유형
 * https://www.acmicpc.net/problem/19951
 */
public class 태성이의훈련소_19951 {

    private static HashMap<Integer, Integer> map;
    private static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            int soil = Integer.parseInt(st.nextToken());
            map.put(i, soil);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int j = start; j <= end; j++) {
                map.put(j, map.get(j) + k);
            }
        }

        for (int i = 1; i < N + 1; i++) {
            sb.append(map.get(i)).append(" ");
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }

}
