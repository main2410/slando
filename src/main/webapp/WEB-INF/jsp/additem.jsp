<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Slando"/>
</jsp:include>

<form action='/additem' method='POST'>

    Select category: <select required name='cat'>
    <option value="kitchen">Kitchen</option>
    <option value="bath">Bath</option>
    <option value="bedroom">Bedroom</option>
    <option value="outhouse">Outhouse</option>
</select></br>
    Input name: <input required name='name'/><br/>
    Input about: <input required name='about'/><br/>
    Input price: <input required name='price'/><br/>
    Picture url: <input required name='pic'/><br/>
    <input type='submit' value='Add'/>
</form>


<jsp:include page="footer.jsp">
    <jsp:param name="onlineCounter" value="${onlineCounter}"></jsp:param>
    <jsp:param name="loginedCounter" value="${loginedCounter}"></jsp:param>
</jsp:include>