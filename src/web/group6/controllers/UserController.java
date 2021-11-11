package web.group6.controllers;

import java.io.IOException;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import web.group6.helpers.Member;
import web.group6.models.UserModel;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet(name="UserController",urlPatterns= {"/user/*"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getPathInfo();
		System.out.println(action);
		switch (action) {
		    case "/register":
		        insertUser(request, response);
		        break;
		    case "/sign-in":
		    	loginUser(request, response);
		    	break;
		    default:
		        notFound(request, response);
		        break;
		}	
	}
	private void insertUser(HttpServletRequest request, HttpServletResponse response) {
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		Member member = new Member(uname, password, email);
		UserModel user = new UserModel();
		String result = user.insertUser(member);
		System.out.println(result);
		try {
			response.getWriter().print("hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void loginUser(HttpServletRequest request, HttpServletResponse response) {
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Member member = new Member(email,password);
		
	}
	private void notFound(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("death");
	}

}
