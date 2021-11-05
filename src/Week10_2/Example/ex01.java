package Week10_2.Example;

import javax.swing.*;

public class ex01 extends JFrame {
    public ex01() {
        setTitle("300x300 스윙 프레임 만들기");
        setSize(300, 300); // 프레임 크기 300x300
        setVisible(true); // 프레임 출력
    }

    public static void main(String[] args) {
        ex01 frame = new ex01();
    }
}
