package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class myMovieDAO {
	private static myMovieDAO my_dao;
    private Connection con1;
    private PreparedStatement pstmt1;
    private ResultSet rs1;


	public static myMovieDAO getInstance() {
		if (my_dao == null) {
            my_dao = new myMovieDAO();
        }
        return my_dao;
	}

	public List<myMovieDTO> selectallmyMovie() throws SQLException{
		List<myMovieDTO> list = new ArrayList<myMovieDTO>();
		
		String url = "jdbc:mysql://146.56.185.190:3306/myMovie?autoReconnect=true&verifyServerCertificate=false&useSSL=true";
        //이클립스 실행시 SSL통신 서버보안 오류가 나타나 SSL을 사용하도록 설정하고 서버 인증서를 검증하는 옵션인 verifyServerCertificate 를 false 로 주어서 인증서 검증을 해제하였습니다 
        //해당부분에 대해서 오류가 있을시 ?autoReconnect=true&verifyServerCertificate=false&useSSL=true 이 부분을 지워 주시면 됩니다.
        String userName = "root";
        String password = "password";
        
        con1 = DriverManager.getConnection(url, userName, password);
        String getmoviecard =
                "SELECT name,img,tag1,tag2,star,year FROM Mylist "; //각 db 가져오기
        pstmt1 = con1.prepareStatement(getmoviecard);
        rs1 = pstmt1.executeQuery();
        
        myMovieDTO my_dto = null;
        while (rs1.next()) {
            my_dto = new myMovieDTO(rs1.getString("name"),
            		rs1.getString("img"), rs1.getString("tag1"),rs1.getString("tag2"),rs1.getString("star"),rs1.getString("year"));
            list.add(my_dto);
        }
        close();
        return list;
		
	}

	private void close() throws SQLException {
		  if (rs1 != null) { rs1.close(); }
	        if (pstmt1 != null) { pstmt1.close(); }
	        if (con1 != null) { con1.close(); }
	}



}
