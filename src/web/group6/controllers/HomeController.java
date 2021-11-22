package web.group6.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import config.App;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.group6.helpers.Content;
import web.group6.services.SearchService;


@WebServlet(name="HomeController",urlPatterns= {"/"})
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
        case "/search":
			try {
				searchContent(request, response);
			} catch (SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
    
    private void searchContent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException ,ServletException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			HttpSession session=request.getSession(false); 
			int userId = (int) session.getAttribute("userId");
			
			int index = Integer.parseInt(request.getParameter("index"));
			String txtSearch = request.getParameter("txtSearch");
			
			SearchService searchService = new SearchService();
			
			int count = searchService.resultCount(userId, txtSearch);
			int endPage	= 0;
			
			endPage = count / App.pageSize;
			if(count % App.pageSize != 0) {
				endPage++;
			}
			if(count == 0) {
				request.setAttribute("endPage", endPage);
			}else {
				List<Content> listSearch = searchService.search(userId, txtSearch, index);
				request.setAttribute("endPage", endPage);
				request.setAttribute("listSearch", listSearch);
				request.setAttribute("save",txtSearch);
				
				
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/searchContent.jsp");
		        dispatcher.forward(request, response);
			}			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
