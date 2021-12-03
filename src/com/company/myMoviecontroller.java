package com.company;

import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

public class myMoviecontroller extends WindowAdapter {

	private myMovie my;
	private myMovieDAO my_dao;
	
	public myMoviecontroller(myMovie my) {
		this.my = my;
		my_dao = myMovieDAO.getInstance();
		setmyNamecard();
	}

	private void setmyNamecard() {

		try {
			List<myMovieDTO> list =  my_dao.selectallmyMovie();
			
			Object[] rowData = null;
			myMovieDTO tempDTO = null;
			for(int i=0; i<list.size(); i++) { // 조회된 레코드 수만큼 반복
                tempDTO = list.get(i);
                rowData = new Object[]{
                                tempDTO.getmyName(),
                                tempDTO.getImg(),
                                tempDTO.getTag1(),
                                tempDTO.getTag2(),
                                tempDTO.getStar(),
                                tempDTO.getYear()
                                
                        };
                my.getDtmmyMovielist().addRow(rowData);
			}
		}catch (SQLException e) {		
            }
	}
	
}
