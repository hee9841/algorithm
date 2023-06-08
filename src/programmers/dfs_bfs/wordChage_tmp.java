package programmers.dfs_bfs;

/**
 * packageName    : programmers.dfs_bfs
 * fileName       : wordChage
 * author         : asdfz
 * date           : 2023-06-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-07        asdfz       최초 생성
 */
public class wordChage_tmp {

    static int answer = 99999;
    static boolean[] visited;


    public static void main(String[] args) {

        int answer = solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(answer);


    }

    public static int solution(String begin, String target, String[] words) {

        for (int i = 0; i < words.length; i++) {
            if (compare(begin, words[i]) <= 1) {
                visited = new boolean[words.length];
                visited[i] = true;
                dfs(1, i, target, words);
            }
        }



        return answer;
    }

    static void dfs(int cnt, int cur, String target, String[] words) {
        if (target.equals(words[cur])) {
            answer = Math.min(cnt, answer);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && compare(words[cur], words[i]) == 1) {
                visited[i] = true;
                dfs(cnt + 1, i, target, words);
                visited[i] = false;
            }
        }
    }

    /**
     * 글자 비교 함수
     * @param s1 비교 단어1
     * @param s2 비교 단어2
     * @return boolean(true: 다른 알파벳이 한개이면, false: 그외)
     */
    static int  compare(String s1, String s2) {
        int n = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                n++;
            }
        }

        return n;
    }
//
//    public static void dfs(String begin, String target, String[] words, int cnt) {
//        if (begin.equals(target)) {
//            answer = Math.min(cnt, answer);
//            return;
//        }
//
//        for (int i = 0; i <words.length; i++) {
//            //이미 방문한 단어이면
//            if (visited[i]) {
//                continue;
//            }
//
//            //같은 스펠링 단어 세기
//            int k =0;
//            for (int j = 0; j < begin.length(); j++) {
//                if (begin.charAt(j) == words[i].charAt(j)) {
//                    k++;
//                }
//            }
//
//            //한글자 빼고 모두 같은 경우 변경
//            if (k == begin.length() - 1) {
//                visited[i] = true;
//                dfs(words[i], target, words, cnt + 1);
//            }
//
//
//        }
//    }
}
