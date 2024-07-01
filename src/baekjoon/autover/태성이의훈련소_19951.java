package baekjoon.autover;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 2024 하반기 오토에버 코테 1번문제 유형
 * https://www.acmicpc.net/problem/19951
 * =======================================
 * <풀이>
 * 누적합 grounds배열에서
 * grounds[start]에는 grounds[start]+k 값을 넣어주고
 * grounds[end+1] 에는 grounds[end+1] -k 값을 넣어줌
 * <p>
 * 추후에 누적합 계산 시
 * start ~ end까지 k값이 체워지고
 * end+1 에는 다시 이전 상태로 복구하기 위해 -k를 해줌
 * <p>
 * ex) 1 5 -3 이면
 * -3  0  0  0  0 3 0 0 0 0 이 되고 이를 누적합 해주면
 * -3 -3 -3 -3 -3 0 0 0 0 0 이 되는 것을 확인할 수 있음
 * </풀이>
 */
public class 태성이의훈련소_19951 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ground = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            ground[i] = Integer.parseInt(st.nextToken());
        }

        int[] grounds = new int[N + 2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            grounds[start] += k;
            grounds[end + 1] -= k;
        }

        //누적합
        for (int i = 1; i < N + 1; i++) {
            grounds[i] = grounds[i - 1] + grounds[i];
        }

        //기존 흙 합치기
        for (int i = 1; i < N + 1; i++) {
            ground[i] = ground[i] + grounds[i];
        }

        for (int i = 1; i < N + 1; i++) {
            sb.append(ground[i]).append(" ");
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }

}
