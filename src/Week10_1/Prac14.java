package Week10_1;

import java.io.*;
import java.util.*;

// 1. 출력 함수 만들어야함
// 2. 입력받으면 그에 대한 1번 함수를 이용하도록
public class Prac14 {
    private File curDir = null;
    private File sub[] = null;

    // curDir을 설정하도록
    public void setCurDir(String name) {
        curDir = new File(name);
    }
    
    // 현재 디렉토리의 서브 디렉토리들을 출력함
    public void showSubDir() {
        System.out.println("\t[" + curDir.getPath() + "]");
        sub = curDir.listFiles();
        for (File temp : sub) {
            if ((temp.isFile()))
                System.out.print("file");
            else
                System.out.print("dir ");

            System.out.printf("%-15s", "\t\t" + temp.length() + "바이트");
            System.out.println("\t\t" + temp.getName());
        }
    }

    public void start() {
        System.out.println("***** 파일 탐색기입니다. *****");
        showSubDir();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(">>");
            String command = sc.nextLine(); // 한 라인을 읽고 앞뒤에 입력한 빈칸 지우기

            if (command.equals("그만"))
                break;
            if (command.equals("..")) {
                String temp = curDir.getParent();
                if (temp == null)
                    continue;
                else {
                    curDir = new File(curDir.getParent());
                    showSubDir();
                }
            }
            else {
                if (new File(curDir, command).isDirectory()) {
                    curDir = new File(curDir, command);
                    showSubDir();
                }
                else {
                    System.out.println("디렉토리가 아닙니다.");
                }
            }
        }
    }

    public static void main(String[] args) {
        Prac14 run = new Prac14();

        run.setCurDir("C:\\");
        run.start();
    }
}
