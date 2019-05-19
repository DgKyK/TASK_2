<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 17.05.2019
  Time: 14:43
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
            <td>Start Time</td>
            <td>Name</td>
            <td>Duration</td>
            <td>Priority</td>
        </tr>
        <c:forEach var="activityList" items="${activities}">
            <tr>
                <c:forEach var="activity" items="${activityList}">
                    <tr>
                        <td><c:out value="${activity.startTime}"/> </td>
                        <td><c:out value="${activity.name}"/> </td>
                        <td><c:out value="${activity.duration}"/> </td>
                        <td><c:out value="${activity.priority}"/> </td>
                    </tr>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
