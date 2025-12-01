@WebServlet("/viewUsers")
public class ViewUsersServlet extends HttpServlet {
	rotected void doGet(HttpServletRequest request, HttpServletResponse response){
	        try {
	            List<User> list = UserDao.getAllUsers();
	            request.setAttribute("list", list);
	            request.getRequestDispatcher("viewusers.jsp").forward(request, response);
	        } catch(Exception e){ e.printStackTrace(); }
	    }
	}

