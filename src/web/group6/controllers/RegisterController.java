package web.group6.controllers;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import web.group6.helpers.Member;
import web.group6.models.UserModel;

/**
 * Servlet implementation class Register
 */
@WebServlet(name="RegisterController", urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String uname = request.getParameter("username");
				String password = request.getParameter("password");
				String email = request.getParameter("email");
				
				Member member = new Member(uname, password, email);
				UserModel user = new UserModel();
				String result = user.insertUser(member);
				System.out.println(result);
				response.getWriter().print("hello");
	}

}
