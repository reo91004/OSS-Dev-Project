package Week10_1;

import java.io.*;
import java.util.*;

public class Prac12 {
    public static void main(String[] args) {
        Vector<String> linecontent = new Vector<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
        System.out.print("대상 파일명 입력>> ");

        String name = sc.nextLine();
        File f = new File(name);

        // 파일을 벡터에 저장
        try {
            Scanner fsc = new Scanner(new FileReader(f));
            // 모든 문장을 넣음
            while (fsc.hasNext()) {
                String line = fsc.nextLine();
                linecontent.add(line);
            }

            while (true) {
                System.out.print("검색할 단어나 문장>> ");
                name = sc.nextLine();

                if (name.equals("그만"))
                    break;

                for (int i = 0; i < linecontent.size(); i++) {
                    String temp = linecontent.get(i);
                    if (temp.contains(name)) { // 메소드 공부
                        System.out.println(i + ":" + temp);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
