package com.nt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.EmpDao;
import com.nt.entity.Employee;

public class RegisterSevlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		//read the form details
		int id = Integer.parseInt( req.getParameter( "t1" ) );
		String name = req.getParameter( "t2" );
		int age = Integer.parseInt( req.getParameter( "t3" ) );

		Employee e = new Employee( id, name, age );

		EmpDao dao = new EmpDao();
		boolean isAdded = dao.register( e );

		if ( isAdded ) {
			//valid
			req.setAttribute( "msg", "Register success" );
			RequestDispatcher rd = req.getRequestDispatcher( "success.jsp" );
			rd.forward( req, res );
		} else {
			//invalid
			req.setAttribute( "errorMsg", "unable to register" );
			RequestDispatcher rd = req.getRequestDispatcher( "error.jsp" );
			rd.forward( req, res );
		}
	}
}
