# CH3. 배열
*** 
## :pushpin: 배열
> ### 메모리 상에 원소를 연속하게 배치한 자료구조
### 시간복잡도 
- 원소를 끝에 추가 = O(1)
- 위치에 원소를 확인/변경 = O(1)
- 마지막 원소를 제거 = O(1)
- 임의의 위치에 원소를 추가/임의의 위치의 원소 제거 = O(N)

### 2차원 배열의 표현 및 원소 접근

- 2차원 배열을 표현할 때 x, y 좌표로 표현 하는 것이 편함
- arr[y][x]로 표현 **:exclamation: y가 행, x가 열임**
- 아래 arr1 배열을 아래 그림처럼 표현
```java
    int[][] arr1 = {
        {4, 9, 7},
        {2, 6, 1},
        {3, 4, 8},
        {8, 5, 9}
    };
```
![image](https://github.com/hee9841/algorithm/assets/70899677/20b37cab-4553-431a-bc19-9dc19865f0e3)

***
### 배열 함수
```java
    //배열 선언
    int[][] arr = new int[y][x];
    
    //배열의 길이
    int y = arr.length;
    int x = arr[0].length;
    
    //배열 -> ArrayList
    Arrays.asList(arr);
    
    //정렬
    Arrays.sort(arr);   //오름차순
    Arrays.sort(arr, Collections.reverseOrder());   //내림차순
```

***
> ### 참고 문서
> [취업과 이직을 위한 프로그래머스 코딩 테스트 문제 풀이 전략: 자바 편](https://product.kyobobook.co.kr/detail/S000200928002)