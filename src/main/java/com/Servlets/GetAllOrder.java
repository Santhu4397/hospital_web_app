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
import com.hospital.Dao.MedOrderdao;
import com.hospital.dto.Encounter;
import com.hospital.dto.MedOrder;

@WebServlet("/getallorders")
public class GetAllOrder extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		MedOrderdao dao=new MedOrderdao();
		List<MedOrder> list=dao.getByencounterid(Integer.parseInt(id));
		req.setAttribute("list", list);
		RequestDispatcher dispatcher=req.getRequestDispatcher("display_order.jsp");
		dispatcher.forward(req, resp);
	}

}
