package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9017
 */
public class 클로스컨트리_9017 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TestCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TestCase; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N];
//            ArrayList<Teams> teams = new ArrayList<>();
            HashMap<Integer, Teams> teams = new HashMap();


            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                rank[i] = p;
                if (!teams.containsKey(p)) {
                    teams.put(p, new Teams(p));
                }
                Teams team = teams.get(p);
                team.count++;
            }

            int point = 0;
            for (int r : rank) {
                if (!teams.containsKey(r)) continue;

                Teams team = teams.get(r);
                if (team.count < 6) continue;
                team.addRank(++point);
            }

            int minPoint = Integer.MAX_VALUE;
            int winnerTeam = -1;
            for (Teams team : teams.values()) {
                if (team.count < 6) continue;
                if (team.points < minPoint) {
                    minPoint = team.points;
                    winnerTeam = team.name;
                    continue;
                }

                if (team.points == minPoint) {
                    Teams rankedTeam = teams.get(winnerTeam);
                    if (rankedTeam.ranks.get(4) > team.ranks.get(4)) {
                        winnerTeam = team.name;
                    }
                }

            }

            sb.append(winnerTeam).append("\n");

        }

        bw.write(sb.toString());


        br.close();
        bw.close();
    }


    static class Teams {
        private ArrayList<Integer> ranks;
        private int name;
        private int count;
        private int points;

        public Teams(int name) {
            this.name = name;
            this.ranks = new ArrayList<>();
            this.count = 0;
            this.points=0;
        }

        public void addRank(int rank) {
            ranks.add(rank);
            if (ranks.size() <= 4) {
                points += rank;
            }
        }

//        @Override
//        public boolean equals(Object obj) {
//            if(obj instanceof Teams){
//                return name == ((Teams)obj).name;
//            } else {
//                return false;
//            }
//        }
    }



}
