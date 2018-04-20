<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Slando"/>
</jsp:include>

<form action='/register' method='POST'>
    Input login: <input required name='login'/><br/>
    Input pass: <input required type='password' name='pass1'/><br/>
    Confirm pass: <input required type='password' name='pass2'/><br/>
    Input phone: <input required name='phone'/><br/>
    Input email: <input required name='email'/><br/>
    Input city: <input required name='city'/><br/>
    <input type='submit' value='Register'/>
</form>


<jsp:include page="footer.jsp">
    <jsp:param name="counter" value="${counter}"></jsp:param>
</jsp:include>