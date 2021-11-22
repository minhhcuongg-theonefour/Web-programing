package web.group6.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.group6.helpers.AdminContent;
import web.group6.models.AdminContentModel;

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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getPathInfo();
		switch (action) {
		case "/home":
			try {
				homeAdmin(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/logout":
			logoutPage(request, response);
			break;
		case "/delete":
			try {
				deleteContent(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
	
	private void notFound(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("death");
	}
	private void logoutPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath());
	}
	private void deleteContent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AdminContentModel.deleteContent(id);
		response.sendRedirect("home");
	}
	

}
