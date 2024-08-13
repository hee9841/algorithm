package baekjoon.dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1697
 */
public class 숨박꼭질_1697 {

    private static Queue<Integer> q;
    private static int[] visitedSec;
    private static int K;


    static void bfs(int N) {
        q = new LinkedList<Integer>();
        q.add(N);
        visitedSec[N] = 1;

        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = now -1;
                } else if (i == 1) {
                    next = now + 1;
                } else {
                    next = 2 * now;
                }

                if (next == K) {
                    System.out.println(visitedSec[now]);
                    return;
                }
                if (next >= 0 && next < visitedSec.length && visitedSec[next] == 0) {
                    visitedSec[next] = visitedSec[now] +1;
                    q.add(next);
                }

            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        visitedSec = new int[100001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }



        br.close();
    }



}
