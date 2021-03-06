<%-- 
    Document   : viewclients
    Created on : Feb 1, 2017, 10:26:26 PM
    Author     : calho
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ include file="theme/header.jsp" %>

  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Clients</b></h5>
  </header>

  <div class="w3-row-padding w3-margin-bottom">
    
  <c:if test="${not empty message}">
    <c:choose>
      <c:when test="${message.type eq 'SUCCESS'}">
        <div class="w3-panel w3-border w3-pale-yellow w3-border-yellow"><p>${message.message}</p></div>
      </c:when>
      <c:when test="${message.type eq 'ERROR'}">
        <div class="w3-panel w3-border w3-pale-red w3-border-red"><p>${message.message}</p></div>
      </c:when>
    </c:choose>
    
  </c:if>

  <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">  
    <tr>
      <th>Client ID</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Address 1</th>
      <th>Address 2</th>
      <th>Address 3</th>
      <th>City</th>
      <th>State</th>
      <th>Zip</th>
      <th>Phone</th>
      <th>Fax</th>
      <th>Email</th>
      <th>Date Of Hire</th>
      <th>File Number</th>
      <th>Status</th>      

    </tr>  

    <c:forEach var="clients" items="${list}">   
      <tr>
        <td>${clients.client_id}</td>
        <td>${clients.first_name}</td>
        <td>${clients.last_name}</td>
        <td>${clients.address_1}</td>
        <td>${clients.address_2}</td>
        <td>${clients.address_3}</td>
        <td>${clients.city}</td>
        <td>${clients.state}</td>
        <td>${clients.zip}</td>
        <td>${clients.phone}</td>
        <td>${clients.fax}</td>
        <td>${clients.email}</td>
        <td>${clients.date_of_hire}</td>
        <td>${clients.file_number}</td>
        <td>${clients.status}</td>   
        <td>
          <a href="<c:url value="/clients/editclients/${clients.client_id}" />"><button class="w3-btn w3-round w3-blue">Edit</button></a>
          <a href="<c:url value="/clients/deleteclients/${clients.client_id}" />"><button class="w3-btn w3-round w3-red" onclick="return confirm('Are you sure you want to delete this user/client/interaction?');">Delete</button></a>
          <%--  <a href="<c:url value="/clients/interactionsform/${interactions.interaction_id}"/>"><button class="w3-btn w3-round w3-green">Add Interaction</button></a> --%>
        </td>  
      </tr>  
    </c:forEach>  
  </table> 

  <div class="w3-padding-8">
    <ul class="w3-pagination">
      <c:forEach begin="1" end="${pages}" varStatus="p">  
        <li><a class="<c:if test="${p.index eq page}">w3-green</c:if>" href="<c:url value="/clients/viewclients/${p.index}" />">${p.index}</a></li>
      </c:forEach>
    </ul>
  </div>
    
  </div>

<%@ include file="theme/footer.jsp" %>