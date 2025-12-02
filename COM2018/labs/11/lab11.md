# [COM2018] 2025년도 가을학기 객체지향 프로그래밍
## 한양대학교 ERICA 소프트웨어융합대학 컴퓨터학부

### 실습 : 급여 정산 프로그램 개선

지난 이론 시간에 배운 급여 정산 프로그램(Payroll)을 다음과 같이 개선해봅시다. 

- 기능 1 : 새 직원을 등록하는 기능
- 기능 2 : 업무시간을 추가하는 기능

다음 클래스 다이어그램을 참고하세요.

<img src="img/lab11cd.png" width="750">

- 편의를 위해 입출력 파일의 이름은 고정 파일이름(`payroll.csv`, `payroll.out.csv`)으로 사용하도록 수정하였습니다.
- `DialogReader`는 `static` 메소드로 바꿔서 추가했습니다. `DialogReader.readInt(prompt)` 와 같이 사용할 수 있습니다.

`PayrollController`의 추가 사항

- 필드 변수
  - `String[] names` : `PayrollReader` 로 읽은 직원 이름의 배열
  - `int[] hours` : `PayrollReader` 로 읽은 근무시간의 배열
  - `int[] payrates` : `PayrollReader` 로 읽은 시급의 배열
  - `final int MAX_NUM` : 최대 직원 수 (`100` 으로 고정)

- 메소드
  - `loadData(String in)` : 입력받은 파일이름 `in`에서 직원의 이름, 근무시간, 시급을 각각 필드변수 `names`, `hours`, `payrates` 에 추가합니다. 실행되었을때 `reset()` 메소드를 호출해서 세 배열을 초기화 한 후 동작해야 하며 리턴 값은 직원의 수 입니다.
  - `reset()` : `names`, `hours`, `payrates` 를 `MAX_NUM` 크기의 배열로 초기화 합니다.
  - `processAddEmployee(String in)` : 사용자 이름과 시급을 입력받아서 새 사용자를 추가합니다.
    - 만약 직원 수가 최대 한계(`MAX_NUM`)에 도달한 경우, 더이상 추가가 불가능하다고 메시지를 띄우고, 추가 작업은 진행하지 않아야 합니다.
    - 만약 입력받은 새 직원의 이름이 기존에 존재할 경우, 이미 등록된 직원이라고 메시지를 띄우고, 추가 작업은 진행하지 않아야 합니다.
    - 그 외 정상적인 경우에는 입력 파일 (`in` = `payroll.csv`) 을 `PayrollWriter`를 활용해서 갱신해야 합니다. 
  - `processAddWorkHour(String in)` : 사용자 이름과 근무시간을 입력받아서 기존 사용자의 근무 시간을 추가합니다.
    - 업무 시간은 0 이상의 정수를 입력할 때까지 반복해서 입력받아야 합니다.
    - 만약 사용자 이름이 존재하지 않는 직원의 이름이라면 적절한 오류 메시지를 보여줘야 합니다.
    - 존재하는 직원이라면, 해당 직원의 근무시간을 추가하고 입력 파일 (`in` = `payroll.csv`) 을 `PayrollWriter`를 활용해서 갱신해야 합니다.

#### 실행 시나리오 예시

<img src="img/scenario.png" width="800">

#### 안전한 입력 받기 패턴

아래 코드는 사용자 입력을 원하는 값이 되도록 반복하는 예시입니다. 다음에 활용해보세요.
 - `PayrollController` 의 업무번호 입력 (1~3 중 하나)
 - `processAddWorkHour`의 업무시간 입력 (0 이상) 

```Java
import labs.lab11.payroll.view.DialogReader;

public class SafeInputTest {
    static void main() {
        String input = DialogReader.readString("a or b ?");

        // target condition : "a".equals(input) || "b".equals(input)
        while (!("a".equals(input) || "b".equals(input))) {
            // loop invariant : !("a".equals(input) || "b".equals(input))
            input = DialogReader.readString("a or b ?");
        }

        System.out.println("your choice is : " + input);
    }
}
```
