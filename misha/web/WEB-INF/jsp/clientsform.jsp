<!--
    Document   : clientsform
    Created on : Feb 1, 2017, 10:26:05 PM
    Author     : calho
-->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
  <h5><b><i class="fa fa-dashboard"></i> Manage Clients > Add Client</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

  <div class="w3-card-4">
    <div class="w3-container w3-blue">
      Client Information
    </div>

      <form:form method="post" action="save" cssClass="w3-container" commandName="clients">
      <div class="w3-padding-8">
        <label><b>First Name</b></label>
        <form:input path="first_name" cssClass="w3-input w3-border" placeholder="First Name"  />
        <form:errors path="first_name" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>
        <div class="w3-padding-8">
        <label><b>Last Name</b></label>
        <form:input path="last_name" cssClass="w3-input w3-border" placeholder="Last Name"  />
        <form:errors path="last_name" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>    
    
      <div class="w3-padding-8">
        <label><b>Address 1</b></label>
        <form:input path="address_1" cssClass="w3-input w3-border" placeholder="Address 1" />
        <form:errors path="address_1" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>

      <div class="w3-padding-8">
        <label><b>Address 2</b></label>
        <form:input path="address_2" cssClass="w3-input w3-border" placeholder="Address 2"  />
        <form:errors path="address_2" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>

      <div class="w3-padding-8">
        <label><b>Address 3</b></label>
        <form:input path="address_3" cssClass="w3-input w3-border" placeholder="Address 3" />
        <form:errors path="address_3" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>

      <div class="w3-padding-8">
        <label><b>City</b></label>
        <form:input path="city" cssClass="w3-input w3-border" placeholder="City" />
        <form:errors path="city" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>

      <div class="w3-padding-8">
        <label><b>State</b></label>
        <form:select path="state" cssClass="w3-input w3-border" cssStyle="w3-select w3-border" placeholder="State" >                    
                    <form:options items="${clients.statesMap}" />
                </form:select>
        <form:errors path="state" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
        
      </div>

      <div class="w3-padding-8">
        <label><b>Phone</b></label>
        <form:input path="phone" cssClass="w3-input w3-border" placeholder="Phone"  />
        <form:errors path="phone" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>

      <div class="w3-padding-8">
        <label><b>Fax</b></label>
        <form:input path="fax" cssClass="w3-input w3-border" placeholder="Fax"  />
        <form:errors path="fax" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>

      <div class="w3-padding-8">
        <label><b>Email</b></label>
        <form:input path="email" cssClass="w3-input w3-border" placeholder="Email"  />
        <form:errors path="email" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>

      <div class="w3-padding-8">
        <label><b>Date Of Hire</b></label>
        <form:input path="date_of_hire" cssClass="w3-input w3-border" placeholder="Date of Hire"  />
        <form:errors path="date_of_hire" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>

      <div class="w3-padding-8">
        <label><b>File Number</b></label>
        <form:input path="file_number" cssClass="w3-input w3-border" placeholder="File Number"  /> 
        <form:errors path="file_number" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>

      <div class="w3-padding-8">
        <label><b>Status</b></label>
        <form:select path="status" cssClass="w3-input w3-border" cssStyle="w3-select w3-border" placeholder="Status" >                    
                    <form:options items="${clients.statesMap}" />
                </form:select>
        <form:errors path="status" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>
      <div class="w3-padding-8">
        <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
      </div>
      </form:form>
  </div>

</div>

<%@ include file="theme/footer.jsp" %>
            
            