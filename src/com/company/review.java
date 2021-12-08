package com.company;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class review extends  JFrame {
    JTextArea ta = new JTextArea();

	JFrame jframe = new JFrame();
    JPanel jpanel = new JPanel();
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JButton btnUp, btnDel, btnSel,btnBack;
    
    JLabel movieName = new JLabel("영화이름  ");
    JLabel reviewIn = new JLabel("리뷰작성   ");
    
    
    public review() {
       // 영화 목록을 보여주는 패널
    	jframe.setTitle("라이브러리");
        jframe.setBounds(50, 50, 500, 600);
//        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jpanel.setLayout(null);
        jframe.add(jpanel);
          
          //영화 이름 작성
    		t1.setBounds(75, 25, 200, 25);
    		jpanel.add(t1);
    		movieName.setBounds(20, 21, 70, 30);
    		jpanel.add(movieName);
    		
    		//영화리뷰작성
    		t2.setBounds(75, 55, 200, 150);
            jpanel.add(t2);
            reviewIn.setBounds(20, 55, 70, 30);
            jpanel.add(reviewIn);  
            
            //테이블 조회
            JScrollPane jsp = new JScrollPane(ta);
            jsp.setBounds(25, 245, 400, 250);
            jpanel.add(jsp);
            
            //수정,조회,삭제 버튼
            jpanel.add(btnSel = new JButton("확인"));
            btnSel.setBounds(350, 25, 80, 30);

            jpanel.add(btnUp = new JButton("수정"));
            btnUp.setBounds(350, 75, 80, 30);

            jpanel.add(btnDel = new JButton("삭제"));
            btnDel.setBounds(350, 125, 80, 30);
            
            jpanel.add(btnBack = new JButton("라이브러리"));
            btnBack.setBounds(350, 175, 100, 30);
           
            myMovieDAO my_dao = new myMovieDAO();

       //형화 목록 조회
            btnSel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    ta.setText("");
            		ArrayList<myMovieDTO> list = new ArrayList<myMovieDTO>();
            		list = my_dao.reviewRead();

                    ta.append( "name" + "\t" + "tag1"+ "\t" + "tag2"+ "\t" +"review"+ "\t" + "year\n");

                    for (int i = 0; i < list.size(); i++) {
                        ta.append(list.get(i).getmyName() + " \t "  + list.get(i).getTag1()+ " \t " + list.get(i).getTag2()+ " \t " + list.get(i).getStar()+ " \t " + list.get(i).getYear()
                                + "\n");
                    }
                }
            });           
            //영화리뷰 수정
    btnUp.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            ta.setText("");

            String myname = t1.getText();
            String review = t2.getText();
            try {
				my_dao.reviewUpdate(myname,review);

	            ta.append("수정 완료되었습니다.\t\n라이브러리에서 확인바랍니다 \n");


	            t1.setText("");
	            t2.setText("");
            }catch (SQLException e) {
            	System.out.println(e+"");
            	}
        }
    });
    
    //영화 삭제
    btnDel.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
    	 ta.setText("");

         String name = t1.getText();
         try {
			my_dao.reviewDelete(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         ta.append("삭제 완료되었습니다,\t\n 라이브러리에서 확인바랍니다 \n");
    }
});
    //라이브러리 이동
    btnBack.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
           new myMovie();
        	 dispose();
        }
    });
    }
   
   
    public static void main(String[] args) {
        new review();
    }
}
    
