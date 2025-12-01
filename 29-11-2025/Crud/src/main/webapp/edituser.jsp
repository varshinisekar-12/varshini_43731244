<%@ page import="com.javatpoint.dao.UserDao" %>
<%@ page import="com.javatpoint.bean.User" %>

<jsp:useBean id="u" class="com.javatpoint.bean.User" />
<jsp:setProperty property="*" name="u" />

<%
int status = UserDao.update(u);
if(status > 0){
    response.sendRedirect("viewusers.jsp");
}else{
    out.println("Error updating user.");
}
%>

