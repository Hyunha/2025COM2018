# [COM2018] 2025년도 가을학기 객체지향 프로그래밍
## 한양대학교 ERICA 소프트웨어융합대학 컴퓨터학부

### 실습1 : 두근거리는 공

지난 실습 때 만든 크기와 색상이 변하는 공을 다음과 같이 개선해봅시다.

- 프로그램이 시작하면 `OK` 버튼과 별개로 계속 크기가 자동으로 바뀌도록 수정하세요.
- 입력받은 시간 값마다 크기만 자동으로 바뀝니다. 
- `OK` 버튼을 누르면 색상을 바꿉니다. (빨간색일 때 누르면 파란색으로, 파란색일 때 누르면 빨간색으로 변경)

제공한 코드는 지난 실습 코드 **TO-BE** 버전에 `ThrobController` 를 더한 버전입니다.
아래는 클래스 다이어그램과 메소드 설명을 참고하여 코드를 완성해보세요. 

<img src="img/lab01_cd.png" width="750">

클래스 별 주요 메소드 힌트

- `ThrobbingBall`
  - `flipColor()` : 공의 색상을 변경합니다. 현재 색상이 빨간색이라면 파란색으로, 파란색이라면 빨간색으로 변경합니다.
  - `getColor()` : 공의 현재 색상을 리턴합니다.
- `ThrobController`
  - `run()` : 무한 루프입니다. 공의 크기를 변경하고 그림을 다시 그린 후, `delay` 메소드를 호출해서 잠시동안 멈춥니다.
  - `delay()` : 정해진 시간(`time` 밀리초)만큼 쉽니다.
- `ThrobPanel`
  - `update()` : 상황을 **갱신**합니다.
- `ColorButton`
  - `actionPerformed(ActionEvent e)` : 버튼을 누를 때마다 공의 색상을 바꿉니다. (`view.update()` 호출)


`ThrobController` 작성을 위해 아래 코드를 참고해보세요.

```Java
public class LoopSample {
    static void main() {
        LoopSample s = new LoopSample();
        System.out.println("Let's start game...");
        System.out.println("3");
        s.delay(1000);
        System.out.println("2");
        s.delay(1000);
        System.out.println("1");
        s.delay(1000);
        System.out.println("start!");
        boolean b = true;
        while (true) {
            s.delay(330);
            if (b) {
                System.out.println("Even");
            } else {
                System.out.println("Odd");
            }
            b = !b;
        }
    }

    private void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {}
    }
}
```
### 실습2 : 카운터 버튼

지난 수업때 `OK` 버튼을 누를 때마다 가운데 `Drawing` 패널에 공을 그리는 `Counter` 를 완성했습니다.
하지만 메뉴 바에서 색상을 변경했을 때, 기존에 그린 공의 색상을 무시하고 전부 현재 색상 기준으로 다시 그리고 있습니다.

아래 그림의 **TO-BE**와 같이 기존 공의 색상을 유지할 수 있도록 코드를 수정해보세요.

<img src="img/lab02.png" width="750">

힌트
- `Color` 배열을 준비합니다.
- `OK` 버튼을 누를 때마다 현재 공의 색상을 위 배열에 넣습니다.
- `Drawing` 에서 공을 그릴 때, `Color` 배열의 색상을 사용합니다.
- `Color` 배열이 어느 위치에 들어가야 할지 고민해보세요.