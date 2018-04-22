<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>${param.title}</title>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
    </head>
    <body style="font-family: arial;">
        <div class="header_top"
             style="display: flex;justify-content: space-between; padding-left: 50px; border-bottom:1.5px solid #d7d4d4;">
            <div>
                <a href="/">
                    <img class="logo"
                         src="http://i.piccy.info/i9/e1f7d32a0726d078973c80f1fe8de0dc/1524063572/30517/1238229/Logo_Slando.jpg"
                         height="90px">
                </a>
            </div>
            <div class="isLogin" style="display: flex; justify-content: space-between;">
                <c:if test="${user != null}">
                    <div class="myProfile" style="padding-top: 25px;">
                        <a href="/" style="text-decoration: none;">
                            <img src="http://i.piccy.info/i9/f1b1569fe688b700a48766884c430bb0/1524063907/6574/1238229/customer_256.png"
                                 height="40px">
                            <span class="profile" style="position: relative;bottom: 15px; ">
                                My profile
                            </span>
                        </a>
                    </div>
                    <div class="add" style="height: 50px;
                         margin-top: 20px;
                         margin-left: 50px;
                         background-color: #ff8300; 
                         color: white;
                         padding: 0 10px;
                         border-radius: 15px;">
                        <a href="/additem" style="text-decoration: none;">
                            <span class="addText" style="color: white; position: relative;top: 15px;">
                                ADD ITEM</span>
                        </a>
                    </div>
                    <div style="height: 50px;
                         margin-top: 20px;
                         margin-left: 30px;
                         background-color: #ff8300;
                         color: white;
                         padding: 0 10px;
                         border-radius: 15px;">
                        <a href="/main?exit=true" style="text-decoration: none;">
                            <span class="addText" style="color: white; position: relative;top: 15px; ">EXIT</span>
                        </a>
                    </div>
                </c:if>
                <c:if test="${user == null}">
                    <div class="addOrSignIn" style="height: 40px;
                         margin-top: 20px;
                         margin-left: 50px;
                         background-color: #ff8300;
                         color: white;
                         padding: 0 10px;
                         border-radius: 15px;">
                        <a href="/register" style="text-decoration: none;">
                            <span class="addText" style="color: white; position: relative;top: 12px; ">SIGN UP</span>
                        </a>
                    </div>
                    <div class="addOrSignIn" style="height: 40px;
                         margin-top: 20px;
                         margin-left: 30px;
                         background-color: #ff8300;
                         color: white;
                         padding: 0 10px;
                         border-radius: 15px;">
                        <a href="/login" style="text-decoration: none;">
                            <span class="addText" style="color: white; position: relative;top: 12px; ">SIGN IN</span>
                        </a>
                    </div>

                </c:if>

            </div>

        </div>
