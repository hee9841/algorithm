# Ch6. 완전탐색
*** 
## 1. 완전탐색이란?
> ### 제시하는 조건을 만족하는 모든 경우를 확인하여 정담을 찾는 탐색
> - 정확성 높음
> - 시간 복잡도 필수 확인
### 1-1. 상태와 상태 전이 
- 상태 전이를 통해 탐색을 진행
- 상태  $$\supset$$ 변수(진행 상태를 표현하는)
- 상태 전이 : 하나이 상태를 이용해 다음 상태를 만들어 나감
>  ex) 원점에서 특정좌표에 도달하는 방법
> - 상태 변수 : x,y 좌표 ➡ 탐색중에 상태가 변하므로
### 1-2. 완전 탐색의 종류
조건에 따라 구현하는 방법이 달라짐
- **간단히 구현 되는 완전 탐색**
    - 간단한 탐색
    - 중첩 for문 정도로 구현 가능
- **깊이 우선 탐색**
  - 깊이 우선 탐색(DFS, 12장 참고)은 5장의 재구로 구현
  <p><img src="https://github.com/hee9841/algorithm/assets/70899677/27e17428-0070-4dfc-af37-5f310949b476" width="200" height="200"/></p>
- **너비 우선 탐색**
  - BFS로 12장 참고
  - 큐(queue)를 이요하여 구현
  - 하나의 상태에서 전이되는 다음 단계의 상태들을 방문한 후 그다음 단계 상태들을 방문
  <p><img src="https://github.com/hee9841/algorithm/assets/70899677/0f215428-62cc-4e51-ba69-a00734b24ce9" width="200" height="200"/></p>

### 1-3. 방문 처리
- 완전 탐색은 모든 경우의 수를 탐색하는 방법임
- 따라서 시간 복잡도를 따져야함
- 시간 복잡도는 탐색해야할 탐색의 개수(탐색 공간의 크기)에 비례
  - 탐색 공난 크기를 이용햐여 시간 복잡도를 계산할 경우
  - 방문한 상태를 재방문하면 안됨
  - 즉 중복 방문을 해결하기 위해서는 방문처리 필요
  - 보통 간단한 탐색에서는 중복이 발생하지 않을 경우가 많지만, DFS, BFS에서는 필요


***
> ### 참고 문서
> [취업과 이직을 위한 프로그래머스 코딩 테스트 문제 풀이 전략: 자바 편](https://product.kyobobook.co.kr/detail/S000200928002)