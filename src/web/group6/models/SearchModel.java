package web.group6.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import web.group6.connection.JDBCConnection;
import web.group6.helpers.Content;
import web.group6.helpers.Member;
import web.group6.helpers.Utilities;

public class SearchModel {
	private static final String GET_SEARCH_RESULT_COUNT = "SELECT COUNT(*) FROM dbo.Content WHERE authorID=? AND Title LIKE ?";
	private static final String GET_SEARCH_RESULT_COUNT_ADMIN = "SELECT COUNT(*) FROM dbo.Content WHERE authorID!=? AND Title LIKE ?";
	private static final String GET_SEARCH_RESULT_BY_PAGING = "WITH x AS(SELECT ROW_NUMBER() OVER (ORDER BY CreatedDate DESC) AS number, * FROM dbo.Content WHERE authorID=? AND Title LIKE ? )"
			+ "SELECT authorID, id,Title, Brief,Content, DATENAME(hh, CreatedDate) AS Hour,DATENAME(n, CreatedDate) AS Minute, CreatedDate FROM x WHERE number BETWEEN ?*10-9 AND ?*10 ORDER BY CreatedDate DESC";
	private static final String GET_SEARCH_RESULT_BY_PAGING_ADMIN = "WITH x AS(SELECT ROW_NUMBER() OVER (ORDER BY CreatedDate DESC) AS number, * FROM dbo.Content WHERE authorID!=? AND Title LIKE ? )"
			+ "SELECT authorID, id,Title, Brief,Content, DATENAME(hh, CreatedDate) AS Hour,DATENAME(n, CreatedDate) AS Minute, CreatedDate FROM x WHERE number BETWEEN ?*10-9 AND ?*10 ORDER BY CreatedDate DESC";
	public SearchModel() {}
	
	public int resultCount(int userId, String txtSearch, int role) throws SQLException {	
		String SQL_COUNT = role == 1 ? GET_SEARCH_RESULT_COUNT_ADMIN : GET_SEARCH_RESULT_COUNT;
		try(Connection con = JDBCConnection.getJDBCConnection(); PreparedStatement ps = con.prepareStatement(SQL_COUNT)){
			ps.setInt(1, userId);
			ps.setString(2,"%"+txtSearch+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		}catch(SQLException e) {
			printSQLException(e);
		}
		return 0;
	}
	
	public List<Content> search(int userId, String txtSearch, int index, int role){
		String SQL_SEARCH = role == 1 ? GET_SEARCH_RESULT_BY_PAGING_ADMIN : GET_SEARCH_RESULT_BY_PAGING;
		try(Connection con = JDBCConnection.getJDBCConnection(); PreparedStatement ps = con.prepareStatement(SQL_SEARCH)){
			ps.setInt(1, userId);
			ps.setString(2,"%"+txtSearch+"%");
			ps.setInt(3, index);
			ps.setInt(4, index);
			ResultSet rs = ps.executeQuery();
			List<Content> list = new ArrayList<>();
			
			while(rs.next()) {
				Content content = new Content(
							rs.getInt("authorID"),
							rs.getInt("id"),
							rs.getString("Title"),
							rs.getString("Brief"),
							rs.getString("Content"),
							Utilities.convertDate(rs.getDate("CreatedDate"),rs.getString("Hour"),rs.getString("Minute"))
						);
				list.add(content);
			}
			return list;
		}catch(SQLException e) {
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
