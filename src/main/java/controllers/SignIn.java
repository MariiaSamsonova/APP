package controllers;

import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		
//		request.setAttribute("user", user);
		
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MainPage.jsp");

		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}


		if(request.getParameter("submit").equals("CreateAccount"))//registration
		{
			response.getWriter().append("create for ");

			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));
			user.setBirthday(request.getParameter("birthday"));
			user.setPhoneNumber(request.getParameter("phoneNumber"));
			response.getWriter().append(user.toString());
			user.registration();
			response.getWriter().append("created");
		}
		else if(request.getParameter("submit").equals("SignIn"))//SignIn
		{
			response.getWriter().append("authentication");

			String rightPassword = user.authentication();
			response.getWriter().append("Right password: " + rightPassword + ".");

			if(!user.getPassword().equals(rightPassword))
			{
				response.getWriter().append("authentication failed");

//				dispatcher = getServletContext().getRequestDispatcher("/SignIn.jsp");
			}

		}
//			dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
