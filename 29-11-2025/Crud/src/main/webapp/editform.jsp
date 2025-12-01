<%@ page import="com.javatpoint.dao.UserDao" %>
<%@ page import="com.javatpoint.bean.User" %>

<%
int id = Integer.parseInt(request.getParameter("id"));
User u = UserDao.getRecordById(id);
%>

<h1>Edit User</h1>

<form action="edituser.jsp" method="post">

<input type="hidden" name="id" value="<%=u.getId()%>"/>


Name: <input type="text" name="name" value="<%=u.getName()%>" /><br><br>
Password: <input type="password" name="password" value="<%=u.getPassword()%>" /><br><br>
Email: <input type="email" name="email" value="<%=u.getEmail()%>" /><br><br>

Sex:
<input type="radio" name="sex" value="male" <%= u.getSex().equals("male") ? "checked" : "" %>> Male
<input type="radio" name="sex" value="female" <%= u.getSex().equals("female") ? "checked" : "" %>> Female
<br><br>

Country:
<select name="country">
    <option <%= u.getCountry().equals("India") ? "selected" : "" %> >India</option>
    <option <%= u.getCountry().equals("USA") ? "selected" : "" %> >USA</option>
    <option <%= u.getCountry().equals("UK") ? "selected" : "" %> >UK</option>
    <option <%= u.getCountry().equals("Canada") ? "selected" : "" %> >Canada</option>
</select>
<br><br>

<input type="submit" value="Update User" />

</form>
