<%@ page import="java.util.List" %>
<%@ page import="com.javatpoint.dao.UserDao" %>
<%@ page import="com.javatpoint.bean.User" %>

<h1>Users List</h1>

<table border="1">
<tr><th>ID</th><th>Name</th><th>Email</th><th>Sex</th><th>Country</th><th>Edit</th><th>Delete</th></tr>

<%
List<User> list = UserDao.getAllRecords();
for(User u : list){
%>
<tr>
<td><%=u.getId()%></td>
<td><%=u.getName()%></td>
<td><%=u.getEmail()%></td>
<td><%=u.getSex()%></td>
<td><%=u.getCountry()%></td>
<td><a href="editform.jsp?id=<%=u.getId()%>">Edit</a></td>
<td><a href="deleteuser.jsp?id=<%=u.getId()%>">Delete</a></td>
</tr>
<%
}
%>
</table>
