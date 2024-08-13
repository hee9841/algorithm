package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10431
 */
public class 줄세우기_10431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            int cnt = 0;
            int[] arr = new int[20];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int tastCaseNum = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 20; i++) {
                arr[i]= Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if(arr[i] < arr[j]){
                        cnt++;
                    }
                }
            }
            sb.append(tastCaseNum).append(" ").append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
