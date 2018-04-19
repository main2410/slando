<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Slando"/>
</jsp:include>

<form action="/login" method="POST">
    <b>Name:</b><input type="text" name="login"><br>
    <b>Password:</b><input type="password" name="pass"><br>
    <input type="submit" value="Register">
</form>

<jsp:include page="footer.jsp">
    <jsp:param name="counter" value="${counter}"></jsp:param>
</jsp:include>