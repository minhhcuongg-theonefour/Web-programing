package web.group6.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import config.App;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.group6.helpers.AdminContent;
import web.group6.helpers.Content;
import web.group6.models.AdminContentModel;
import web.group6.services.SearchService;



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
		System.out.println(action);
		switch (action) {
		    case "/home":
				try {
					homeAdmin(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "/delete":
				try {
					deleteContent(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
		    case "/logout":
				logoutPage(request, response);
				break;
		    case "/search":
		    	try {
					searchAdmin(request, response);
				} catch (IOException | ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            break;
		    case "/":
		    	notFound(request, response);
	            break;
		    default:
		        notFound(request, response);
		        break;
		}
	}
	private void homeAdmin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int count = AdminContentModel.countContent();
		int index = request.getParameter("index") != null ? Integer.parseInt(request.getParameter("index")) : 1;
		int pageSize = 10;
		int endPage = 0;
		endPage = count/ pageSize;
		if(count % pageSize != 0) {
			endPage++;
		}
		List<AdminContent> listContent = AdminContentModel.pageList(index,pageSize);
		request.setAttribute("end", endPage);
		request.setAttribute("listContentS", listContent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/adminPage.jsp");
		dispatcher.forward(request, response);
	}
	private void deleteContent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AdminContentModel.deleteContent(id);
		response.sendRedirect("home");
	}
	private void logoutPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	session.invalidate();
    	response.sendRedirect(request.getContextPath());
    }
	private void notFound(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/notFound.jsp");
    	dispatcher.forward(request, response);
	}
	private void searchAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false); 
		int adminId = (int) session.getAttribute("userId");
		int role = (int) session.getAttribute("role");
		
		if(role == 1) {
			int index = Integer.parseInt(request.getParameter("index"));
			String txtSearch = request.getParameter("txtSearch");
			
			SearchService searchService = new SearchService();
			int count = searchService.resultCount(adminId, txtSearch, role);
			int endPage	= 0;
			
			endPage = count / App.pageSize;
			if(count % App.pageSize != 0) {
				endPage++;
			}
			if(count == 0) {
				request.setAttribute("endPage", endPage);
			}else {
				List<Content> listSearch = searchService.search(adminId, txtSearch, index, role);
				request.setAttribute("endPage", endPage);
				request.setAttribute("listSearch", listSearch);
				request.setAttribute("save",txtSearch);
				request.setAttribute("page",index);
				
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/searchContent.jsp");
		        dispatcher.forward(request, response);
			}
			
		}else {
			response.sendRedirect(request.getContextPath());
		}
    }

}
