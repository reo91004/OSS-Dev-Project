package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;


public class myMovieDAO {
	private static myMovieDAO my_dao;
    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs = null;
    private Statement st = null;
    
    public  myMovieDAO() {
    	try {
            con = DriverManager.getConnection("jdbc:mysql://146.56.185.190:3306/myMovie?autoReconnect=true&verifyServerCertificate=false&useSSL=true", "root",
                    "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static myMovieDAO getInstance() {
		if (my_dao == null) {
            my_dao = new myMovieDAO();
        }
        return my_dao;
	}

	public List<myMovieDTO> selectallmyMovie() throws SQLException{
		List<myMovieDTO> list = new ArrayList<myMovieDTO>();
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from Mylist;");
			
			while(rs.next()) {
				list.add(new myMovieDTO(rs.getString("name"),rs.getString("img"),rs.getString("tag1"),rs.getString("tag2"),rs.getString("star"),rs.getString("year")));
			}
		} catch (SQLException e) {
			System.out.println(e+"회원목록 실패");
		} finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
		
		return list;
		
	}
	
	
	 public ArrayList<myMovieDTO> reviewRead() {
	        ArrayList<myMovieDTO> list = new ArrayList<myMovieDTO>();
	        System.out.println(list);
	        try {
	            st = con.createStatement();
	            rs = st.executeQuery("select * from Mylist;");
	            while (rs.next()) {
	            	list.add(new myMovieDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6)));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                st.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return list;
	    }

	public void reviewUpdate(String name, String star) throws SQLException {
        try {
            st = con.createStatement();
            int stmt = st.executeUpdate("update Mylist set star = '" + star + "' where name = '" + name + "';");
        } catch (SQLException e) {
            System.out.println(e + "수정 실패");
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        } 
        
	public void reviewDelete(String name) throws SQLException {
		try {
            st = con.createStatement();
            int stmt = st.executeUpdate("delete from Mylist where name = '" + name + "';");
        } catch (SQLException e) {
        	System.out.println(e + "삭제 실패");
        }finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
		
	/*
	public void update(String name, String star) {
        try {
            st = (Statement) con.createStatement();
            int stmt = st
                    .executeUpdate("update Mylist set star = '" + star + "' where name = '" + name + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/

	private void close() throws SQLException {
		  if (rs != null) { rs.close(); }
	        if (ps != null) { ps.close(); }
	        if (con != null) { con.close(); }
	}



}
