package day24;

import java.util.Scanner;

class User{
    String id;
    String pwd;
}

class Board {
    String content;
    String writer;
    int pwd;
}

public class BoardService {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        User[] userList = new User[1000];
        Board[] boardList = new Board[100];

        while (true){
            System.out.print("1. 회원가입 \n 2. 로그인\n3. 게시물 입력\n4.게시물 출력 ");
            int choose = scan.nextInt();

            // 회원 가입
            if(choose == 1){
                System.out.print("아이디를 입력하세요: ");
                String id = scan.nextLine();

                // 중복 검사
                boolean isDuplication = false;
                for (User user : userList) {
                    if(user != null && user.id.equals(id)) {
                        isDuplication = true;
                        break;
                    }
                }
                if (isDuplication){
                    System.out.println("회원가입 실패!(중복된 아이디)");
                    continue;
                }
                System.out.print("비밀번호를 입력하세요: ");
                String pw = scan.nextLine();

                // 회원 저장
                boolean isRegistered = false;
                for (int index = 0; index <= userList.length -1; index++){
                    if (userList[index] == null){
                        User user = new User();
                        user.id = id;
                        user.pwd = pw;
                        userList[index] = user;
                        System.out.println("회원가입 성공!");
                        isRegistered = true;
                        break;
                    }
                }
                if (!isRegistered) {
                    System.out.println("회원가입 실패(회원 목록 한계)");
                }
            }
            //로그인
            else if (choose == 2) {
                System.out.print("아이디 입력: ");
                String id = scan.nextLine();
                System.out.print("비밀번호 입력: ");
                String pw = scan.nextLine();

                boolean loginSuccess = false;
                for (User user : userList) {
                    if (user != null && user.id.equals(id) && user.pwd.equals(pw)) {
                        System.out.println("로그인 성공");
                        loginSuccess = true;
                        break;
                    }
                }
                if (!loginSuccess) {
                    System.out.println("로그인 실패(아이디 혹은 비번 오류");
                }
            }
            // 게시물 작성
            else if (choose == 3) {
                System.out.print("내용 입력 : ");
                String content = scan.nextLine();
                System.out.print("작성자 입력: ");
                String writer = scan.nextLine();
                System.out.print("게시 비번 입력: ");
                int pwd = scan.nextInt();
                scan.nextLine(); // 버퍼 비움

                boolean isWrite = false;
                for (int index = 0; index <= boardList.length - 1; index++) {
                    if (boardList[index] == null) {
                        Board board = new Board();
                        board.content = content;
                        board.writer = writer;
                        board.pwd = pwd;
                        boardList[index] = board;
                        System.out.println("게시물이 등록되었습니다");
                        isWrite = true;
                        break;
                    }
                }
                if (!isWrite) {
                    System.out.println("게시물 등록 실패(저장공간 부족)");
                }
            }
            // 게시물 출력
            else if (choose == 4) {
                System.out.println("게시물 목록: ");
                for (Board board : boardList) {
                    if (board != null) {
                        System.out.printf("내용: %s, 작성자: %s", board.content, board.writer);
                    }
                }
            }
            else {
                System.out.println("잘못된 입력");
            }
        }
    }
}
