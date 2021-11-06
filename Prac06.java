package Week10_1;

import java.io.*;
import java.util.*;

public class Prac06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileWriter fout = null;
        FileReader fr1 = null, fr2 = null;

        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
        System.out.print("첫번째 파일 이름을 입력하세요>>");
        String s1 = sc.next();

        System.out.print("두번째 파일 이름을 입력하세요>>");
        String s2 = sc.next();
        try {
            File f1 = new File(s1);
            File f2 = new File(s2);
            fout = new FileWriter("append.txt");
            fr1 = new FileReader(f1);
            fr2 = new FileReader(f2);

            int c;
            while((c = fr1.read()) != -1) {
                fout.write((char)c);
            }
            while((c = fr2.read()) != -1) {
                fout.write((char)c);
            }
            fout.close();
            fr1.close();
            fr2.close();

            System.out.println("프로젝트 폴더 밑에 appended.txt 파일에 저장하였습니다.");
        } catch (IOException e) {
            System.out.println("입출력 오류가 발생했습니다.");
        }
    }
}
