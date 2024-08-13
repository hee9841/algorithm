package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/8979
 */
public class 올림픽_8979 {

    private static int[] rank;
    private static int[] gold;
    private static int[] silver;
    private static int[] bronze;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        gold = new int[N + 1];
        silver = new int[N + 1];
        bronze = new int[N + 1];
        rank = new int[N + 1];

        //1.금 -> 은 -> 동

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int countryNum = Integer.parseInt(st.nextToken());
            gold[countryNum] = Integer.parseInt(st.nextToken());
            silver[countryNum] = Integer.parseInt(st.nextToken());
            bronze[countryNum] = Integer.parseInt(st.nextToken());
        }

        //등수확인(골드)
        for (int i = 1; i < N + 1; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                if (gold[i] == gold[j]) {
                    //실버 확인
                    checkSilver(i, j);
                    continue;
                }
                if (gold[i] > gold[j]) {
                    rank[i]++;
                    continue;
                }
                rank[j]++;
            }
        }

        sb.append(N - rank[k]);

        bw.write(sb.toString());

        bw.close();
        br.close();
    }

    private static void checkSilver(int i, int j) {
        if (silver[i] == silver[j]) {
            //브론즈 확인
            checkBronze(i, j);
            return;
        }
        if (silver[i] > silver[j]) {
            rank[i]++;
            return;
        }
        rank[j]++;
    }

    private static void checkBronze(int i, int j) {
        if (bronze[i] == bronze[j]) {
            rank[i]++;
            rank[j]++;
            return;
        }

        if (bronze[i] > bronze[j]) {
            rank[i]++;
            return;
        }

        rank[j]++;
    }


}
