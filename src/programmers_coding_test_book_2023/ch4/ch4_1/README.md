# Ch4-1. 문자열이란?
*** 
## 문자열이란?
> ### ***문자의 배열***, 여러개의 문자가 배열을 이룬 것
## 문자열 내 문자를 가져오는 방법
- ***String.chartAt(int idx)***
  - 하나의 문자를 쉽게 가져올 수 있지만, 매서드 호출에 따른 오버헤드가 있음
  - 특정 몇개의 문자만 필요할 시 사용
- ***String.toCharArray()***
  - 모든 문자를 char[]형식으로 한번에 가져올 수 있지만, 문자열 길에 해당하는 메모리를 사용
  - 문자열의 모든 문자 정보가 필요할 때 사용

## 아스키 코드

- 문자는 내부저그로 정수 취급되고 연산됨
- 아스키 코드를 이용하여 문자를 정수로, 정수를 문자로 바꾸는 작업을함
- 문자열과 관련된 내장 라이블러를 이용하여 바꾸기도 함

## 숫자를 표현하는 문자의 아스키 코드
- 문자열 '0'은 48임
```java
    //아스키 코드를 이용한 수자를 표현하는 문자열 -> 숫자 
    //숫자를 표현하는 문자에서 '0'의 아스키 코드르 ㄹ빼면 해당 문자가 표현하는 정수 값이 나옴
    //예를 들어 '5'의 정수 값을 구하기 위해서 '5' - '0' = 53 - 48 = 5
    char digit = '9';
    int digitToInt = digit - '0';
    
    //내장라이브러리 사용
    //Character.getNumericValue()
    char digit = '9';
    int digitToInt = Character.getNumericValue(digitL);
```
## 대소문자를 아스키 코드
- 'A'는 65, 'a'는 97를 나타냄
- 소문자 대문자 차이는 'a' - 'A'임
```java
    //소문자 -> 대문자로 표현
    //소문자와 대문자 사이에는 'a' - 'A'만크의 차이가 있음
    char lower = 'e';
    char upper = (char) (lower - ('a' - 'A')); //char끼리 연산 하면 int형으로 변환되어 다시 형면환해야됨
    System.out.println("upper = " + upper); //E
    //내장라이브러리 사용
    char lower = 'e';
    char upper = Character.toUpperCase(lower);
    System.out.println("upper = " + lower);
    
    

    //대문자 -> 소문자
    char upper = 'G';
    char lower = (char) (upper1 + ('a' - 'A'));
    System.out.println("lower1 = " + lower1);
    //내장라이브러리 사용
    char upper = 'G';
    char lower = Character.toLowerCase(upper);
```

## StringBuilder
- 문자열을 효율적으로 구성할 수 있음
- 문자열을 반복문으로 더하고 뺄 때 사용
- 반복문에서 단순히 (ex. s += "i") 문자열을 더하고 빼는경우보다 효율적
- **단순히 문자열을 더하는 경우**
  - 매 반복마다 새로문 문자열 개체가 생성되고 새로운 문자 배열을 복사하게 됨
  - 배열을 복사하는데 배열의 모든 원소를 참조해야함
  - 문자열은 내부적으로 배열을 사용하여 길이가 N인 새로운 문자열을 만드는데 O(N)이 소요됨
  - 이 과정이 문자열의 길이를 하나씩 늘어가면서 반복되어서 아래와 같은 시간 복잡도가 소요
    - (길이 1인 문자열 만드는 시간) + (길이 2인 문자열 만드는 시간) + .... + (길이 N인 문자열을 만드는 시간) = $$O(N^2)$$
- **StringBuilder를 사용하는 경우**
  - 문자를 이어 붙을이거나 뺄 때 내부 배열에서 직접 수정
  - 이 때 기대 시간 복잡도는 $$O(1)$$
### StrinBuilder 에서 자주 사용하는 메서드
| 메서드                          | 역활                  | 시간복잡도    |
|:-----------------------------|:--------------------|----------|
| StringBuilder.toString()     | 문자열을 String 형식으로 반환 | &&O(N)&& |
| StringBuilder.append(char c) | 문자 c를 문자열 끝에 이어 붙임  | &&O(1)&& |
| StringBuilder.length()       | 문자열의 길이 반환          | &&O(1)&& |
| StringBuilder.reverse()      | 문자열 뒤집는다.           | &&O(1)&& |
### 'a'부터 'z'까지 이어붙이는 예제
```java
    StringBuilder azBuilder = new StringBuilder();
    for (char c = 'a'; c <= 'z'; c++) {
        azBuilder.append(c);
    }
    String az = azBuilder.toString();
    System.out.println("az = " + az);
```
***
## 관련 함수
```java
    //char 관련 함수
    Character.isAlphabetic(char c);     //알파벳 확인 함수
```

***
> ### 참고 문서
> [취업과 이직을 위한 프로그래머스 코딩 테스트 문제 풀이 전략: 자바 편](https://product.kyobobook.co.kr/detail/S000200928002)