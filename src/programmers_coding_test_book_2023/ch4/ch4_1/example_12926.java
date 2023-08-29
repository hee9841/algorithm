package programmers_coding_test_book_2023.ch4.ch4_1;

/**
 * packageName    : programmers_coding_test_book_2023.ch4.ch4_1
 * fileName       : example_12926
 * author         : asdfz
 * date           : 2023-08-29
 * description    : 시저 암호
 * https://school.programmers.co.kr/learn/courses/30/lessons/12926
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-29        asdfz       최초 생성
 */
public class example_12926 {


    public static void main(String[] args) {
        System.out.println(solution("AB", 1));
        System.out.println(solution("z", 1));
        System.out.println(solution("a B z", 4));
    }

    
    //히든 테스트 통과 못함
    public static String my_solution(String s, int n) {
        //1. 입력 문자열의 모든 문자에 대해 반복
        //1-2. 알파벳이 아닌경우 그대로 이어 붙이기
        //1-2 알파벳인 경우 n만큼 밀어붙이기
        StringBuilder stringBuilder = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isAlphabetic(arr[i])) {
                if (arr[i] == 'Z') {
                    arr[i] = (char) ('A' + n - 1);
                } else if (arr[i] == 'z') {
                    arr[i] = (char) ('a' + n - 1);
                } else {
                    arr[i] = (char) (arr[i] + n);
                }
            }
            stringBuilder.append(arr[i]);
        }

        return stringBuilder.toString();
    }


    public static String solution(String s, int n) {
        //1. 입력 문자열의 모든 문자에 대해 반복
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            //c를 n만큼 문자를 builder에 이어 붙이기
            builder.append(push(c, n));
        }

        return builder.toString();

    }

    //c를 n만큼 문자를 builder에 이어 붙이는 메서드 분리
    public static char push(char c, int n) {
        //c를 n만큼 문자를 이어 붙이기
        //1-2. 알파벳이 아닌경우 그대로 이어 붙이기
        if(!Character.isAlphabetic(c)) return c;

        //1-2 알파벳인 경우 n만큼 밀어붙이기
        //isUpperCase 대문자인지 확인하는 메서드
        int offset = Character.isUpperCase(c) ? 'A' : 'a';      //대문자면 offset를 A, 소문자면 a로 설정
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (offset + position);

    }
}
