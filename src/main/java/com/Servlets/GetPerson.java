package com.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.Dao.PersonDao;
import com.hospital.dto.Person;

@WebServlet("/getperson")
public class GetPerson extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		int id=(Integer)session.getAttribute("P_id");
		PersonDao dao=new PersonDao();
		Person person=dao.getById(id);
		System.out.println(person.getId());
		req.setAttribute("Person", person);
		RequestDispatcher dispatcher=req.getRequestDispatcher("display_userperson.jsp");
		dispatcher.forward(req, resp);
		 
	}

}
