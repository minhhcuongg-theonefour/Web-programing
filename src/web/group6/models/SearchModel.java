package web.group6.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.group6.connection.JDBCConnection;
import web.group6.helpers.Content;
import web.group6.helpers.Member;

public class SearchModel {
	private static final String GET_SEARCH_RESULT_COUNT = "SELECT COUNT(*) FROM dbo.Content WHERE authorID=? AND Title LIKE ?";
	private static final String GET_SEARCH_RESULT_BY_PAGING = "WITH x AS(SELECT ROW_NUMBER() OVER (ORDER BY CreatedDate DESC) AS number, * FROM dbo.Content WHERE authorID=? AND Title LIKE ? )"
			+ "SELECT * FROM x WHERE number BETWEEN ?*3-2 AND ?*3 ";
	
	public SearchModel() {}
	
	public int resultCount(int userId, String txtSearch) throws SQLException {	
		try(Connection con = JDBCConnection.getJDBCConnection(); PreparedStatement ps = con.prepareStatement(GET_SEARCH_RESULT_COUNT)){
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
	
	public List<Content> search(int userId, String txtSearch, int index){
		try(Connection con = JDBCConnection.getJDBCConnection(); PreparedStatement ps = con.prepareStatement(GET_SEARCH_RESULT_BY_PAGING)){
			ps.setInt(1, userId);
			ps.setString(2,"%"+txtSearch+"%");
			ps.setInt(3, index);
			ps.setInt(4, index);
			ResultSet rs = ps.executeQuery();
			List<Content> list = new ArrayList<>();
			
			while(rs.next()) {
				Content content = new Content(rs.getInt("authorID"),
							rs.getInt("id"),
							rs.getString("Title"),
							rs.getString("Brief"),
							rs.getString("Content")
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
