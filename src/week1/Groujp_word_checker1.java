//package week1;
//
//import java.util.Scanner;
//
//public class Groujp_word_checker1 {
//    public static void main(String[] args) {
//        //첫번째 줄 입력은 100보다 작은 수 N입력(입력할 단어의 개수0
//
//        //그 다음 줄부터 N개의 줄단어가 들어옴
//
//        //알파벳은 소문자, 중복X지 않으면 단어 기이는 최대 100
//
//        int n;
//
//        do {
//            System.out.println("단어수는 100보다 작거나 같은 자연수 입니다.");
//            n = scanN();
//        } while ( n < 1 || n > 100);
//
//
//        for (int i = 0; i < n; i++) {
//
//            Scanner sc = new Scanner(System.in);
//            sc.nextLine();
//            String word = sc.nextLine();
//            word = word.toLowerCase();
//            if(word.length() >=
//            String[] splitWord = word.split("");
//
//
//
//
//
//
//        }
//
//
//
//
//
//
//    }
//
//    public static int scanN() {
//        //단어 수 스캔
//        Scanner scN = new Scanner(System.in);
//        scN.nextLine();
//       return scN.nextInt();
//    }
//
//    public boolean check() {
//        //알파벳 수 만큼(a~z까지, a)
//        boolean[] check = new boolean[26];
//        int prev = 0;
//
//        //글자 입력
//        String word = input();
//
//        for (int i = 0; i < word.length(); i++) {
//
//            int nowChar = word.charAt(i);
//
//            //앞의 문자와 혖재 문자가 같지 않으면
//            if (prev != nowChar) {
//                //현재 문자가 처음 나오는 경우
//                if (check[nowChar - 'a'] == false) {
//                    check[nowChar = 'a'] = true;
//                    prev = nowChar;
//                } else {
//                    //이미 나온적 있으면
//
//                    //그룹단어가 아님
//                    return false;
//                }
//            }
//
//        }
//
//        return true;
//    }
//}
