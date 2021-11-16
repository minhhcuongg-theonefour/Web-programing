package web.group6.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.group6.connection.JDBCConnection;
import web.group6.helpers.Member;

public class UserModel {
	private static final String INSERT_USERS_SQL = "INSERT INTO Users(username, email, pass)"+ "VALUES(?,?,?)";
	private static final String CHECK_EMAIL_EXIST = "SELECT email FROM dbo.Users WHERE email = ?;";
	private static final String GET_PASSWORD_BY_EMAIL="SELECT pass FROM dbo.Users WHERE email = ?;";
	private static final String GET_ROLE_BY_EMAIL = "SELECT id,roles,username,roles FROM dbo.Users WHERE email=?;";
	public UserModel() {}
	
	public void insertUser(Member member) throws SQLException {	
		try(Connection con = JDBCConnection.getJDBCConnection(); PreparedStatement ps = con.prepareStatement(INSERT_USERS_SQL)){
			ps.setString(1, member.getUname());
			ps.setString(2, member.getEmail());
			ps.setString(3, member.getPassword());
			ps.executeUpdate();
		}catch(SQLException e) {
			printSQLException(e);
		}
	}
	public String getPasswordByEmail(String email) {
		String pass = null;
		try(Connection con = JDBCConnection.getJDBCConnection(); PreparedStatement ps = con.prepareStatement(GET_PASSWORD_BY_EMAIL)){
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				pass = rs.getString("pass");
			}
		}catch(SQLException e) {
			printSQLException(e);
		}
		return pass;
	}
	public boolean checkEmailExist(String email) {
		boolean status = false;
		try(Connection con = JDBCConnection.getJDBCConnection(); PreparedStatement ps = con.prepareStatement(CHECK_EMAIL_EXIST)){
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("email").length() > 0) {
					status = true;
				}
			}
		}catch(SQLException e) {
			printSQLException(e);
		}
		return status;
	}
	public Member getRoleByEmail(String email) {  
		Member member = null;
		try(Connection con = JDBCConnection.getJDBCConnection(); PreparedStatement ps = con.prepareStatement(GET_ROLE_BY_EMAIL)){
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("id");
				String username = rs.getString("username");
				int role = rs.getInt("roles");
				member = new Member(userId, username, email, role);
			}
		}catch(SQLException e) {
			printSQLException(e);
		}
		return member;
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
