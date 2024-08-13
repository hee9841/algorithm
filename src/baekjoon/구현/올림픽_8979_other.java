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
 * https://www.acmicpc.net/problem/8979
 */
public class 올림픽_8979_other {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Nation> medalList = new ArrayList<>();
        //1.금 -> 은 -> 동

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int name = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            Nation nation = new Nation(name, gold, silver, bronze);
            medalList.add(nation);
        }

        //등수확인(골드)
        Collections.sort(medalList);
        medalList.get(0).rank = 1;

        int answer = 0;


        for (int i = 1; i < N; i++) {
            Nation now = medalList.get(i);
            Nation before = medalList.get(i - 1);

            if (now.name == k) {
                answer = i;
            }
            if (now.gold == before.gold
                && now.silver == before.silver &&
                now.bronze == before.bronze) {
                now.rank = before.rank;
            } else {
                now.rank = i+1;
            }
        }

        bw.write(String.valueOf(medalList.get(answer).rank));

        bw.close();
        br.close();
    }



    static class Nation implements Comparable<Nation> {
        private int name;
        private int gold;
        private int silver;
        private int bronze;
        private int rank;

        public Nation(int name, int gold, int silver, int bronze) {
            super();

            this.name = name;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;

            this.rank=0;
        }

        @Override
        public int compareTo(Nation o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze;
                } else {
                    return o.silver - this.silver;
                }
            } else {
                return o.gold - this.gold;
            }
        }
    }


}
