<%
if(session.getAttribute("userid") == null){
%>
You are not logged in.
<a href="index.jsp">Login</a>
<%
} else {
%>
<html>
<head>
<style>
body {
    font-family: Arial;
    background: #dfe9f3;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}
.card {
    background: white;
    padding: 40px;
    border-radius: 20px;
    box-shadow: 0 5px 20px rgba(0,0,0,0.2);
    text-align: center;
}
a {
    display: block;
    margin-top: 15px;
    color: #e74c3c;
    text-decoration: none;
    font-weight: bold;
}
a:hover { text-decoration: underline; }
</style>
</head>

<body>
<div class="card">
<h2>Welcome, <%= session.getAttribute("userid") %> 👋</h2>
<a href="logout.jsp">Logout</a>
</div>
</body>
</html>

<%
}
%>

