package web.group6.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.group6.connection.JDBCConnection;
import web.group6.helpers.AdminContent;

public class AdminContentModel {
	private static final String SELECT_ALL_CONTENT = "select * from Content";
	private static final String DELETE_CONTENT_SQL = "delete from Content where id = ?;";
	private static final String COUNT_CONTENT = "SELECT COUNT(*) FROM Content";
	private static final String PAGE = "With x as(select ROW_NUMBER() OVER (order by id desc) as r,* from Content)"
			+ "select authorID, id,Title, Brief,Content, DATENAME(hh, CreatedDate) AS Hour,DATENAME(n, CreatedDate) AS Minute, CreatedDate from x where r between ?*10-9 and ?*10";
	
	public static void deleteContent(int id) throws SQLException {
		try (
				Connection connection = JDBCConnection.getJDBCConnection(); 
				PreparedStatement statement = connection.prepareStatement(DELETE_CONTENT_SQL);) {
	            statement.setInt(1, id);
	            statement.executeUpdate();
        }
		catch (SQLException e) {
            e.printStackTrace();
        }
	}
    
	public static int countContent()
	{
		try (Connection connection = JDBCConnection.getJDBCConnection(); 
			PreparedStatement statement = connection.prepareStatement(COUNT_CONTENT);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		}
		catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}
	
	public static List<AdminContent> pageList(int index, int size) {
		List<AdminContent> contents = new ArrayList<>();
        try (Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(PAGE);) {
        	preparedStatement.setInt(1, index);
        	preparedStatement.setInt(2, index);
        	ResultSet rs = preparedStatement.executeQuery();
        	while (rs.next()) {
        		int contentId = rs.getInt("id");
                int authorID = rs.getInt("authorID");
                String title = rs.getString("Title");
                String brief = rs.getString("Brief");
                String content = rs.getString("Content");
                String createdDate = AdminContent.convertDate(rs.getDate("CreatedDate"),rs.getString("Hour"),rs.getString("Minute"));
                AdminContent ct = new AdminContent(contentId, authorID , title, brief, content, createdDate);
                contents.add(ct);
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contents;
    }

}
