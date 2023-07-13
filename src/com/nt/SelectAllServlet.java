package com.nt;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.EmpDao;
import com.nt.entity.Employee;

public class SelectAllServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {

		EmpDao dao = new EmpDao();
		List<Employee> list = dao.allRecords();

		req.setAttribute( "emplist", list );
		RequestDispatcher rd = req.getRequestDispatcher( "displayAll.jsp" );
		rd.forward( req, res );
	}
}
