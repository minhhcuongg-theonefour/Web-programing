package web.group6.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.group6.connection.JDBCConnection;
import web.group6.helpers.Content;

public class ContentModel {
	private static final String SELECT_CONTENT_USER = "select * from dbo.Content WHERE authorID=?";
	private static final String DELETE_CONTENT = "delete from Content where id = ?;";
	private static final String SELECT_CONTENT_BY_ID="SELECT authorID, title, brief, content, createdDate FROM dbo.Content WHERE id=?";
	private static final String EDIT_CONTENT ="UPDATE Content set title =?, brief=?, content=?, createdDate=? WHERE authorID & id=?";
	
	public ContentModel() {}
	//delete Content
	public boolean deleteContent( int contentID) throws SQLException {
		try (
				Connection con = JDBCConnection.getJDBCConnection(); 
				PreparedStatement ps = con.prepareStatement(DELETE_CONTENT);) {
	            ps.setInt(1, contentID);
	            ps.executeUpdate();
	            return true;
        }
		catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}
	
	//select all content
	 public List < Content > selectContentUser(int userId) {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < Content > cont = new ArrayList < > ();
	        // Step 1: Establishing a Connection
			try(Connection con = JDBCConnection.getJDBCConnection(); 
					PreparedStatement ps = con.prepareStatement(SELECT_CONTENT_USER)) {
				ps.setInt(1, userId);
	            ResultSet rs = ps.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int authorID = rs.getInt("authorID");
	                int contentID = rs.getInt("id");
	                String title = rs.getString("Title");
	                String brief = rs.getString("Brief");
	                String content = rs.getString("Content");
	                String createdDate = rs.getString("CreatedDate");
	                cont.add(new Content(authorID, contentID, title, brief, content, createdDate));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return cont;
	    }
	 
	 public Content selectContent (int contentID) {
		 	Content cont = null;
			try(Connection con = JDBCConnection.getJDBCConnection(); 
					PreparedStatement ps = con.prepareStatement(SELECT_CONTENT_BY_ID)) {
				ps.setInt(1, contentID);
	            System.out.println(ps);
	            ResultSet rs = ps.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int authorID = rs.getInt("authorID");
	                String title = rs.getString("title");
	                String brief = rs.getString("brief");
	                String content = rs.getString("content");
	                String createdDate = rs.getString("createdDate");
	                cont=new Content(authorID, contentID, title, brief, content, createdDate);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return cont;
	    }
	 
	    public boolean editContent(Content cont) throws SQLException {
	        boolean rowUpdated;
			try(Connection con = JDBCConnection.getJDBCConnection(); 
					PreparedStatement ps = con.prepareStatement(EDIT_CONTENT)) {
	            ps.setString(1, cont.getTitle());
	            ps.setString(2, cont.getBrief());
	            ps.setString(3, cont.getContent());
	            ps.setString(4, cont.getDate());
	            ps.setInt(5, cont.getAuthorID());
	            ps.setInt(6, cont.getContentId());

	            rowUpdated = ps.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
	    
	    


	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}
}
