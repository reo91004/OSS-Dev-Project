package Week11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prac06 extends JFrame {
    public Prac06() {
        Container c = getContentPane();
        c.setLayout(null);

        JLabel label = new JLabel("c");
        label.setBounds(100, 100, 10, 10);
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = (int) (Math.random() * c.getWidth());
                int y = (int) (Math.random() * c.getHeight());
                label.setLocation(x, y);
            }
        });

        c.add(label);

        setTitle("클릭 연습 용 응용프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Prac06();
    }
}
