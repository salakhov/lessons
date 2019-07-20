<%@tag description="Main layout" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@attribute name="header" fragment="true" required="false" %>
<html>
<head>
    <!-- Спросить почему не работает -->
    <!--link rel="stylesheet" href="res/css/bootstrap.min.css"-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<script src="res/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="res/js/jquery-1.10.1.js"></script>
<script src="res/js/bootstrap.min.js"></script>

<div class="container">
    <jsp:invoke fragment="header"/>
    <jsp:doBody/>
</div>
</body>
</html>