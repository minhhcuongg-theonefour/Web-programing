package web.group6.controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet(name="UserController",urlPatterns= {"/"})
public class HomeController extends HttpServlet {

	 /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	String action = request.getServletPath();
    	switch (action) {
        case "/home":
            homePage(request, response);
            break;
        default:
            notFound(request, response);
            break;
    	}
    	
    }
    private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/homePage.jsp");
    	dispatcher.forward(request, response);
    }
    private void notFound(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	response.sendRedirect("/");
	}
    
}
