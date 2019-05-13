<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 13.05.2019
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Schedule</title>
</head>
    <body>
        <center>
            <h2>Your schedule</h2>
            <table border="1px">
                <tr>
                    <td>Time</td>
                    <td>Activity</td>
                </tr>
                <c:forEach var="activity" items="${activities}">
                    <tr>
                        <td><c:out value="${activity.key}"/> </td>
                        <td><c:out value="${activity.value}"/> </td>
                    </tr>
                </c:forEach>
            </table>
        </center>
    </body>
</html>
