package programmers_coding_test_book_2023.ch6;

/**
 * packageName    : programmers_coding_test_book_2023.ch6
 * fileName       : Example2_42842
 * author         : asdfz
 * date           : 2023-09-18
 * description    : 카펫
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-18        asdfz       최초 생성
 */
public class Example2_42842 {
    // width >= height



    public int[] my_solution(int brown, int yellow) {
        int width = 0;
        int height = 0;
        // y_height 는 노란 사각형 높이
        // 높이가 가로보다 작거나 같아야함으로
        //yellow의 제곱근 보다 작을동안 반복문
        for (int y_height = 1; y_height <= Math.sqrt(yellow); y_height++) {
            //높이가 될수있는 값이면
            if (yellow % y_height == 0) {
                //노란색 사각형의 가로를 구하고
                int y_width = yellow / y_height;
                //가로가 높이보다 크거나 같으면
                if (y_width >= y_height) {
                    //갈색 사각형 갯수 : 2 * (전체 카펫 가로 + 전체카펫 길이 -2) = 2 * ((노란색 가로 +2) + (노란색 높이 +2) -2)
                    if ((2 * (y_width + y_height + 2)) == brown) {

                        width = y_width +2;
                        height = y_height +2;
                        return new int[]{width, height};
                    }
                }

            }
        }
       return null;
    }


    public int[] solution(int brown, int yellow) {
        for (int width = 3; width <= 5000; width++) {
            for (int height = 3; height <= width; height++) {
                int boundary = (width + height -2) *2;
                int center = width * height - boundary;
                if (boundary == brown && yellow == center) {
                    return new int[]{width, height};
                }
            }
        }

        return null;
    }




}
