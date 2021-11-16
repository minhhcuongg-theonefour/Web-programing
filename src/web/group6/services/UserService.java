package web.group6.services;

import java.sql.SQLException;

import web.group6.helpers.Member;
import web.group6.helpers.Utilities;
import web.group6.models.UserModel;

public class UserService {
	public UserService() {}
	
	public boolean insertUser(Member member) throws SQLException {
		UserModel userModel =new UserModel();
		
		if(userModel.checkEmailExist(member.getEmail())) {
			return false;
		}

		member.setPassword(Utilities.getMd5(member.getPassword()));
		userModel.insertUser(member);
		
		return true;
	}
	public Member loginUser(Member member) throws SQLException {
		Member user = null;
		UserModel userModel =new UserModel();
		
		if(!userModel.checkEmailExist(member.getEmail())) {
			return null;
		}
		String pass = userModel.getPasswordByEmail(member.getEmail());
		member.setPassword(Utilities.getMd5(member.getPassword()));
		if(pass.equals(member.getPassword())) {
			
			user = userModel.getRoleByEmail(member.getEmail());
			return user;
		}else {
			return null;
		}
	}
	public boolean validateRegisterForm(Member member) {
		if(member.getEmail().length() < 5 && member.getEmail().length() > 50 ) {
			return false;
		}
		if(!Utilities.validateEmail(member.getEmail())) {
			return false;
		}
		if(member.getUname().length() <3 && member.getUname().length() > 30) {
			return false;
		}
		if(member.getPassword().length() < 8 && member.getPassword().length() > 30) {
			return false;
		}
		return true;
	}
	public boolean validateLoginForm(Member member) {
		if(member.getEmail().length() < 5 && member.getEmail().length() > 50 ) {
			return false;
		}
		if(!Utilities.validateEmail(member.getEmail())) {
			return false;
		}
		if(member.getPassword().length() < 8 && member.getPassword().length() > 30) {
			return false;
		}
		return true;
	}
}
