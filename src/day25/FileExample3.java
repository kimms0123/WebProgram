package day25;

import java.io.*;
import java.util.Scanner;

public class FileExample3 {
    public static void main(String[] args) {
        // 생각해보기
        try {
            // 1. 파일 입력 키보드로부터 입력받은 문자열을 'day25' 폴더 내 test2.txt에 저장
            // [1] 입력 객체
            Scanner scan = new Scanner(System.in);
            // [2] 키보드 입력
            System.out.print("파일에 저장할 내용: ");
            String outStr = scan.next();
            // [3] 파일 출력 객체 생성, 파일 경로 저장
            FileOutputStream outputStream = new FileOutputStream("./src/day25/test2.txt");
            // [4] 파일 출력 객체를 이용한 문자열 출력
            outputStream.write(outStr.getBytes());
            // .write("문자열".getBytes()
            System.out.println("[ 저장 성공 ]");

            // 2. 파일 출력 'day25' 폴더 내 test2.txt에 저장된 문자열 바이트를 읽어 콘솔에 출력
            // [1] 파일 입력 객체 생성, 위에서 생성된 메모장 읽어오기
            FileInputStream inputStream = new FileInputStream("./src/day25/test2.txt");

            // [2] 읽어온 바이트를 저장할 바이트 배열 선언
            // byte[] bytes = new byte[1000]; // 1000개의 바이트(영문 1글자당 1바이트, 한글 1글자당 2바이트)를 저장할 수 있는 배열
            // 현재 읽어올 파일의 용량을 몰라 임의 1000개 생성

            // [2-2] 읽어올 파일을 용량/바이트 개수를 확인 후 파일의 용량만큼 배열 선언
            File file = new File("./src/day25/test.txt");
            System.out.println(file.isFile()); // true
            System.out.println(file.getName()); // test2.txt
            System.out.println(file.length()); // 반환타입 long
            byte[] bytes = new byte[(int) file.length()];
            // (캐스팅): 강제 타입 변환, long 타입을 int 타입으로 변환
            // 배열 내 [ ] 안에 들어가는 배열 크기는 타입이 정수(int)만 가능

            // [3] 준비된 바이트 배열에 읽어온 바이트를 저장
            inputStream.read(bytes);
            // [4] 바이트를 문자열로 다시 변환
            String inStr = new String(bytes);
            System.out.println("[ 불러오기 성공! ]");
            System.out.println(inStr);

            // !: 만약 파일 객체가 지정한 경로에 파일이 존재 x시 예외 발생
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        }
        // !: 만약 파일 객체가 입/출력 중일때 외부적인 요소로 문제가 발생하면 예외 발생
        catch (IOException e ) {
            e.printStackTrace();
        }
    }
}
