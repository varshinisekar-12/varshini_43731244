package com.Webapp.servlets;

import com.WebApp.dao.UserDao;
import com.WebApp.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            String name = request.getParameter("name");
            String password = request.getParameter("password");

            User u = new User();
            u.setName(name);
            u.setPassword(password);

            UserDao.save(u);

            response.sendRedirect("viewUsers");
        } catch(Exception e){ e.printStackTrace(); }
    }
}

	