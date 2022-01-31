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
import com.hospital.Dao.MedOrderdao;
import com.hospital.dto.Encounter;
import com.hospital.dto.MedOrder;

@WebServlet("/createorder")
public class CreateOrder extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MedOrderdao medOrderdao=new MedOrderdao();
		MedOrder order=new MedOrder();
		HttpSession httpSession = req.getSession();
		String name = (String) httpSession.getAttribute("name");
		String message = req.getParameter("message");
	
		int Eid = Integer.parseInt(req.getParameter("id"));
		String date = req.getParameter("date");
		LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
		order.setMessage(message);
		order.setCreatedDateTime(dateTime);
		order.setCreatorName(name);
		medOrderdao.save(Eid, order);
		RequestDispatcher dispatcher=req.getRequestDispatcher("staff_home.jsp");
		dispatcher.forward(req, resp);
		

	}

}
