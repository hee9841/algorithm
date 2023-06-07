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
public class wordChage {

    static int answer = 0;
    static boolean[] visited;


    public static void main(String[] args) {

        int answer = solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});



        System.out.println(answer);


    }

    public static int solution(String begin, String target, String[] words) {

        dfs(begin, target, words, 0);


        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = Math.min(cnt, answer);
            return;
        }

        for (int i = 0; i <words.length; i++) {
            //이미 방문한 단어이면
            if (visited[i]) {
                continue;
            }

            //같은 스펠링 단어 세기
            int k =0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            //한글자 빼고 모두 같은 경우 변경
            if (k == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
            }


        }
    }
}
