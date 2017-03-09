<%-- 
    Document   : interactionsform
    Created on : Feb 1, 2017, 10:23:46 PM
    Author     : calho
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
  <h5><b><i class="fa fa-dashboard"></i> Manage Interactions > Add Interaction</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

  <div class="w3-card-4">
    <div class="w3-container w3-blue">
      Interaction Information
    </div>

      <form:form method="post" action="save" cssClass="w3-container" commandName="interactions">
      <div class="w3-padding-8">
        <label><b>First Name</b></label>
        <form:input path="first_name" cssClass="w3-input w3-border" placeholder="First Name" />
        <form:errors path="first_name" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>
 
      <div class="w3-padding-8">
        <label><b>Last Name</b></label>
        <form:input path="last_name" cssClass="w3-input w3-border" placeholder="Last Name" />
        <form:errors path="last_name" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>    

      <div class="w3-padding-8">
        <label><b>Status</b></label>
        <form:select path="status" cssClass="w3-input w3-border"  >
                     <form:option value="">Status</form:option>
            <form:options items="${interactions.statusMap}" />
        </form:select>
        <form:errors path="status" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>

      <div class="w3-padding-8">
        <label><b>Method Of Contact</b></label>
        <form:select path="method_of_contact" cssClass="w3-input w3-border"  >
            <form:option value="">Method of Contact</form:option>
                    <form:options items="${interactions.contact_type}" />
        </form:select>
        <form:errors path="method_of_contact" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>

      <div class="w3-padding-8">
        <label><b>Email</b></label>
        <form:input path="email" cssClass="w3-input w3-border" placeholder="Email"  />
        <form:errors path="email" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>

      <div class="w3-padding-8">
        <label><b>Phone</b></label>
        <form:input path="phone" cssClass="w3-input w3-border" placeholder="Phone"  />
        <form:errors path="phone" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>

      <div class="w3-padding-8">
        <label><b>Notes</b></label>
        <form:input path="notes" cssClass="w3-input w3-border" placeholder="Notes"  />
        <form:errors path="notes" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>
      
      <div class="w3-padding-8">
        <label><b>Contact Date</b></label>
        <form:input path="contact_date" cssClass="w3-input w3-border" placeholder="Contact Date" />
        <form:errors path="contact_date" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>    
      
      <div class="w3-padding-8">
        <label><b>Client</b></label>
        <form:select path="client_id" cssClass="w3-input w3-border" placeholder="Client ID"  >
        <form:option value="-1"> Select Client</form:option>
        <form:options items="${interactions.clientsMap}"></form:options>
        </form:select>     
        <form:errors path="client_id" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
      </div>    
      <div class="w3-padding-8">
        <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
      </div>
    </form:form>
  </div>

</div>

<%@ include file="theme/footer.jsp" %>