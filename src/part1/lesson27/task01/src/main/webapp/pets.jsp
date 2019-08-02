<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<myTags:template>
    <jsp:attribute name="header">
        <h1>Зарегистрированные домашние животные</h1>
    </jsp:attribute>
    <jsp:body>
    <table class = "table" >
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>master</th>
            <th>type</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="pets" items="${pets}">
            <tr>
                <td scope="row">${pets.id}</td>
                <td>${pets.name}</td>
                <td>${pets.master}</td>
                <td>${pets.type}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="/lesson27_war">Main page</a>
    </jsp:body>
</myTags:template>


