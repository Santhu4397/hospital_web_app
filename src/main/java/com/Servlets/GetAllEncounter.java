package com.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.Dao.EncounterDao;
import com.hospital.dto.Encounter;

@WebServlet("/getallencounter")
public class GetAllEncounter extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EncounterDao dao=new EncounterDao();
		String id=req.getParameter("id");
		List<Encounter> list=dao.getBypersonId(Integer.parseInt(id));
		req.setAttribute("list", list);
		RequestDispatcher dispatcher=req.getRequestDispatcher("display_encounter.jsp");
		dispatcher.forward(req, resp);
	}

}
