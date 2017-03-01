<%-- 
    Document   : viewprospects
    Created on : Feb 1, 2017, 10:26:56 PM
    Author     : calho
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Prospects</b></h5>
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
      <th>Title</th>
      <th>Prospect ID</th>
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
      <th>Email</th
      <th>Date Of Hire</th>
      <th>File Number</th>
      <th>Status</th>      
      <th>Action</th>
    </tr>  
<t
    <c:forEach var="prospects" items="${list}">   
      <tr>  
        <td>${prospects.title}</td>
        <td>${prospects.first_name}</td>
        <td>${prospects.last_name}</td>
        <td>${prospects.address_1}</td>
        <td>${prospects.address_2}</td>
        <td>${prospects.address_3}</td>
        <td>${prospects.city}</td>
        <td>${prospects.state}</td>
        <td>${prospects.zip}</td>
        <td>${prospects.phone}</td>
        <td>${prospects.fax}</td>
        <td>${prospects.email}</td>   
        <td>
          <a href="<c:url value="/prospects/editprospect/${prospect.prospect_id}" />"><button class="w3-btn w3-round w3-blue">Edit</button></a>
          <a href="<c:url value="/prospects/deleteprospect/${prospect.prospect_id}" />"><button class="w3-btn w3-round w3-red">Delete</button></a>
        </td>  
      </tr>  
    </c:forEach>  
  </table> 

  <div class="w3-padding-8">
    <ul class="w3-pagination">
      <c:forEach begin="1" end="${pages}" varStatus="p">  
        <li><a class="<c:if test="${p.index eq page}">w3-green</c:if>" href="<c:url value="/prospects/viewprospects/${p.index}" />">${p.index}</a></li>
      </c:forEach>
    </ul>
  </div>
    
  </div>

<%@ include file="theme/footer.jsp" %>