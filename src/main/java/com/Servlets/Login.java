package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.Dao.UserDao;
import com.hospital.dto.User;

@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email =req.getParameter("uname");
		String psw=req.getParameter("psw");
		PrintWriter writer=resp.getWriter();
		UserDao dao=new UserDao();
		User user=dao.validate(email, psw);
		if(user != null) {
			
						HttpSession session=req.getSession();
						session.setAttribute("name", user.getName());
						session.setAttribute("role", user.getRole());
			if(user.getRole().equals("user")) {
				session.setAttribute("P_id", user.getId());
				RequestDispatcher dispatcher=req.getRequestDispatcher("user_home.jsp");
				dispatcher.forward(req, resp);
			}
			else if(user.getRole().equals("staff")){
				    session.setAttribute("B_id", user.getBranch().getId());
				RequestDispatcher dispatcher=req.getRequestDispatcher("staff_home.jsp");
				dispatcher.forward(req, resp);
			}
			else if(user.getRole().equals("admin")){
				RequestDispatcher dispatcher=req.getRequestDispatcher("admin_home.jsp");
				dispatcher.forward(req, resp);
			}
			
			
		}else {
			writer.print("invaled password or email");
		}
	}

	private void elseif(boolean equals) {
		// TODO Auto-generated method stub
		
	}

	private void elseif() {
		// TODO Auto-generated method stub
		
	}

}
