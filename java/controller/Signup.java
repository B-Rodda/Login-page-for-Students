package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		// LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		long number = Long.parseLong(req.getParameter("number"));
		StudentDao dao = new StudentDao();
		Student s = new Student();
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		s.setAddress(address);
		// s.setDob(dob);
		s.setNumber(number);
		dao.addStudent(s);

		resp.getWriter().print("<h1 style='color: green;'> " + "Account created successfullyy" + "</h1>");

		
	}
}
