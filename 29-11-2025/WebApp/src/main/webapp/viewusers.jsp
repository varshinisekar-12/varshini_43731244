<%@ page import="java.util.*, com.WebApp.model.User" %>

<table border="1">
<tr>
    <th>ID</th><th>Name</th><th>Password</th>
    <th>Edit</th><th>Delete</th>
</tr>

<%
List<User> list = (List<User>) request.getAttribute("list");
for(User u : list){
%>
<tr>
<td><%= u.getId() %></td>
<td><%= u.getName() %></td>
<td><%= u.getPassword() %></td>
<td><a href="editUser?id=<%=u.getId()%>">Edit</a></td>
<td><a href="deleteUser?id=<%=u.getId()%>">Delete</a></td>
</tr>
<%
}
%>
</table>

<br>
<a href="addUser.jsp">Add New User</a>
