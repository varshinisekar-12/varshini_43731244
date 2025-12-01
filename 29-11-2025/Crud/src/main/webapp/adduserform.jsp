<!DOCTYPE html>
<html>
<body>

<h1>Add User</h1>

<form action="adduser.jsp" method="post">
    Name: <input type="text" name="name" /><br><br>
    Password: <input type="password" name="password" /><br><br>
    Email: <input type="email" name="email" /><br><br>

    Sex:
    <input type="radio" name="sex" value="male" /> Male
    <input type="radio" name="sex" value="female" /> Female
    <br><br>

    Country:
    <select name="country">
        <option>India</option>
        <option>USA</option>
        <option>UK</option>
        <option>Canada</option>
    </select>
    <br><br>

    <input type="submit" value="Save User" />
</form>

</body>
</html>

