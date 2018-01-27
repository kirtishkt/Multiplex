package multiplex.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import multiplex.dao.BookingDAO;
import multiplex.dao.MovieDAO;
import multiplex.model.Shows;
import multiplex.model.Users;

/**
 * Servlet implementation class BookMovie
 */
@WebServlet("/bookmovie")
public class BookMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String movie = (String) session.getAttribute("movie");
		String hallid =  request.getParameter("hallid");
		String showid = request.getParameter("showid");
		String slotno = request.getParameter("slotno");
		String date = 	 request.getParameter("date");
		String fromdate = request.getParameter("fromdate");
		String todate = request.getParameter("todate");
		String seattype =request.getParameter("seattype");
		String seatcount =request.getParameter("seatcount");
		
	
		SimpleDateFormat s = new SimpleDateFormat("yyyy-mm-dd");
		Date d = null,f=null,t=null;
		try {
			d = s.parse(date);
			f = s.parse(fromdate);
			t = s.parse(todate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(d.before(f) || d.after(t))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errormsg", "No  Shows Available for given Date!!!");
			dispatcher.forward(request, response);
		}
		
		Users u = (Users) session.getAttribute("user");
		BookingDAO b = new BookingDAO();
		b.addBooking(showid,u.getUserId(),new Date(),date,seattype,seatcount);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
		request.setAttribute("msg", "Your Show is bookes Seccessfully!!!");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
