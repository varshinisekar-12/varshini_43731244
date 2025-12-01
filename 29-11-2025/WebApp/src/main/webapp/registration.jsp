<%@ page import="java.sql.*" %>
<%
String user = request.getParameter("uname");
String pwd = request.getParameter("pass");
String cpass = request.getParameter("cpass");  // NEW
String fname = request.getParameter("fname");
String lname = request.getParameter("lname");
String email = request.getParameter("email");

// Check if passwords match
if (!pwd.equals(cpass)) {
    out.print("Passwords do not match! <a href='reg.jsp'>Try again</a>");
    return; // Stop execution
}

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC",
    "root", "varshini@2005"  // replace with your MySQL password
);

PreparedStatement ps = con.prepareStatement(
"INSERT INTO members(first_name,last_name,email,uname,pass,regdate) VALUES(?,?,?,?,?,CURDATE())");

ps.setString(1, fname);
ps.setString(2, lname);
ps.setString(3, email);
ps.setString(4, user);
ps.setString(5, pwd);

int i = ps.executeUpdate();

if(i > 0){
  response.sendRedirect("welcome.jsp");
} else {
  out.print("Error occurred");
}
%>

