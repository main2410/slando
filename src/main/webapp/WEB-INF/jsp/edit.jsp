<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Slando"/>
</jsp:include>

<form action='/edit?id=${item.id}' method='POST'>
    Item category: <select name='cat' title="Select new Category">
    <option value="kitchen">Kitchen</option>
    <option value="bath">Bath</option>
    <option value="bedroom">Bedroom</option>
    <option value="outhouse">Outhouse</option>
</select><br/>
    Item name: <input name='name' value='${item.name}'/><br/>
    About: <input name='about' value='${item.about}'/><br/>
    Picture url: <input name='pic' value='${item.pic}'/><br/>
    Item price: <input name='price' value='${item.price}'/><br/>
    Make VIP <input type="checkbox" name='isVip'
<c:if test="${item.isVip}"> checked </c:if> value="true"><br>
    Set TOP <input type="checkbox" name='top' value="true"><br>
    <input type='submit' value='Save changes'/>
</form>
<form action='/edit?id=${item.id}&delete=true' method='POST'>
    <input type='submit' value='Delete item'/>
</form>

<jsp:include page="footer.jsp">
    <jsp:param name="onlineCounter" value="${onlineCounter}"></jsp:param>
    <jsp:param name="loginedCounter" value="${loginedCounter}"></jsp:param>
</jsp:include>