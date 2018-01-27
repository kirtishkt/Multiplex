package multiplex.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import multiplex.dao.UserDAO;
import multiplex.model.Users;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = (String) request.getParameter("user");
		String pass = (String) request.getParameter("pass");

		UserDAO u = new UserDAO();
		Users user = u.getUser(username, pass);

		if (user.getUserId() == (int) Integer.parseInt(pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.setAttribute("msg", "Login Successfully!!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("errormsg", "Invalid Credentials");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}

	}

}
