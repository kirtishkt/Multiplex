package multiplex.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import multiplex.dao.HallDAO;
import multiplex.model.Halls;
import multiplex.model.Users;

/**
 * Servlet implementation class ShowHall
 */
@WebServlet("/showHall")
public class ShowHall extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String hallid = request.getParameter("hallid");
		HttpSession session = request.getSession(false);
		HallDAO hd = new HallDAO();

		Users user = (Users) session.getAttribute("user");
		if(user.getUserName() != null)
		{
			if(user.getUserType() == 'A')
			{
				try {
					Halls hall = hd.showHall(hallid);
					if(hall != null)
					{
						request.setAttribute("hall", hall);
						request.getRequestDispatcher("halldetails.jsp").forward(request, response);
					}else {
						request.setAttribute("errormsg", "Invalid Hall ID");
						request.getRequestDispatcher("halldetails.jsp").forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				request.setAttribute("errormsg", "UnAuthorized Access!!!");
				request.getRequestDispatcher("halldetails.jsp").forward(request, response);
			}
		}
	}

}
