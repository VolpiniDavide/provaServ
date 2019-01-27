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
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					System.out.println("get");
					
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String number = request.getParameter("number");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(firstName != null && lastName != null && number != null && email != null && password != null ) {
			if (firstName != "" && lastName != "" && number  != "" && email  != "" && password  != "") {
				UserDao ud =  new UserDao();
				
				ud.setEmail(email);
				ud.setPassword(password);
				ud.setCognome(lastName);
				ud.setNome(firstName);
				ud.setNum_telefono(number);
				
				if(Util.emailExist(email, this.getServletContext())){
							
					request.setAttribute("Message", "email already in use");
					request.getRequestDispatcher("JSP/registration.jsp").forward(request, response);
				}
				
				else if ( Util.create(ud, this.getServletContext())) {
					
					request.setAttribute("Message", "registration successful");
					request.getRequestDispatcher("JSP/registration.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("Message", "ALL FIELDS REQUIRED");
				request.getRequestDispatcher("JSP/registration.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("Message", "ALL FIELDS REQUIRED");
			request.getRequestDispatcher("JSP/registration.jsp").forward(request, response);
		}
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
