<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Slando"/>
</jsp:include>

<p>
    <b>Login:</b><input type="text" size="40">
</p>
<p>
    <b>Password:</b><input type="text" size="40">
</p>
<p>
    <input type="submit" value="Submit">
</p>

<jsp:include page="footer.jsp">
    <jsp:param name="counter" value="${counter}"></jsp:param>
</jsp:include>