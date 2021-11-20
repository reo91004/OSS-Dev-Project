package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myMovie extends  JFrame{
    public myMovie() {
        // 배경 패널 생성
        JPanel backgroundPanel = new JPanel();
        add(backgroundPanel);
        backgroundPanel.setLayout(null);

        // 뒤로가기 버튼 생성, 삽입
        JButton btnBack =  new JButton("뒤로가기");
        btnBack.setBounds(630, 460, 120, 40);
        backgroundPanel.add(btnBack);

        // 처음 화면으로 가기 위한 메소드
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame start = new mainFrame();
                dispose();
            }
        });

        setSize(800, 600);
        setLocationRelativeTo(null); // 중앙에 배치
        setResizable(false);
        setTitle("내 영화");
        setVisible(true);
    }
}
