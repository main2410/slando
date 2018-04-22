<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Slando"/>
</jsp:include>

<form action='/additem' method='POST'>

    Select category: <select required name='cat'>
    <option value="Cat1">Cat1</option>
    <option value="Cat2">Cat2</option>
    <option value="Cat3">Cat3</option>
    <option value="Cat4">Cat4</option>
</select></br>
    Input name: <input required name='name'/><br/>
    Input about: <input required name='about'/><br/>
    Input price: <input required name='price'/><br/>
    Picture url: <input required name='pic'/><br/>
    <input type='submit' value='Add'/>
</form>


<jsp:include page="footer.jsp">
    <jsp:param name="counter" value="${counter}"></jsp:param>
</jsp:include>