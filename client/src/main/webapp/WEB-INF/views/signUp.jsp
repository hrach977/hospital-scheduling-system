<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>Please create account</title>
</head>

<body>
<form:form method="POST" action="/signUp" modelAttribute="patientForm">

<font color="red">${errorMessage}</font>
<form method="post">

    <spring:bind path="username">
    Username : <input type="text" name="username"/>
        <form:errors path="username"></form:errors>
    </spring:bind>

    <spring:bind path="firstName">
    FirstName : <input type="text" name="firstName"/>
        <form:errors path="firstName"></form:errors>
    </spring:bind>

    <spring:bind path="lastName">
    LastName : <input type="text" name="lastName"/>
        <form:errors path="lastName"></form:errors>
    </spring:bind>

    <spring:bind path="password">
    Password : <input type="password" name="password"/>
        <form:errors path="password"></form:errors>
    </spring:bind>

    <spring:bind path="passwordConfirmation">
    PasswordConfirmation : <input type="password" name="passwordConfirmation"/>
        <form:errors path="passwordConfirmation"></form:errors>
    </spring:bind>

    <spring:bind path="email">
    Email : <input type="text" name="email"/>
        <form:errors path="email"></form:errors>
    </spring:bind>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>

    </form:form>
</body>
</html>