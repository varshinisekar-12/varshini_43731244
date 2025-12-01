<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Register</title>

<style>
<style>
body {
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg, #a1c4fd, #c2e9fb);
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

.card {
    background: white;
    padding: 30px 40px;
    width: 340px;
    border-radius: 20px;
    box-shadow: 0px 5px 20px rgba(0,0,0,0.2);
    text-align: center;
}

.card h2 {
    margin-bottom: 20px;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px;
    margin: 8px 0;
    border: 1px solid #ddd;
    border-radius: 10px;
    font-size: 15px;
}

button, input[type=submit] {
    width: 100%;
    padding: 12px;
    margin-top: 15px;
    background: #4a90e2;
    color: white;
    border: none;
    border-radius: 10px;
    font-size: 16px;
    cursor: pointer;
    transition: 0.3s ease;
}

button:hover, input[type=submit]:hover {
    background: #357ABD;
}

a {
    display: block;
    margin-top: 15px;
    text-decoration: none;
    color: #4a90e2;
}
a:hover {
    text-decoration: underline;
}
</style>

</style>

</head>
<body>

<div class="card">
    <h2>Register</h2>

<form method="post" action="registration.jsp">

    <input type="text" name="fname" placeholder="First Name">
    <input type="text" name="lname" placeholder="Last Name">
    <input type="text" name="email" placeholder="Email">
    <input type="text" name="uname" placeholder="Username">
    <input type="password" name="pass" placeholder="Password">

    <!-- Confirm password field shows as a separate box -->
    <input type="password" name="cpass" placeholder="Confirm Password">

    <input type="submit" value="Create Account">

</form>

</div>

</body>
</html>


