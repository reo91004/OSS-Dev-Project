package Week10_2;

import javax.swing.*;
import java.awt.*;

public class Prac06 extends JFrame {
    public Prac06() {
        Container c = getContentPane();
        c.setLayout(null);

        for (int i = 0; i < 20; i++) {
            int x = (int)(Math.random() * 200) + 50;
            int y = (int)(Math.random() * 200) + 50;

            JLabel label = new JLabel((int)(Math.random() * 100) + "");
            label.setBounds(x, y, 10, 10);
            label.setOpaque(true);
            label.setBackground(Color.RED);
            c.add(label);
        }

        setTitle("Prac06");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Prac06 start = new Prac06();
    }
}
