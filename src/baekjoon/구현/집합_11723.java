package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11723
 */
public class 집합_11723 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        int S = 0;
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("all")) {
                S = (1 << 21) - 1;
                continue;
            }
            if (op.equals("empty")) {
                S = 0;
                continue;
            }
            int k = Integer.parseInt(st.nextToken());
            switch (op) {
                case "add":
                    S |= (1 << k);
                    break;
                case "remove":
                    S &= ~(1 << k);
                    break;
                case "check":
                    sb.append((S & (1 << k)) !=0 ? "1" : "0").append("\n");
                    break;
                case "toggle":
                    S ^= (1 << k);
                    break;
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

}
