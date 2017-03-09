<%-- 
    Document   : viewinteractions
    Created on : Feb 1, 2017, 10:26:41 PM
    Author     : calho
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Interactions</b></h5>
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

      <th>Interaction ID</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Status</th>
      <th>Method Of Contact</th>
      <th>Email</th>
      <th>Phone</th>
      <th>Notes</th>
      <th>Contact Date</th>
      <th>Client ID</th>
      <th>Action</th>
    </tr>  

    <c:forEach var="interactions" items="${list}">   
      <tr>  
        <td>${interactions.interaction_id}</td>
        <td>${interactions.first_name}</td>
        <td>${interactions.last_name}</td>
        <td>${interactions.status}</td>
        <td>${interactions.method_of_contact}</td>
        <td>${interactions.email}</td>
        <td>${interactions.phone}</td>
        <td>${interactions.notes}</td>
        <td>${interactions.client_id}</td>
        <td>
          <a href="<c:url value="/interactions/editinteractions/${interactions.interaction_id}" />"><button class="w3-btn w3-round w3-blue">Edit</button></a>
          <a href="<c:url value="/interactions/deleteinteractions/${interactions.interaction_id}" />"><button class="w3-btn w3-round w3-red">Delete</button></a>
        </td>  
      </tr>  
    </c:forEach>  
  </table> 

  <div class="w3-padding-8">
    <ul class="w3-pagination">
      <c:forEach begin="1" end="${pages}" varStatus="p">  
        <li><a class="<c:if test="${p.index eq page}">w3-green</c:if>" href="<c:url value="/interactions/viewinteractions/${p.index}" />">${p.index}</a></li>
      </c:forEach>
    </ul>
  </div>
    
  </div>

<%@ include file="theme/footer.jsp" %>