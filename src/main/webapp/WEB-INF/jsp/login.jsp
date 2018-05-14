<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Slando"/>
</jsp:include>

<form action="/login" method="POST">
    <b>Name:</b><input type="text" name="login"><br>
    <b>Password:</b><input type="password" name="pass"><br>
    <input type="submit" value="Login">
</form>

<jsp:include page="footer.jsp">
    <jsp:param name="onlineCounter" value="${onlineCounter}"></jsp:param>
    <jsp:param name="loginedCounter" value="${loginedCounter}"></jsp:param>
</jsp:include>