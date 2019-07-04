<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/date.tld" prefix="datetag" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<myTags:template>
    <jsp:attribute name="header">
        <h1>Students</h1>
        (<datetag:DateTag plus="1"/>)
    </jsp:attribute>
    <jsp:body>
        <ul>
            <form method="post" action="${pageContext.request.contextPath}/auth" autocomplete="off">
                <li><input type="user" name="user" class="form-control" id="user" placeholder="user"> </li>
                <li><input type="password" name="password" class="form-control" id="password" placeholder="password"> </li>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>


        </ul>
    </jsp:body>
</myTags:template>