<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Slando"/>
</jsp:include>

<form action='/edit?id=${item.id}' method='POST'>
    <table>
        <tr>
            <td>
                Item category:
            </td>
            <td>
                <select name='cat' value='${item.cat}'>
                    <option value="kitchen">Kitchen</option>
                    <option value="bath">Bath</option>
                    <option value="bedroom">Bedroom</option>
                    <option value="outhouse">Outhouse</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                Item name:
            </td>
            <td>
                <input name='name' value='${item.name}'/>
            </td>
        </tr>
        <tr>
            <td>
                About:
            </td>
            <td>
                <input name='about' value='${item.about}'/>
            </td>
        </tr>
        <tr>
            <td>
                Picture url:
            </td>
            <td>
                <input name='pic' value='${item.pic}'/>
            </td>
        </tr>
        <tr>
            <td>
                Item price:
            </td>
            <td>
                <input name='price' value='${item.price}'/>
            </td>
        </tr>
    </table>
    <input type='submit' value='Save changes'/>
</form>
<form action='/edit?id=${item.id}&delete=true' method='POST'>
    <input type='submit' value='Delete item'/>
</form>

<jsp:include page="footer.jsp">
    <jsp:param name="counter" value="${counter}"></jsp:param>
</jsp:include>