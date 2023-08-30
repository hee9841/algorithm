package programmers_coding_test_book_2023.ch4.ch4_2;

/**
 * packageName    : programmers_coding_test_book_2023.ch4.ch4_2
 * fileName       : example7_72410
 * author         : asdfz
 * date           : 2023-08-30
 * description    : 신규 아이디 추천
 * https://school.programmers.co.kr/learn/courses/30/lessons/72410
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-30        asdfz       최초 생성
 */
public class example7_72410 {

    public String solution(String new_id) {
        //1단계 소문자 치환
        new_id = new_id.toLowerCase();
        //2. 소문자, 숫자, '-,_,.'를 제외한 문자 제거
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");
        //3. .가 2번이상 연속되면 .으로 치환
        new_id = new_id.replaceAll("\\.+", ".");
        //4. .이 처음이나 끝에 위치하면 제거
        new_id = new_id.replaceAll("^\\.+|\\.+$", "");
        //5. id가 빈문자열이면 new_id에 "a" 대입
        if(new_id.isEmpty()) new_id = "a";
        //6. 길이가 16이상이면 15문자를 제외한 나머지 문자들 제거, 제거후 끝에 .있으면 .제거
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0,15);
            new_id = new_id.replaceAll("\\.+$", "");
        }
        //7. 길이가 2자 이하면 id의 마지막 문자를 길이가 3이상이 될때까지 반복해 끝에 붙임
        while(new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() -1);
        }

        return new_id;
    }


}
