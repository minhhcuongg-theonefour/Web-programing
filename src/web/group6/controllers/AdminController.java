package web.group6.controllers;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet(name="AdminController",urlPatterns= {"/admin/*"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getPathInfo();
		switch (action) {
		    case "/home":
				homeAdmin(request, response);
				break;
		    case "/logout":
				logoutPage(request, response);
				break;
		    default:
		        notFound(request, response);
		        break;
		}	
	}
	private void homeAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/adminPage.jsp");
    	dispatcher.forward(request, response);
	}
	private void notFound(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("death");
	}
	private void logoutPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	session.invalidate();
    	response.sendRedirect(request.getContextPath());
    }

}
