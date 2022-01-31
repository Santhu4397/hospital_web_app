 package com.Servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.Dao.EncounterDao;
import com.hospital.dto.Encounter;

@WebServlet("/createencounter")
public class CreateEncounter extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		int bid = (Integer) httpSession.getAttribute("B_id");
		System.out.println(bid);
		String name = (String) httpSession.getAttribute("name");
		String message = req.getParameter("message");
		String date = req.getParameter("date");
		LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
		
		int pid = Integer.parseInt(req.getParameter("p_id"));
		System.out.println(pid);

		Encounter encounter = new Encounter();
		encounter.setCreatorName(name);
		encounter.setReason(message);
		encounter.setCreatedDateTime(dateTime);
		EncounterDao dao = new EncounterDao();
		boolean t=dao.save(pid, bid, encounter);
		System.out.println(t);
		RequestDispatcher dispatcher=req.getRequestDispatcher("staff_home.jsp");
		dispatcher.forward(req, resp);
	}

}
