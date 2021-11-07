package Week10_2;

import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel {
    public NorthPanel() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout());
        add(new JButton("열기"));
        add(new JButton("닫기"));
        add(new JButton("나가기"));
    }
}

class CenterPanel extends JPanel {
    public CenterPanel() {
        setLayout(null);
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel("*");
            int x = (int) (Math.random() * 250);
            int y = (int) (Math.random() * 150);

            label.setLocation(x, y);
            label.setSize(20, 20);
            label.setForeground(Color.red);

            add(label);
        }
    }
}

class SouthPanel extends JPanel {
    public SouthPanel() {
        setBackground(Color.YELLOW);
        setLayout(new FlowLayout());

        add(new JButton("Word Input"));
        add(new JTextField(15));
    }
}

public class Prac08 extends JFrame {
    public Prac08() {
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BorderLayout());
        add(backgroundPanel);

        backgroundPanel.add(new NorthPanel(), BorderLayout.NORTH);
        backgroundPanel.add(new CenterPanel(),BorderLayout.CENTER);
        backgroundPanel.add(new SouthPanel(), BorderLayout.SOUTH);

        setTitle("Prac08");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        Prac08 start = new Prac08();
    }
}
