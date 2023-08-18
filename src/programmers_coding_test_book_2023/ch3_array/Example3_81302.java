package programmers_coding_test_book_2023.ch3_array;

/**
 * packageName    : main.book.ch3_array
 * fileName       : Example3
 * author         : asdfz
 * date           : 2023-08-07
 * description    : 거리두기 확인하기
 *                  https://school.programmers.co.kr/learn/courses/30/lessons/81302
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-07        asdfz       최초 생성
 */
public class Example3_81302 {

    private static final int dx[] = {0, -1, 1, 0};
    private static final int dy[] = {-1, 0, 0, 1};



    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }

            //거리두기 검사 후 기록
            if (isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }

        }


        return answer;
    }

    private boolean isDistanced(char[][] room, int x, int y) {
        //거리두기 검사

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
                continue;
            }

            switch (room[ny][nx]) {
                case 'P':
                    return false;
                case 'O':
                    if (isNestToVolunteer(room, nx, ny, 3 - d)) {
                        return false;
                    }
                    break;
            }

        }

        return true;
    }

    private boolean isDistanced(char[][] room) {
        //거리두기 검사 (대기실 전체)
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') {
                    continue;
                }
                if (!isDistanced(room, x, y)) return false;
            }
        }

        return true;
    }

    private boolean isNestToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) {
                continue;
            }

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
                continue;
            }

            if (room[ny][nx] == 'P') return true;
        }

        return false;
    }

}

