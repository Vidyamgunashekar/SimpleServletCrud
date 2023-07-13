package com.nt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.EmpDao;
import com.nt.entity.Employee;

public class SelectServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		int id = Integer.parseInt( req.getParameter( "id" ) );

		EmpDao dao = new EmpDao();
		Employee e = dao.selectById( id );

		req.setAttribute( "emp", e );

		RequestDispatcher rd = req.getRequestDispatcher( "display.jsp" );
		rd.forward( req, res );
	}
}
