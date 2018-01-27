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
 * Servlet implementation class AddSeat
 */
@WebServlet("/addseat")
public class AddSeat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hallid =   request.getParameter("hall");
		String seatdesc = request.getParameter("seatdesc");
		String seatcount = request.getParameter("seatcount");
		String seatfare = request.getParameter("seatfare");
		HttpSession session = request.getSession(false);
		
		Users user = (Users) session.getAttribute("user");
		if(user != null)
		{
		if(user.getUserType() == 'A')
		{
			HallDAO hd =new HallDAO();
			try {
				
				hd.addSeat(Integer.parseInt(hallid), seatdesc, Integer.parseInt(seatcount),Integer.parseInt(seatfare));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("msg", "Seat Added Successfully!!!");
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
