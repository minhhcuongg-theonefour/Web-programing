package web.group6.controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
        case "/view-content":
            viewContentPage(request, response);
            break;
        case "/add-content":
            addContent(request, response);
            break;
        case "/edit-profile":
            editProfile(request, response);
            break;
        case "/admin":
            adminPage(request, response);
            break;
        case "/logout":
            logoutPage(request, response);
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
    private void viewContentPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/viewContent.jsp");
    	dispatcher.forward(request, response);
    	
    }
    private void addContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/addContent.jsp");
    	dispatcher.forward(request, response);
    	
    }
    private void editProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/editProfile.jsp");
    	dispatcher.forward(request, response);
    	
    }
    private void adminPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/adminPage.jsp");
    	dispatcher.forward(request, response);
    }
    private void logoutPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	session.invalidate();
    	response.sendRedirect(request.getContextPath());
    }
    private void notFound(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	System.out.print("erorrrr");
    	response.sendRedirect(request.getContextPath());
	}
    
}
