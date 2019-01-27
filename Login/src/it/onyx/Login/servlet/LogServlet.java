package it.onyx.Login.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.onyx.Login.dao.UserDao;
import it.onyx.Login.util.Util;

/**
 * Servlet implementation class LogServlet
 */
@WebServlet("/LogServlet")
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
		
		String email, password, passwordError, userNotFound;
		
		email = request.getParameter("email");
		password = request.getParameter("password");
		passwordError = "wrong password, please try again";
		userNotFound = "user not found";
		
		UserDao ud = Util.login(email, password, this.getServletContext());
		
		if ( ud.getNome() != null) {
		
		request.setAttribute("firstName", ud.getNome());
		request.setAttribute("lastName", ud.getCognome());
		request.setAttribute("number", ud.getNum_telefono());
		request.setAttribute("email", ud.getEmail());
		request.setAttribute("password", ud.getPassword());
		request.setAttribute("id", ud.getId_cliente());
		
		request.getRequestDispatcher("JSP/home.jsp").forward(request, response);
		
		} else {
			
					if (Util.emailExist(email, this.getServletContext())) {
						request.setAttribute("errorMessage", passwordError);
						request.getRequestDispatcher("JSP/logging.jsp").forward(request, response);
					}else {
						request.setAttribute("errorMessage", userNotFound);
						request.getRequestDispatcher("JSP/logging.jsp").forward(request, response);
					}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
