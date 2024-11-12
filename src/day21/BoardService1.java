/*
        BoardService1
            - 내용과 작성자로 구성된 게시물 3개까지 저장하는 서비스 구축
            - 제약 : main 1개와 변수 6개와 반복문 사용
            - 구축 : 게시물 쓰기와 게시물 출력 기능 구현
*/

package day21;

import java.util.Scanner;

public class BoardService1 {

    public static void main(String[] args) { // main start / 변역된 코드를 실행하는 기능 (main 스레드) 포함

        //입력 객체
        Scanner scan = new Scanner(System.in); // 입력 객체

        // 저장소 설계, 게시물 1개당 내용물 + 작성자 (내용 2개) => 게시물 3개면 내용 6개
            // 변수 : 하나의 데이터(주소값)을 저장하는 공간(메모리)
            // 타입 : 변수의 저장된 데이터(주소)의 타입, 데이터 분류, 기본타입(7 : int~double) VS 참조타입(클래스, 인터페이스, 배열

        String content1  = null; String writer1 = null; // 첫 게시물 내용
        String content2 = null; String writer2 = null; // 두번째 게시물 내용
        String content3 = null; String writer3 = null; // 세번째 게시물 내용

        // if : 다중 if는 다중 조건의 다중 결과 충족 가능
        // if- else: 다중 조건의 무조건 1개의 결과 충족

        while(true) { // 무한루프
            System.out.println("1. 게시물 쓰기 2. 게시물 출력 선택:"); // 출력
            int choose = scan.nextInt(); // 입력
            if(choose == 1) { // 입력 값이 1일 때 게시물 입력 구현
                // 게시물 저장할 내용 입력 받기
                System.out.print("새로운 게시물 내용:"); String content = scan.next();
                System.out.print("새로운 게시물 작성자:"); String writer = scan.next();

                // 게시물을 작성할 공간이 있는지 확인, 임의로 게시물이 존재하지 않는 뜻 부여(null(선호) 또는 "")
                if(content1 == null) { // 비어있으면
                    // 입력받은 값들을첫번째 게시물 변수에 저장
                    content1 = content; writer1= writer; // 입력받은 값들을 첫번째 게시물 변수에 저장
                } else if(content2 == null) {
                    content2 = content; writer2 = writer;
                } else if(content3 == null) {
                    content3 = content; writer3 = writer;
                } else {
                    System.out.println("게시물 쓰기 실패: 빈 공간이 없습니다!");
                }
            } else if(choose == 2){ // 입력 값이 2일 때 게시물 출력 구현

                if(content1 != null){// 첫 게시물이 존재하면
                    System.out.printf("작성자 : %s, 내용 : %s", writer1, content1);
            }
                if(content2 != null){// 첫 게시물이 존재하면
                    System.out.printf("작성자 : %s, 내용 : %s", writer2, content2);
                }
                if(content3 != null){// 첫 게시물이 존재하면
                    System.out.printf("작성자 : %s, 내용 : %s", writer3, content3);
                }
        }

    }// main end
} // class end
