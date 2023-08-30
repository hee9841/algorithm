# Ch4_2_1. 문자열 다루기 (내장 라이브러리)
*** 
## 문자열 응용하기
### 문자열 메서드
| 메서드                                     | return 타입 | 내용                               |
|:----------------------------------------|:----------|:---------------------------------|
| equals(String other)                    | boolean   | 문자열이 other과 같은지                  |
| length()                                | int       | 문자열 길이 반환                        |
| substring(int beginIndex, int endIndex) | String    | beginIndex 부터 endIndex 까지 잘라서 반환 |
| toUpperCase() / toLowerCase()           | String    | 대/소문자 변환                         |
***
# Ch4_2_2. 진법 바꾸기
## 문자열과 정수를 변환하는 메서드
- 아래 메서드들은모두 10진수 기준

| 메서드                        | return 타입 | 내용             |
|:---------------------------|:----------|:---------------|
| Integer.parseInt(String s) | int       | String -> int  |
| Integer.toString(int v)    | String    | int -> String  |
| Loong.parseLong(String s)  | long      | String -> long |
| Long.toString(long v)      | String    | long -> String      |   

## 문자열과 정수를 진법에 따라 변환하는 메서드
| 메서드                                   | return 타입 | 내용                                        |
|:--------------------------------------|:----------|:------------------------------------------|
| Integer.parseInt(String s, int radix) | int       | radix진법의로 표현된 String -> int(10진수)로 변환     |
| Integer.toString(int v, int radix)               | String    | int(10진수) -> String(radix진법으로 표현된) 으로 변환  |
| Loong.parseLong(String s, int radix)             | long      | radix진법의로 표현된 String -> long(10진수)로 변환    |
| Long.toString(long v, int radix)                 | String    | long(10진수) -> String(radix진법으로 표현된) 으로 변환 |   

```java
    String binary = "1010";
    int value = Integer.parseInt(binary, 2);    // value는 10
    String hex = Integer.toString(value, 16);   // hex는 a
    hex = hex.toUpperCase();        //  hex는 A
```
***
# Ch4_2_3. 찾기와 바꾸기
## 포함 여부를 검사하는 메서드
| 메서드                               | return 타입 | 내용                                |
|:----------------------------------|:----------|:----------------------------------|
| contains(charSequence s)          | boolean   | 전달받은 문자열이 원본 문자열에 있는지 검사          |
| startsWith(String prefix)         | boolean   | 원본 문자열이 전달받은 문자열로 시작하는지 검사        |
| endsWith(String suffix)           | boolean   | 원본 문자열이 전달받은 문자열로 끝나는지 검사         |
| indexOf(String str)               | int       | 전달받은 문자열이 원본 문자열에서 몇번째 인덱스에 있는지   | 
| indexOf(String str, int startIdx) | int       | str이 startIdx 이후에 몇번째 인덱스에 있는지 반환 |   


## 문자열 치환 메서드
| 메서드                                                    | return 타입 | 내용                             |
|:-------------------------------------------------------|:----------|:-------------------------------|
| replace(char old, char new)                            | String    | old의 문자들을 new의 문자들로 치환         |
| replace(charSequence target, charSequence replacement) | boolean   | target문자열을  replacement문자열로 치환 |


***
# Ch4_2_4. 정규표현식
## 자주사용하는 정규 표현식
| 정규표현식      | 내용                                                                    | 예시                                                                                                             |
|:-----------|:----------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------|
| .          | 개행 문자를 제외한 아무 문자                                                      | a.b -> a + 모든문자 + b -> ex) affffb                                                                              |
| [abc]      | a,b,c 중 아무거나                                                          | [ae] -> **a**bc, **a**fter, **e**nd...                                                                         |
| [^abc]     | a,b,c 를 제외하고                                                          | [ae] -> before, cnd,...                                                                                        |
| [a-z]      | a,z 사이의 모든 문자들                                                        | [1-9][0-9] -> 10, 11, 12, ...99<br/> [a-z][A-Z] -> aA, aB,...                                                  |
| a*         | a 0개 이상                                                               | 1[0-9]* -> 1, 10, 164, 1810, ....<br/> ca*t -> ct, cat, caat, caaaaat, caaaa....t                              |
| a+         | a 1개 이상                                                               | 1[0-9]+ -> 10, 164, 1810, ....<br/> ca+t ->  cat, caat, caaaaat, caaaa....t                                    |
| a?         | a 0개 또는 1개                                                            | 1[0-9]? -> 1, 11, 10, 15, 19, ....<br/> ca?t -> ct, cat                                                        |
| a{n}       | a n개                                                                  | 1[a-z]{3} -> 1abc, 1ddd, 1acc, 1fex, 1ecv, ....<br/> ca{3}t -> caaat                                           |
| a{n,}      | a 가 적어도 n번 나옴                                                         | 1[a-z]{3,} -> 1aaa, 1dddff, 1accdec, 1fex, 1ecv, ....<br/> ca{3,}t -> caaat, caaaat                            |
| a{n,m}     | a n 이상 m 이하                                                           | 1[a-z]{2,3} -> 1aa, 1ddd, 1abc, 1fe, 1ecv, ....<br/> ca{2,3}t -> caat, caaat                                   |
| a{n,m}     | a n 이상 m 이하                                                           | 1[a-z]{2,3} -> 1aa, 1ddd, 1abc, 1fe, 1ecv, ....<br/> ca{2,3}t -> caat, caaat                                   |
| ab&#124;cd | ab 또는 cd                                                              | 일&#124;하나&#124;한 -> 일, 하나, 한                                                                                   |
| ^a         | 문자열 처음 문자가 a                                                          |                                                                                                                |
| a$         | 문자열 마지막 문자가 a                                                         |                                                                                                                |
| \          | 확장문자, <br/>역슬래시 다음에 일반 문자가 오면 특수 문자 취금<br/>역슬레시 다음 특수문자 오면 그문자 자체로 취급 | \d -> [0-9]<br/>/.&nbsp;&nbsp;&nbsp;->&nbsp;&nbsp; .<br/>/+&nbsp;&nbsp;&nbsp;-> &nbsp;+                                                |

## String 클래스의 정규표현식과 관련된 메서드
| 메서드                                          | return 타입 | 내용                                 |
|:---------------------------------------------|:----------|:-----------------------------------|
| replaceAll(String regex, String replacement) | String    | regex와 매칭되는 패턴을 모두 replacement로 치환 |
| matches(String regex)                        | boolean   | 문자열이 regex표현식에 매칭되는지 여부를 반환        |
| split(String regex)                          | String[]  | 문자열을 regex에 매칭 되는 패턴 기준으로 잘라서 반환   |


***
> ### 참고 문서
> [취업과 이직을 위한 프로그래머스 코딩 테스트 문제 풀이 전략: 자바 편](https://product.kyobobook.co.kr/detail/S000200928002)