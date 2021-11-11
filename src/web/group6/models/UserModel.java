package web.group6.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import web.group6.connection.JDBCConnection;
import web.group6.helpers.Member;

public class UserModel {

	public UserModel() {}
	public String insertUser(Member member) {
		
		Connection con = JDBCConnection.getJDBCConnection();
		
		if(con != null) {
			System.out.println("Success");
		}else {
			System.out.println("Failed");
		}
		System.out.println(member.getEmail());
		String result = "Data entered successfully";
		
		String sql = "INSERT INTO Users(username, email, pass)"+ "VALUES(?,?,?)";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getUname());
			ps.setString(2, member.getEmail());
			ps.setString(3, member.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sads");
			e.printStackTrace();
			result = "data not entered";
			
		}	
		return result;
	}
	public String loginUser(Member member) {
		String sql="hello";
		try (Connection con = JDBCConnection.getJDBCConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, member.getEmail());
            ps.setString(2, member.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
		return null;
	}
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
