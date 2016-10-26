<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="forms" %>
  <a href="${pageContext.servletContext.contextPath}/page2">Go to Second Page</a>
 

<div class="container" style="margin-top:50px;">
   <div class="row">
      <div class="col-md-offset-3 col-md-6">
      
           <c:if test="${saveEmployee eq 'unsuccess'}">
              <div class="alert alert-danger alert-dismissible" role="alert">
				  <strong>Error!</strong> Employee Data Not Saved.
				</div>
           </c:if>
           <c:if test="${saveEmployee eq 'success'}">
              <div class="alert alert-success alert-dismissible" role="alert">
				  <strong>Success!</strong> Employee Data Saved Successfully.
				</div>
           </c:if>
           
          <div class="panel panel-success">
			  <div class="panel-heading">
			    <h3 class="panel-title">Edit Employee</h3>
			  </div>
			     <div class="panel-body">
			      <forms:form commandName="editEmployee" action="${pageContext.servletContext.contextPath}/employee/update">
			         <forms:hidden path="id"/>
			         <forms:input type="text" path="empName" class="form-control" placeholder="Employee Name"/>
			         <div style="clear:both; display:block;height:10px;"></div>
			         <forms:input type="text" path="empDesignation" class="form-control" placeholder="Employee Designation"/>
			         <div style="clear:both; display:block;height:10px;"></div>
			         <forms:input type="text" path="empSalary" class="form-control" placeholder="Employee Salary (000.00)"/>
			         <div style="clear:both; display:block;height:10px;"></div>
			         <input type="submit" class="btn btn-primary pull-right" value="Update">
			       </forms:form>
			      </div>
			       
			       <div class="panel-footer">
						 <a href="${pageContext.servletContext.contextPath}/savepage" class="btn btn-success">Back To Save Page</a>
			       
			         
			       </div>  
			</div>
      </div>
   </div>

</div>