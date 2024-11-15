package day22;
/*
    - 기존코드 : 고정길이가 Board[] boardList = new Board[100];
    - 조건: 고정길이가 아닌 가변길이 형식으로 무한개 저장 가능한 배열 제작
    * 이유 : 가변 길이의 여러개의 데이터를 관리할 시
                - 컬렉션 프레임워크(ArrayList) = 실무
                - 가변 배열 = 시험/ 코테
 */

import java.util.Scanner;

public class BoardService4 {
    public static void main(String[] args) {

        // 입력 객체
        Scanner scan = new Scanner(System.in);
        // -Board 객체 100개 저장 가능한 배열 선언
        Board[] boardList = null; // 가변 배열
        // 현재 게시물의 수를 저장하는 변수
        int count = 0;

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

                // 입력받은 데이터로 게시물 객체 생성
                Board board = new Board(); // 게시물 객체 생성
                board.content = content; board.writer = writer; board.pwd = pwd;

                // 게시물 저장
                count++; // 게시물 수 1 증가
                Board[] newBoardList = new Board[count]; // 새로운 배열 생성

                // 기존 배열 내 게시물들을 새로운 배열에 옮기기 => 배열 복사
                if(count == 1) { // 만약 기존 배열내 게시물이 존재하면
                    for(int index= 0 ; index <= boardList.length-1; index++){
                        newBoardList[index] = boardList[index]; // 기존 배열 내 게시물들을 새로운 배열에 대입 => 카피·복사
                    }
                }
                // 새로운 배열 내 마지막 인덱스(배열명.length-1)에 입력받은 게시물 객체 등록
                newBoardList[count - 1] = board;
                // ** 새로운 배열을 기존 배열에 대입한다.
                boardList = newBoardList;

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
