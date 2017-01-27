<%-- 
    Document   : 403page
    Created on : Jan 26, 2017, 6:26:41 PM
    Author     : calho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
  <h5><b><i class="fa fa-times"></i> HTTP Status 403 - Access is denied</b></h5>
</header>

<div class="w3-row-padding w3-margin-bottom">
  <div class="w3-panel w3-white">
			<h2>Your access level does not permit you to access this page.</h2>
  </div>
</div>

<%@ include file="theme/footer.jsp" %>