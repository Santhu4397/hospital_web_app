package com.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.Dao.ItemDao;
import com.hospital.dto.Item;

@WebServlet("/createitem")
public class CreateItem extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String message=req.getParameter("message");
		String cost=req.getParameter("cost");
		String qty=req.getParameter("qty");
		String mid=req.getParameter("id");
		Item item=new Item();
		item.setName(name);
		item.setQuantity(Integer.parseInt(qty));
		item.setMessage(message);
		item.setPrice(Double.parseDouble(cost));
		ItemDao dao=new ItemDao();
		dao.save(Integer.parseInt(mid), item);
		RequestDispatcher dispatcher=req.getRequestDispatcher("staff_home.jsp");
		dispatcher.forward(req, resp);
		
	}

}
