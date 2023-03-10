package controllers;

import models.User;

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
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
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

		response.getWriter().append("create for ");

		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setBirthday(request.getParameter("birthday"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		response.getWriter().append(user.toString());
		user.registration();
		response.getWriter().append(" created");

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
