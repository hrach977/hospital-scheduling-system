<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>Please create account</title>
</head>

<body>
<form:form method="POST" action="/signUp" modelAttribute="patientForm">

<font color="red">${errorMessage}</font>
<td><springForm:errors path=""/></td>
<form method="post">

    <spring:bind path="username">
    Username : <input type="text" name="username"/>
    <font color="red">
        <td><springForm:errors path="username"/></td>
    </font>

        <%--<p th:each="error: ${fields.errors('username')}"--%>
        <%--th:text="${error}">Validation error</p>--%>
        <%--<form:errors path="username"></form:errors>--%>
    </spring:bind>

    <spring:bind path="firstName">
    FirstName : <input type="text" name="firstName"/>
    <font color="red">
        <td><springForm:errors path="firstName"/></td>
    </font>

        <%--<p th:each="error: ${fields.errors('firstName')}"--%>
        <%--th:text="${error}">Validation error</p>--%>
        <%--<form:errors path="firstName"></form:errors>--%>
    </spring:bind>

    <spring:bind path="lastName">
    LastName : <input type="text" name="lastName"/>
    <font color="red">
        <td><springForm:errors path="lastName"/></td>
    </font>

        <%--<p th:each="error: ${fields.errors('lastName')}"--%>
        <%--th:text="${error}">Validation error</p>--%>
        <%--<form:errors path="lastName"></form:errors>--%>
    </spring:bind>

    <spring:bind path="password">
    Password : <input type="password" name="password"/>
    <font color="red">
        <td><springForm:errors path="password"/></td>
    </font>

        <%--<p th:each="error: ${fields.errors('password')}"--%>
        <%--th:text="${error}">Validation error</p>--%>
        <%--<form:errors path="password"></form:errors>--%>
    </spring:bind>

    <spring:bind path="passwordConfirmation">
    PasswordConfirmation : <input type="password" name="passwordConfirmation"/>
    <font color="red">
        <td><springForm:errors path="passwordConfirmation"/></td>
    </font>

        <%--<p th:each="error: ${fields.errors('passwordConfirmation')}"--%>
        <%--th:text="${error}">Validation error</p>--%>
        <%--<form:errors path="passwordConfirmation"></form:errors>--%>
    </spring:bind>

    <spring:bind path="email">
    Email : <input type="text" name="email"/>
    <font color="red">
        <td><springForm:errors path="email"/></td>
    </font>

        <%--<p th:each="error: ${fields.errors('email')}"--%>
        <%--th:text="${error}">Validation error</p>--%>
        <%--<form:errors path="email"></form:errors>--%>
    </spring:bind>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>

    </form:form>
</body>
</html>