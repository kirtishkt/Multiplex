package multiplex.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import multiplex.dao.HallDAO;
import multiplex.model.Users;

/**
 * Servlet implementation class AddHall
 */
@WebServlet("/addhall")
public class AddHall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String desc = request.getParameter("desc");
	String capacity = request.getParameter("capacity");
	String hallid = request.getParameter("hallid");
	HttpSession session = request.getSession(false);

	Users user = (Users) session.getAttribute("user");
	if(user != null)
	{
	if(user.getUserType() == 'A')
	{
		HallDAO hd =new HallDAO();
		try {
			
			hd.addHall(hallid,desc, capacity);
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
		dispatcher.forward(request, response);
		
	}else {
		request.setAttribute("errormsg", "UnAuthorise Access!!!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
		dispatcher.forward(request, response);
	}
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
