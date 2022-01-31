package com.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.Dao.BranchDao;
import com.hospital.dto.Address;
import com.hospital.dto.Branch;

@WebServlet("/createbranch")
public class CreateBranch extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Branch branch=new Branch();
		BranchDao branchDao=new BranchDao();
		String name=req.getParameter("b_name");
		String phone=req.getParameter("numb");
		String email=req.getParameter("email");
		String Hid=req.getParameter("H_id");
		req.getParameter(name);
		branch.setB_name(name);
		branch.setEmail(email);
		branch.setPhone(Integer.parseInt(phone));
		String add=req.getParameter("address");
		String state=req.getParameter("State");
		String pin=req.getParameter("pin");
		Address address=new Address();
		address.setAddress(add);
		address.setPin(Integer.parseInt(pin));
		address.setState(state);
		
		branchDao.save(Integer.parseInt(Hid), branch, address);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("admin_home.jsp");
		dispatcher.forward(req, resp);
	}

}
