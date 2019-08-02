<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>



<myTags:template>
    <jsp:attribute name="header">
        <h1>Уведомления JKX</h1>
    </jsp:attribute>
    <jsp:body>
        <table class = "table" >
            <thead>
            <tr>
                <th>HOME</th>
                <th>message</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="message" items="${messages}">
                <tr>
                    <td scope="row">${message.home}</td>
                    <td scope="row">${message.content}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
        <a href="/lesson27_war">Main page</a>
    </jsp:body>
</myTags:template>
