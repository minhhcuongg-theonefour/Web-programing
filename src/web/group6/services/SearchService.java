package web.group6.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.group6.helpers.Content;
import web.group6.models.SearchModel;

public class SearchService {
	public SearchService() {}
	
	public List<Content> search (int userId, String txtSearch, int index){
		SearchModel searchModel = new SearchModel();
		List<Content> list = new ArrayList<>();
		list = searchModel.search(userId, txtSearch, index);
		if(list == null) {
			return null;
		}
		return list;
	}
	
	public int resultCount (int userId, String txtSearch){
		int count = 0;
		SearchModel searchModel = new SearchModel();
		try {
			count = searchModel.resultCount(userId, txtSearch);
			return count;			
		}catch(SQLException e) {
			System.out.print(e);
		}
		return count;
	}
}
