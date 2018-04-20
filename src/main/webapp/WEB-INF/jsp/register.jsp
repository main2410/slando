<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Slando"/>
</jsp:include>

<form action='/register' method='POST'>
    Input login: <input name='login'/><br/>
    Input pass: <input type='password' name='pass1'/><br/>
    Confirm pass: <input type='password' name='pass2'/><br/>
    Input phone: <input name='phone'/><br/>
    Input email: <input name='email'/><br/>
    Input city: <input name='city'/><br/>
    <input type='submit' value='Register'/>
</form>


<jsp:include page="footer.jsp">
    <jsp:param name="counter" value="${counter}"></jsp:param>
</jsp:include>