package programmers.week1.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * packageName    : programmers.week1.dfs_bfs
 * fileName       : wordChage
 * author         : asdfz
 * date           : 2023-06-07
 * description    : 
 * 최소로하여 단어에 도달 , 초기 상태분터 목표 단계까지 최단 경로 찾는 문제로 
 * BFS사용
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-07        asdfz       최초 생성
 */
public class wordChage {



    public static void main(String[] args) {
        
        

        int answer = Solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(answer);


    }

}

class Solution {


    //2. 상태 정의
    private static class State {
        public final String word;  //단어, 상태에 대한 중복 검사에 사용
        public final int step;     //변환 횟수, 상태변수X, 정답 추적하는 변수

        private State(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }


    /**
     * 변환될 수 있는지 확인하는 메소드
     * (1. 두 단어는 하나의 문자만 다를 때 변환될 수 있음)
     * @param s1 단어1
     * @param s2 단어2
     * @return boolean(변환가능 여부)
     */
    private static boolean isConvertable(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        int diff = 0;
        for (int i = 0; i < s1Arr.length; i++) {
            if (s1Arr[i] != s2Arr[i]) diff++;
        }

        return diff ==1;
    }

    public static int solution(String begin, String target, String[] words) {

        //3. 방문 검사 배열 선언
        boolean[] isVisited = new boolean[words.length];

        //4. 초기 상태
        //-> BFS에서 사용되는 큐를 선언하고 초기 상태를 넣어줌
        //-> 초기 상태의 단어는 begin이고,
        //-> 초기 단어에서 begin까지의 변환 횟수가 0이라서 step은 0
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(begin, 0));

        //5. 탐색 진행
        while (!queue.isEmpty()) {
            //queue 값 제거
            //1. remove() : 큐 맨 앞에 있는 값 반환 후 삭제, 큐가 비어있을 경우 NoSuchElementException 에러 발생
            //2. poll()   : 큐 맨 앞에 있는 값 반환 후 삭제, 큐가 비어있을 경우 null 반환
            //3. clear()  : 큐 비우기
            State state = queue.poll();

            //6. 현재 상태 처리
            if (state.word.equals(target)) {
                //해당 상태에 있는 단어가 target과 같은면 정답에 도달한 것으로 변환 횟수 반환
                return state.step;
            }

            //7. 전이 상태 생성
            for (int i = 0; i < words.length; i++) {
                //정답이 아니면 단어를 변환시켜 상태 전의 수행,
                //words에 있는 모든 단어를 순회하며 저니할 수 있는 단어를 골라냄
                String next = words[i];

                //8.유효성 검사 & 중복 검사
                if (!isConvertable(state.word, next)) {
                    continue;
                }

                if (isVisited[i]) {
                    continue;
                }

                //9. 방문 처리 && 상태 정의
                isVisited[i] = true;    //검사 통과한 상태는 전이될 수 있는 상태로 방문 처리
                queue.add(new State(next, state.step + 1));     //탐색 공간에 추가

            }

        }

        //모든 공간을 탐색 했는데 정답 상태를 방문하지 못하면 0를 반환
        return 0;

    }


}


