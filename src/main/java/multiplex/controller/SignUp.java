package multiplex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import multiplex.dao.UserDAO;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String username = request.getParameter("user");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		if(username == null)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errormsg", "User Name can't be empty");
			dispatcher.forward(request, response);
		}
		if(!email.contains("@") || !email.contains("."))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errormsg", "Invalid Email ID");
			dispatcher.forward(request, response);
		}
		UserDAO u = new UserDAO();
		u.addUser(username,mobile,email);
		RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
		request.setAttribute("msg", "User Added Successfully!!!");
		dispatcher.forward(request, response);
		
	}

}
