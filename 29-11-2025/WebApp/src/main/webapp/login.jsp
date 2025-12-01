<%@ page import="java.sql.*" %>
<%
String userid = request.getParameter("uname");
String pwd = request.getParameter("pass");

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
	    "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
	    "root", "varshini@2005"
	);

PreparedStatement ps = con.prepareStatement(
    "SELECT * FROM members WHERE uname=? AND pass=?"
);

ps.setString(1, userid);
ps.setString(2, pwd);

ResultSet rs = ps.executeQuery();

if (rs.next()) {
    session.setAttribute("userid", userid);
    response.sendRedirect("success.jsp");
} else {
    out.print("Invalid login. <a href='index.jsp'>Try again</a>");
}
%>
