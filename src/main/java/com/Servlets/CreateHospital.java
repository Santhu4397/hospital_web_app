package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.Dao.HospitalDao;
import com.hospital.dto.Hospital;

@WebServlet("/createhospital")
public class CreateHospital extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HospitalDao dao=new HospitalDao();
			Hospital hospital=new Hospital();
			String name=req.getParameter("H_name");
			String web=req.getParameter("H_web");
			String gst=req.getParameter("H-number");
			
			hospital.setName(name);
			hospital.setWebsite(web);
			hospital.setGst(gst);
			dao.save(hospital);
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Hospital added");
		RequestDispatcher dispatcher=req.getRequestDispatcher("admin_home.jsp");
		dispatcher.forward(req, resp);
	}

}
