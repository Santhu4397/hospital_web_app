package com.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.Dao.UserDao;
import com.hospital.dto.User;
@WebServlet("/createuser")
public class CreateUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao dao=new UserDao();
		User user=new User();
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String password =req.getParameter("password");
		String role=req.getParameter("role");
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(Integer.parseInt(phone));
		user.setRole(role);
		dao.save(23, user);
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
	}

}
