package com.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.Dao.HospitalDao;
import com.hospital.Dao.ItemDao;
import com.hospital.dto.Hospital;
import com.hospital.dto.Item;

@WebServlet("/getitem")
public class GetItem extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mid=req.getParameter("id");
		ItemDao dao=new ItemDao();
		List<Item> list=dao.getAll();
		req.setAttribute("list", list);
		RequestDispatcher dispatcher=req.getRequestDispatcher("display_item.jsp");
		dispatcher.forward(req, resp);
	}

}
