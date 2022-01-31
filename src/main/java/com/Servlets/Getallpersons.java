package com.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.Dao.PersonDao;
import com.hospital.dto.Person;

@WebServlet("/displayperson")
public class Getallpersons extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonDao dao=new PersonDao();
		
		List<Person> persons=dao.getAll();
		System.out.println(persons);
		req.setAttribute("persons", persons);
		RequestDispatcher dispatcher=req.getRequestDispatcher("display_person.jsp");
		dispatcher.forward(req, resp);
	}
}
