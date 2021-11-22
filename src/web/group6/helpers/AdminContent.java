package web.group6.helpers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AdminContent {
	private int contentId, authorID;
	private String title, brief, content, createdDate;
	
	public AdminContent(int contentId, int authorID, String title, String brief, String content, String createdDate) {
		super();
		this.contentId = contentId;
		this.authorID = authorID;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createdDate = createdDate;
	}
	
	public AdminContent(int authorID, String title, String brief, String content, String createdDate) {
		super();
		this.authorID = authorID;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createdDate = createdDate;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	
	public static String convertDate(Date date, String hour, String minute) {
		String patternDate = "dd/MM/yyyy";
		DateFormat df = new SimpleDateFormat(patternDate);
		String targetDate = df.format(date);
		String timeTmp =minute;
		String hourTmp = hour;
		if(Integer.parseInt(minute) <= 10) {
			timeTmp ="0"+ minute;
		}
		if(Integer.parseInt(hour) <= 10) {
			hourTmp ="0"+hour;
		}
		return targetDate+" "+hourTmp+":"+timeTmp;
		
    }
}
