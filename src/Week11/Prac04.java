package Week11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prac04 extends JFrame {
    public Prac04() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel label = new JLabel("Love Java");
        c.add(label);
        c.setFocusable(true);
        c.requestFocus();

        c.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    String text = label.getText();
                    label.setText(text.substring(1) + text.charAt(0));
                }
            }
        });

        setTitle("Left 키로 문자열 이동");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Prac04();
    }
}
