package com.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.Dao.AddressDao;
import com.hospital.Dao.BranchDao;
import com.hospital.Dao.MedOrderdao;
import com.hospital.dto.Address;
import com.hospital.dto.Branch;
import com.hospital.dto.MedOrder;

@WebServlet("/getallbranch")
public class GetAllBranch extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		int B_id = 0;
		BranchDao dao=new BranchDao();
		List<Branch> list=dao.getByhospitalId(Integer.parseInt(id));
		req.setAttribute("list", list);
		for(Branch b:list) {
			B_id=b.getId();
		}
		AddressDao dao2=new AddressDao();
		List<Address> addresses=dao2.getAllUser();
		req.setAttribute("addresses", addresses);
		RequestDispatcher dispatcher=req.getRequestDispatcher("display_branch.jsp");
		dispatcher.forward(req, resp);
		
	}
}
