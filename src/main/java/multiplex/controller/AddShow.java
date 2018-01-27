package multiplex.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import multiplex.dao.HallDAO;
import multiplex.dao.MovieDAO;
import multiplex.model.Users;

/**
 * Servlet implementation class AddShow
 */
@WebServlet("/addshow")
public class AddShow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hallid = request.getParameter("hall");
		String movie = request.getParameter("movie");
		String slotno = request.getParameter("slot");
		String from = request.getParameter("fromdate");
		String to =request.getParameter("todate");
		
		HttpSession session = request.getSession(false);

		Users user = (Users) session.getAttribute("user");
		if(user != null)
		{
		if(user.getUserType() == 'A')
		{
			MovieDAO m =new MovieDAO();
			m.addShow(hallid, movie, slotno,from,to);
			request.setAttribute("msg", "Show Added Successfully!!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
			dispatcher.forward(request, response);
			
		}else {
			request.setAttribute("errormsg", "UnAuthorise Access!!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
		}
		
	}

}
