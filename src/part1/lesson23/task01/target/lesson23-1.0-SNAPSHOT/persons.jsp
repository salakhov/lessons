<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<myTags:template>
    <jsp:attribute name="header">
        <h1>Зарегистрированные студенты</h1>
    </jsp:attribute>
    <jsp:body>
    <table class = "table" >
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Birthdate</th>
            <th>email</th>
            <th>phone</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="person" items="${persons}">
            <tr>
                <td scope="row">${person.id}</td>
                <td>${person.name}</td>
                <td>${person.birthDate}</td>
                <td>${person.email}</td>
                <td>${person.phone}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="/lesson23_war">Main page</a>
    </jsp:body>
</myTags:template>


