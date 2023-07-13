package com.nt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.EmpDao;

public class UpdateServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		int id = Integer.parseInt( req.getParameter( "id" ) );
		int age = Integer.parseInt( req.getParameter( "age" ) );

		EmpDao dao = new EmpDao();
		boolean isUpdated = dao.update( id, age );

		if ( isUpdated ) {
			//valid
			RequestDispatcher rd = req.getRequestDispatcher( "all" );
			rd.forward( req, res );
		} else {
			//invalid
			req.setAttribute( "errorMsg", "unable to update" );
			RequestDispatcher rd = req.getRequestDispatcher( "error.jsp" );
			rd.forward( req, res );
		}
		//		if ( isUpdated ) {
		//			//valid
		//			req.setAttribute( "msg", "Update success" );
		//			RequestDispatcher rd = req.getRequestDispatcher( "success.jsp" );
		//			rd.forward( req, res );
		//		} else {
		//			//invalid
		//			req.setAttribute( "errorMsg", "unable to update" );
		//			RequestDispatcher rd = req.getRequestDispatcher( "error.jsp" );
		//			rd.forward( req, res );
		//		}
	}
}
