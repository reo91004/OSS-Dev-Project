package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myMovie extends  JFrame{
    private DefaultTableModel dtmmyMovielist;

    public myMovie() {
        // 배경 패널 생성
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null);
        add(backgroundPanel);
        
        // 영화 목록을 보여줄 기능
        String[] columnNames1 = new String[] { "영화이름","포스터","태그1","태그2","평점","출시연도"};

        dtmmyMovielist = new DefaultTableModel(columnNames1, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // 입력된 클래스가 그대로 column에 표현되도록 함
        JTable jtmovielist = new JTable(dtmmyMovielist) {
            @Override
            public Class<?> getColumnClass(int column) {
                // row - JTable에 입력된 이차원 배열의 행에 속한다면
                // 모든 컬럼의 값을 입력된 형태로 반환한다.
                return getValueAt(0, column).getClass();
            }
        };
        
        JScrollPane showjtmymoviecard;

        jtmovielist.setRowHeight(100); // 행 높이 조절
        jtmovielist.getTableHeader().setReorderingAllowed(false);  // 열 이동 막기
        jtmovielist.getTableHeader().setResizingAllowed(false); // 열 너비 변경 막기
        jtmovielist.getColumnModel().getColumn(0).setPreferredWidth(100); // 열 너비 조절
        showjtmymoviecard = new JScrollPane(jtmovielist);
        showjtmymoviecard.setPreferredSize(new Dimension(590, 490));

     // 영화 목록을 보여주는 패널
        JPanel showMovie = new JPanel();
        showMovie.setBounds(0, 0, 600, 500);
        showMovie.setBackground(Color.WHITE);
        backgroundPanel.add(showMovie);
        
        myMoviecontroller my = new myMoviecontroller(this);
        showMovie.add(showjtmymoviecard);
        
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

	

	public DefaultTableModel getDtmmyMovielist() {
		// TODO Auto-generated method stub
		return dtmmyMovielist;
	}
	
	public static void main(String[] args) {
        new myMovie();
    }
}
