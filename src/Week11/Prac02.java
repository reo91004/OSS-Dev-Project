package Week11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prac02 extends JFrame{
    public Prac02() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.GREEN);

        c.addMouseListener(new mouseListener());
        c.addMouseMotionListener(new motionListener());

        setTitle("드래깅동안 YELLOW");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    public class mouseListener extends MouseAdapter {
        public void mouseReleased(MouseEvent e) {
            Container c = (Container) e.getSource();
            c.setBackground(Color.GREEN);
        }
    }

    public class motionListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e) {
            Container c = (Container) e.getSource();
            c.setBackground(Color.yellow);
        }
    }

    public static void main(String[] args) {
        new Prac02();
    }
}

