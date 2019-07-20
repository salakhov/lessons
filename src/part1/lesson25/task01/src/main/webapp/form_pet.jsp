<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="pet" class="ru.inno.stc14.entity.Pet" />
    <c:set target="${pet}" property="name" value="Anonim" />
    <jsp:setProperty name="pet" property="master" value="Vasya" />
    <jsp:setProperty name="pet" property="type" value="dog" />

<myTags:template>
<h1>Adding a new pet</h1>
<form method="post" action="${pageContext.request.contextPath}/pet" autocomplete="off">
    <div class="form-group">
        <label for="name">Name</label>
        <input name="name" type="text" class="form-control" id="name" value="<jsp:getProperty name="pet" property="name" />">
    </div>
    <div class="form-group">
        <label for="master">master</label>
        <input name="master" type="text" class="form-control" id="master" value="<jsp:getProperty name="pet" property="master" />">
    </div>
    <div class="form-group">
        <label for="type">type</label>
        <input name="type" type="text" class="form-control" id="type" value="<jsp:getProperty name="pet" property="type" />">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</myTags:template>
