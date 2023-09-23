package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentDao;
import dto.Student;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		StudentDao dao = new StudentDao();
		Student w = dao.fetchAccount(email, password);
		if (w != null) {

			if (w.getPassword().equals(password)) {
				resp.getWriter().print("<h1 style='color: green;'> " + "login successfully" + "</h1>");
				RequestDispatcher d = req.getRequestDispatcher("home.html");

			} else {
				resp.getWriter().print("<h1 style='color: red;'> " + "invalid password" + "</h1>");
				RequestDispatcher d = req.getRequestDispatcher("login.html");

			}
		} else {
			resp.getWriter().print("<h1 style='color: red;'> " + "invalid email" + "</h1>");
		}
	}
}
