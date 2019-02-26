<html>

<head>
    <title>Hospital Registration</title>
</head>

<body>
<%--<h1>Register as a Hospital!</h1>--%>
<font color="red">${errorMessage}</font>
<form method="post">
    Name : <input type="text" name="name"/>
    Username : <input type="text" name="username"/>
    Password : <input type="password" name="password"/>
    Address : <input type="text" name="address"/>
    Email : <input type="email" name="email"/>
    Phone : <input type="tel" name="phone"/>
    <input type="submit"/>
</form>
</body>

</html>
