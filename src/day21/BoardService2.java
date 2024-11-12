/*
        BoardService1
            - 내용과 작성자로 구성된 게시물 최대 100개 저장 가능
            - 제약 : main 1개와 변수 6개와 반복문 사용
            - 구축 : 게시물 쓰기와 게시물 출력 기능 구현
*/
package day21;

import java.util.Scanner;

public class BoardService2 { // class start
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // BoardService1 에서 변수를 사용했는데 배열 변수를 사용하는 이유
            // - 여러개의 변수에 있는 데이터를 배열로 사용하면 관리가 편하기 때문

        // 배열 : 여러개의 동일한 타입의 데이터들을 **하나의 변수**에 저장할 수 있는 (참조)타입
            // - 음료냉장고 [배열], - 사이다, 콜라
        // 인덱스 : 배열에 저장된 데이터들의 저장 순서 번호, 0 ~ 최대 길이
            // 반복문 활용 : 시작 값~끝 값 반복

        String[] content = new String[100]; // 배열 선언 방법: 타입 [] 변수명 = new 타입 [개수]
        String[] writer = new String[100]; // String 데이터 100개를 저장할 수 있는 배열 선언

        while(true){
            System.out.print("1. 게시물 입력 2. 게시물 출력 :");
            int choose = scan.nextInt();
            if (choose == 1){
                System.out.print("새로운 게시물 제목: "); String cont = scan.next();
                System.out.print("새로운 게시물 작성자: "); String write = scan.next();

                // 만약 게시물이 비어있을 시, 게시물이 100개면 if 100개 x
                // 인덱스 0 ~ 마지막 인덱스 99까지 1씩 증가
                    // - 스위치 변수 => 상태를 저장하는 변수
                boolean save = false; // 처음에 false 하여 저장 실패 했다는 뜻

                for(int index = 0; index <= content.length-1; index++){
                    if(content[index] == null){ // 만약 index번재 게시물 비어있으면
                        content[index] = cont; writer[index] = write; // 비어있는 게시물 입력받은 내용물 저장
                        break; // 만약 저장을 했을 시 1개만 저장해야 하므로 break 해서 반복문 종료
                    } // if end
                } // for end
                // =for 종료 후
                if (save){
                    System.out.println("게시물 입력 성공!");}
                else {
                    System.out.println("비어있는 자리가 없습니다!");}
            }
            if (choose == 2){
                for(int index = 0; index <= content.length-1; index++){ // 0~99
                    if(content[index] != null){ // index 번째 게시물이 존재할 시
                        System.out.printf("작성자: %s, 내용 : %s \n", writer[index], content[index]);
                    } // if end
                } // for end

            } // if end

        }// while end

    } // main end

}// class end
