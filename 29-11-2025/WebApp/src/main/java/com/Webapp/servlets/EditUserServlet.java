@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        User u = UserDao.getUserById(id);
        request.setAttribute("user", u);
        request.getRequestDispatcher("edituser.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        User u = new User();
        u.setId(Integer.parseInt(request.getParameter("id")));
        u.setName(request.getParameter("name"));
        u.setPassword(request.getParameter("password"));

        UserDao.update(u);
        response.sendRedirect("viewUsers");
    }
}

