package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
/**
 * https://www.acmicpc.net/problem/11723
 */
public class 집합_11723 {

    private static HashSet<Integer> S = new HashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int x = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

            operate(op, x);

        }
    }

    private static void operate(String op, int x) {
        switch (op) {
            case "add":
                add(x);
                return;
            case "remove":
                remove(x);
                return;
            case "check":
                System.out.println(check(x) ? "1" : "0");
                return;
            case "toggle":
                toggle(x);
                return;
            case "all":
                all();
                return;
            default:
                //"empty":
                empty();
        }
    }


    private static boolean check(int x) {
        return S.contains(x);
    }

    private static void add(int x) {
        if (!check(x)) {
            S.add(x);
        }
    }

    private static void remove(int x) {
        if (check(x)) {
            S.remove(x);
        }
    }

    private static void toggle(int x) {
        if (check(x)) {
            S.remove(x);
        } else {
            S.add(x);
        }
    }

    private static void all() {
        for (int i = 1; i < 21; i++) {
            add(i);
        }
    }

    private static void empty() {
        S = new HashSet<>();
    }

}
