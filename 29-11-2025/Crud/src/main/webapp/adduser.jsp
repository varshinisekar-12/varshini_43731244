<%@ page import="com.javatpoint.dao.UserDao" %>
<%@ page import="com.javatpoint.bean.User" %>

<jsp:useBean id="u" class="com.javatpoint.bean.User" />
<jsp:setProperty property="*" name="u" />

<%
int status = UserDao.save(u);
if(status > 0){
    out.println("User saved successfully! <a href='viewusers.jsp'>View Users</a>");
}else{
    out.println("Error saving user.");
}
%>
