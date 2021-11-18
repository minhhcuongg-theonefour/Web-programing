package web.group6.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.group6.helpers.Content;
import web.group6.helpers.Member;
import web.group6.helpers.Utilities;
import web.group6.services.SearchService;
import web.group6.services.UserService;

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
		switch (action) {
		    case "/register":
				try {
					insertUser(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        break;
		    case "/sign-in":
			try {
				loginUser(request, response);
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    	break;
		    default:
		        notFound(request, response);
		        break;
		}	
	}
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		Member member = new Member(uname, password, email);
		UserService userService = new UserService();
		if(!userService.validateRegisterForm(member)) {
			response.setStatus(400);
			response.getWriter().print("Don't flatter yourself");
		}else {
			boolean status = userService.insertUser(member);
			if(!status) {
				response.setStatus(400);
				response.getWriter().print("Email existed");
			}else {
				response.getWriter().print("Sign up success");			
			}			
		}
	}
	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String	remember = request.getParameter("remember");
		Member member = new Member(email,password);
		UserService userService = new UserService();
		if(!userService.validateLoginForm(member)) {
			response.setStatus(400);
			response.getWriter().print("Don't flatter yourself");
		}else {
			Member user = null;
			 user = userService.loginUser(member);
			if(user == null) {
				response.setStatus(400);
				response.getWriter().print("Incorrect email or password.");
			}else {
				//save session
				request.getSession().setAttribute("userLogged", email);
				request.getSession().setAttribute("role", user.getRole());
				request.getSession().setAttribute("userId", user.getUserId());
				if(remember.equals("1")) {
					//save cookie
					System.out.print("save cookie");
					Cookie cookieEmail = new Cookie("cookieEmail",email );
					Cookie cookiePass = new Cookie("cookiePass",password );
					Cookie cookieRemember = new Cookie("cookieRemember",remember );
					
					cookieEmail.setMaxAge(60 * 60 * 24);
					cookieEmail.setPath(request.getContextPath());
					
					cookiePass.setMaxAge(60 * 60 * 24);
					cookiePass.setPath(request.getContextPath());
					
					cookieRemember.setMaxAge(60 * 60 * 24);
					cookieRemember.setPath(request.getContextPath());
					
					response.addCookie(cookieEmail);
					response.addCookie(cookiePass);
					response.addCookie(cookieRemember);
				}else {
					Cookie[] cookies = request.getCookies();
					if(cookies != null) {
						for (int i = 0; i < cookies.length; i++) {
							Cookie cookie = cookies[i];
							if(!cookie.getName().equals("JSESSIONID")) {
								Utilities.removeCookie(response,request, cookie.getName());
							}
							
						}						
					}
				}
				
				if(user.getRole() == 1) {
					response.getWriter().print("admin");
				}else {
					response.getWriter().print("user");								
				}
			}			
		}
	}
	
	private void notFound(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("death");
	}

}
