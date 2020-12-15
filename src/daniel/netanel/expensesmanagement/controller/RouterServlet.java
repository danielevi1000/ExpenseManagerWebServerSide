package daniel.netanel.expensesmanagement.controller;

import daniel.netanel.expensesmanagement.MovementPlatformException;
import daniel.netanel.expensesmanagement.model.Movement;
import daniel.netanel.expensesmanagement.model.MovementDAO;
import daniel.netanel.expensesmanagement.model.UserDao;
import daniel.netanel.expensesmanagement.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This Servlet acts as a page controller for the application, handling all
 * requests from the user.
 * 
 */

@WebServlet("/")
public class RouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovementDAO movementDAO;
	private UserDao userDao;

	/**
	 * Initializing the movementDAO and userDao
	 */
	public void init() {
		movementDAO = new MovementDAO();
		userDao = new UserDao();
	}

	/**
	 * This is a selector of the operations
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				addMovement(request, response);
				break;
			case "/delete":
				deleteMovement(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateMovement(request, response);
				break;
			case "/Summary":
				movementsByMonth(request, response);
				break;
			case "/register":
				register(request, response);
				break;
			case "/login":
				try {
					authenticate(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "/logout":
				logout(request, response);
				break;
			default:
				getAllMovements(request, response);
				break;
			}
		} catch (SQLException | MovementPlatformException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * Get all the Movements
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 * @throws MovementPlatformException
	 */
	private void getAllMovements(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, MovementPlatformException {
		List<Movement> movementsList = new MovementDAO().getAllMovements();
		request.setAttribute("movementsList", movementsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("movements_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Show a new form
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("movement_form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Show edit form
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 * @throws MovementPlatformException
	 */
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, MovementPlatformException {
		int id = Integer.parseInt(request.getParameter("id"));
		Movement existingMovement = movementDAO.getMovement(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("movement_form.jsp");
		request.setAttribute("movement", existingMovement);
		dispatcher.forward(request, response);
	}

	/**
	 * Add a new Movement
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws MovementPlatformException
	 */
	private void addMovement(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, MovementPlatformException {
		String type = request.getParameter("type");
		String category = request.getParameter("category");
		String details = request.getParameter("details");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String month = request.getParameter("month");
		Movement expense = new Movement(type, category, details, amount, month);
		movementDAO.addMovement(expense);
		response.sendRedirect("list");
	}

	/**
	 * Update an Movement
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws MovementPlatformException
	 */
	private void updateMovement(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, MovementPlatformException {
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		String category = request.getParameter("category");
		String details = request.getParameter("details");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String month = request.getParameter("month");
		Movement movement = new Movement(id, type, category, details, amount, month);
		movementDAO.updateMovement(movement);
		response.sendRedirect("list");
	}

	/**
	 * Delete an Movement
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws MovementPlatformException
	 */
	private void deleteMovement(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, MovementPlatformException {
		int id = Integer.parseInt(request.getParameter("id"));
		movementDAO.deleteMovement(id);
		response.sendRedirect("list");
	}

	/**
	 * Get all Movements by month
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 * @throws MovementPlatformException
	 */
	private void movementsByMonth(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, MovementPlatformException {
		String month = request.getParameter("month");
		List<Movement> movementsList = new MovementDAO().movementsByMonth(month);
		request.setAttribute("movementsList", movementsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("monthly_movements.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Register a new User
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * @throws MovementPlatformException
	 */
	private void register(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, MovementPlatformException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(username);
		user.setPassword(password);

		if (UserDao.saveUser(user)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("register_success.jsp");
			dispatcher.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Username already exist!');");
			out.println("location='register.jsp';");
			out.println("</script>");
		}
	}

	/**
	 * Validate user name and password of the USer
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 * @throws MovementPlatformException
	 */
	private void authenticate(HttpServletRequest request, HttpServletResponse response)
			throws Exception, MovementPlatformException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (UserDao.validate(username, password)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login_success.jsp");
			dispatcher.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User or Password incorrect!');");
			out.println("location='login.jsp';");
			out.println("</script>");
		}
	}

	/**
	 * Log out
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws MovementPlatformException
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, MovementPlatformException {
		request.getSession().invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("logout_success.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}
}