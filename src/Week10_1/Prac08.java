package Week10_1;

import java.io.*;

public class Prac08 {
    public static void main(String[] args) {
        File f = new File("C:\\");
        File sub[] = f.listFiles();

        long size = 0;
        File secf = null;

        for (int i = 0; i < sub.length; i++) {
            File temp = sub[i];
            if (!temp.isFile()) // 파일이 아니면 넘어가도록 함
                continue;

            long fsize = temp.length();
            if (fsize > size) {
                size = fsize;
                secf = temp;
            }
        }

        if(secf == null) // 모두 디렉터리인 경우
            System.out.println("파일은 없습니다");
        else
            System.out.println("가장 큰 파일은 " + secf.getPath() + " " + size + "바이트");
    }
}
