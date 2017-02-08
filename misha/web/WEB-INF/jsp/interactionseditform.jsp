<%-- 
    Document   : interactionseditform
    Created on : Feb 1, 2017, 10:23:08 PM
    Author     : calho
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
   <h5><b><i class="fa fa-dashboard"></i> Manage Interactions > Edit Interactions</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

   <div class="w3-card-4">
       <div class="w3-container w3-blue">
           <h2>Misha</h2>
       </div>

       <form:form method="POST" action="/misha/interactions/editsave" cssClass="w3-container" commandName="interactions">
           <form:hidden path="interactionId"  />

           <div class="w3-padding-8">
               <label><b>First Name</b></label>
               <form:input path="firstName" cssClass="w3-input w3-border"  />
               <form:errors path="firstName" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
           </div>
           <div class="w3-padding-8">
               <label><b>Last Name</b></label>
               <form:input path="lastName" cssClass="w3-input w3-border"  />
           </div>
           <div class="w3-padding-8">
               <label><b>Status</b></label>
               <form:input path="status" cssClass="w3-input w3-border"  />
           </div>
           <div class="w3-padding-8">
               <label><b>Method of Contact</b></label>
               <form:input path="MethodOfContact" cssClass="w3-input w3-border"  />
           </div>
           <div class="w3-padding-8">
               <label><b>Email</b></label>
               <form:input path="email" cssClass="w3-input w3-border"  />
           </div>
           <div class="w3-padding-8">
               <label><b>Phone</b></label>
               <form:input path="phone" cssClass="w3-input w3-border"  />
           </div>
           <div class="w3-padding-8">
               <label><b>Notes</b></label>
               <form:input path="notes" cssClass="w3-input w3-border"  />
           </div>
           <div class="w3-padding-8">
               <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
           </div>
       </form:form>