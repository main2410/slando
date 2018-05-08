<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Slando"/>
</jsp:include>

<form action='/profile' method='POST'>
    <br/>
    Hello, ${user.login}!
    <br/>
    <hr/>
    <table>
        <tr>
            <td>
                Input old pass:<br/>
                Input new pass:<br/>
                Confirm new pass:<br/>
            </td>
            <td>
                <input name='oldPass'/><br/>
                <input type='password' name='pass1'/><br/>
                <input type='password' name='pass2'/><br/>
            </td>
        </tr>
        <tr>
            <td>
                Input new phone:
            </td>
            <td>
                <input name='phone'/><br/>
            </td>
        </tr>
        <tr>
            <td>
                Input new email:
            </td>
            <td>
                <input name='email'/><br/>
            </td>
        </tr>
        <tr>
            <td>
                Input new city:
            </td>
            <td>
                <input name='city'/><br/>
            </td>
        </tr>
    </table>
    <input type='submit' value='Save changes'/>
</form>
<a href='/main?owner=${user.login}'>
    <input type='submit' value='My items'/>
</a>

<jsp:include page="footer.jsp">
    <jsp:param name="counter" value="${counter}"></jsp:param>
</jsp:include>