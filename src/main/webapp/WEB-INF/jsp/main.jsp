<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="user" value="${user}"/>
    <jsp:param name="title" value="Slando"/>
</jsp:include>

<c:forEach items="${items}" var="item">
    <div <c:if test="${item.isVip}">style="background-color: gold;"</c:if>>
        <a href='/item?id=${item.id}'>
            <h1 style="margin-top: 0px;text-align: center;"> ${item.name}</h1>
        </a>
        <div style=" display: flex; justify-content: space-around;">
            <div>
                <img src="${item.pic}" height="150">
            </div>
            <div>
                <span>Description:</span></br>
                <span>${item.about}</span></br>
            </div>
            <div>
                <p>Owner: ${item.owner}</p>
                <p>Phone: ${item.phone}</p>
                <p>Email: ${item.email}</p>
                <p>City: ${item.city}</p>
            </div>
        </div>
        <div style="display: flex; justify-content: space-around;">
            <span>Price: ${item.price} UAH</span>
            <span>Category: ${item.cat}</span>
            <span>Created: ${item.createDate}</span>
        </div>
        <c:if test="${item.owner == user.login && owner != null}">
            <a href='/edit?id=${item.id}'>
                <input type='submit' value='Edit item'/>
            </a>
        </c:if>
    </div>
    <hr/>
</c:forEach>

<jsp:include page="footer.jsp">
    <jsp:param name="onlineCounter" value="${onlineCounter}"></jsp:param>
    <jsp:param name="loginedCounter" value="${loginedCounter}"></jsp:param>
</jsp:include> 
