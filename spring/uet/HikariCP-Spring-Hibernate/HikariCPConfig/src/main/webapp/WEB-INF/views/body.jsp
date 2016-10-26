<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="forms" %>
  <a href="${pageContext.servletContext.contextPath}/page2">Go to Second Page</a>
 

<div class="container" style="margin-top:50px;">
   <div class="row">
      <div class="col-md-offset-3 col-md-6">
         
          <!-- Save Alert Messages -->
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
           
           <!-- Deletion Alert Messages -->
	            <c:if test="${deletion eq 'unsuccess'}">
	              <div class="alert alert-danger alert-dismissible" role="alert">
					  <strong>Error!</strong> Employee Data Not Deleted.
					</div>
	           </c:if>
	           <c:if test="${deletion eq 'success'}">
	              <div class="alert alert-success alert-dismissible" role="alert">
					  <strong>Success!</strong> Employee Data Deleted Successfully.
					</div>
	           </c:if>
	       
	       <!-- Edit Alert Message -->
	        <c:if test="${status eq 'notfound'}">
	              <div class="alert alert-danger alert-dismissible" role="alert">
					  <strong>Error!</strong> Invalid Employee.
					</div>
	           </c:if>
	           <c:if test="${edit eq 'unsuccess'}">
	              <div class="alert alert-danger alert-dismissible" role="alert">
					  <strong>Error!</strong> Employee Data Not Edited.
					</div>
	           </c:if>
	           <c:if test="${edit eq 'success'}">
	              <div class="alert alert-success alert-dismissible" role="alert">
					  <strong>Success!</strong> Employee Data Edited Successfully.
					</div>
	           </c:if>
	           
          <div class="panel panel-success">
			  <div class="panel-heading">
			    <h3 class="panel-title">Add Employee</h3>
			  </div>
			     <div class="panel-body">
			      <forms:form commandName="employee" action="${pageContext.servletContext.contextPath}/employee/save">
			         <forms:input type="text" path="empName" class="form-control" placeholder="Employee Name"/>
			         <div style="clear:both; display:block;height:10px;"></div>
			         <forms:input type="text" path="empDesignation" class="form-control" placeholder="Employee Designation"/>
			         <div style="clear:both; display:block;height:10px;"></div>
			         <forms:input type="text" path="empSalary" class="form-control" placeholder="Employee Salary (000.00)"/>
			         <div style="clear:both; display:block;height:10px;"></div>
			         <input type="submit" class="btn btn-primary pull-right" value="Save">
			       </forms:form>
			      </div>
			          
			</div>
      </div>
   </div>
   
   <div class="row"  style="margin-bottom:50px;">
      <div class="col-md-offset-2 col-md-8">
            <div class="panel panel-success">
			  <div class="panel-heading">
			    <h3 class="panel-title">All Employees</h3>
			  </div>
			     <div class="panel-body">
			              <table class="table table-bordered">
							<thead>
							   <tr class="btn-success">
							     <th>Name</th>
							     <th>Designation</th>
							     <th>Salary</th>
							     <th>Operation</th>
							   </tr>
							</thead>
							<tbody>
							  <c:if test="${empty allEmployees}">
							     <tr class="btn-warning">
							        <td colspan="4" align="center">No Employee Registered Yet!!!</td> 
							     </tr>
							  </c:if>
							   <c:forEach var="emp" items="${allEmployees}">
								   <tr>
								     <td>${emp.empName}</td>
								     <td>${emp.empDesignation}</td>
								     <td>${emp.empSalary}</td>
								     <td align="center">
								        <a href="${pageContext.servletContext.contextPath}/employee/edit/${emp.id}"><span class="glyphicon glyphicon-edit"></span></a> &nbsp; &nbsp;
								        <a href="${pageContext.servletContext.contextPath}/employee/delete/${emp.id}"><span class="glyphicon glyphicon-trash"></span></a>
								     </td>
								   </tr>
							    </c:forEach>
							    
							</tbody>
						</table>
			      </div>
			          
			</div>
       </div>
   </div>
</div>