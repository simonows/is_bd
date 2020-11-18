<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/base.css" rel="stylesheet" type="text/css"/>
        <link href="css/news.css" rel="stylesheet" type="text/css"/>
        <title>Add new user</title>
    </head>
    <body>
        <form method="POST" action='UserController' name="frmAddUser">
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            <% if (action.equalsIgnoreCase("edit")) {%>
            User Name : <input type="text" name="uname"
                               value="<c:out value="${user.uname}" />" readonly="readonly"/> (Вы не можете это изменить)<br /> 
            <%} else {%>
            User Name : <input type="text" name="uname"
                               value="<c:out value="${user.uname}" />" /> <br />
            <%}%>
            Password : <input
                type="password" name="pass"
                value="<c:out value="${user.password}" />" /> <br /> 
 
            <input  type="submit" value="Submit" />
        </form>
    </body>
</html>