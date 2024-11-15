/*
    - 내용[String타입] 과 작성자[String타입] 과 비밀번호[int타입] 로 구성된 게시물 클래스를 설계
    - 게시물 객체 최대 100개 까지 저장하는 서비스 구축
      - 조건 : main함수 1개 와 배열은 최대1까지 사용 하여 구현
      - 구축 : 게시물 쓰기 와 게시물 출력 기능 구현

      클래스 : 멤버변수(필드), 생성자, 메소드(멤버변수)로 구현된 새로운 타입 만들기
        - 객체지향 프로그래밍에서 매우 중요한 문법

      객체 : 하나의 자료(여러개 자료들의 주소값)를 저장하는 메모리 공간(JVM 힙 영역에 저장)
        - 물리적/ 논리적으로 정의(특성, 행위)가 가능한 형태물 [예] 의자, 안경, 책, 강의(논리)

      변수 : 하나의 자료(실제 값, 주소값)를 저장하는 메모리 공간(JVM 스택 영역에 저장)
            => 기본/참조 타입으로 생성된 메모리 공간

      타입: 데이터 형태 분류
        대분류: --> 기본값 : null
            기본 타입 : byte, int, short, long, float, double, char, boolean => 8개 => 기본값: 정수:0, 실수:0.0, 논리:flase
            참조 타입 : 배열, 클래스, 인터페이스, 열거타입


 */

package day22;

import java.util.Scanner;

public class BoradService3 { /* 실행 클래스 */
    public static void main(String[] args) {

        // 입력 객체
        Scanner scan = new Scanner(System.in);
        // -Board 객체 100개 저장 가능한 배열 선언
        Board[] boardList = new Board[100]; // Board 객체 100개 저장할 수 있는 배열 선언(고정길이)

        while(true) {
            System.out.println("1. 글쓰기 2. 글 출력 : ");
            int choose = scan.nextInt();
            if(choose == 1){
                // 사용자로부터 저장할 데이터 입력 받음
                scan.nextLine(); // 의미 없는 nextLine() 코드 작성
                System.out.println("내용 : "); String content = scan.nextLine();
                // .next() 문자열 입력, .nextLine() 문자열(공백/띄어쓰기 포함) 입력
                // .nextLine() 사용시 주의 : .nextLine() 앞에 또 다른 .next-()이 존재하면 아무 의미 없는 next 라인을 넣으면 된다.
                System.out.println("작성자 : "); String writer = scan.nextLine();
                System.out.println("비밀번호 : "); int pwd = scan.nextInt();

                // 배열 내 빈 공간을 찾아서 게시물 작성하기
                for(int index = 0; index <= boardList.length-1; index++){
                    if(boardList[index] == null){ // 만약 index 번째 게시물이 비어있으면

                        Board board = new Board(); // 게시물 객체 생성
                        // 생성된 게시물 객체내 입력받은 값들을 대입
                        board.content = content; board.writer = writer; board.pwd = pwd;
                        // 배열 내 index번째 위치에 생성한 객체를 저장/대입한다.
                        boardList[index] = board;
                        break; // 반복문 종료
                    }
                }
            }
            else if(choose == 2){
                // 배열내 존재하는 모든 게시물 출력
                for (int index = 0; index <= boardList.length-1; index++){
                    if(boardList[index] != null){// 게시물이 존재하면
                        System.out.printf("작성자: %s, 내용 : %s \n", boardList[index].writer, boardList[index].content);
                    }
                } // for end

            } //else if end

        } // while end
    }

}
