package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class mainFrame extends JFrame {

    private DefaultTableModel dtmmovie;


    public mainFrame() {
        // 배경 패널 설정
        JPanel backgroundPanel = new JPanel();
        add(backgroundPanel);
        backgroundPanel.setLayout(null);


        String[] columnNames = new String[] { "번호", "이미지"};
        dtmmovie = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable jtmoviecard = new JTable(dtmmovie) {

            @Override
            public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };

        JPanel showMovie = new JPanel();
        showMovie.setBounds(0, 0, 600, 500);
        showMovie.setBackground(Color.WHITE);
        backgroundPanel.add(showMovie);



        moviecontroller mc = new moviecontroller(this);
        showMovie.add(jtmoviecard);
        backgroundPanel.add(showMovie);


        // 버튼 생성, 메뉴에 넣도록 함
        // 선호하는 장르를 선택하도록 하는 버튼도 있어야 함
        JButton menuPopularMovie = new JButton("인기순 정렬");
        JButton menuNameMovie = new JButton("이름순 정렬");
        JButton menuRecommendMovie = new JButton("맞춤 추천");
        JButton menuMyMovie = new JButton("내 라이브러리");
        JButton menuReAi = new JButton("맞춤 알고리즘 새로고침");

        menuPopularMovie.setPreferredSize(new Dimension(120, 40));
        menuNameMovie.setPreferredSize(new Dimension(120, 40));
        menuRecommendMovie.setPreferredSize(new Dimension(120, 40));
        menuMyMovie.setBounds(630, 400, 120, 40);
        menuReAi.setBounds(630, 460, 120, 40);


        backgroundPanel.add(menuMyMovie);
        backgroundPanel.add(menuReAi);

        menuMyMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new myMovie();
                dispose();
            }
        });

        menuReAi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new selectFavoriteMovie();
            }
        });

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 중앙에 배치
        setResizable(false);
        setTitle("영화 추천 프로그램");
        setVisible(true);
    }

    public DefaultTableModel getDtmNamecard() {
        return dtmmovie;
    }

    public static void main(String[] args) {
        new mainFrame();
    }
}
