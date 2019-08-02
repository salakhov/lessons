<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
    private String str = "PageTitle: ";
    public String createTitle(String arg) {
        return str + arg;
    }
%>
<html>
<head>

</head>
<body>
<div class="container">
    <c:import url="${PageBody}"/>
</div>
</body>
</html>
