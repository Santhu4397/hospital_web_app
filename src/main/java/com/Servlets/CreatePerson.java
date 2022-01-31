package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.Dao.PersonDao;
import com.hospital.dto.Person;

@WebServlet("/createperson")
public class CreatePerson extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			PersonDao dao=new PersonDao();
			Person person=new Person();
			String name=req.getParameter("U_name");
			String email=req.getParameter("U_email");
			String phone=req.getParameter("U-number");
			String age=req.getParameter("U_age");
			String gender=req.getParameter("gender");
			person.setName(name);
			person.setEmail(email);
			person.setGender(gender);
			person.setPhone(Integer.parseInt(phone));
			person.setAge(Integer.parseInt(age));
			dao.save(person);
			PrintWriter printWriter=resp.getWriter();
			printWriter.print("person added");
			RequestDispatcher dispatcher=req.getRequestDispatcher("create_person.jsp");
			dispatcher.forward(req, resp);
	}

}
