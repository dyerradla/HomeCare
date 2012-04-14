<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="styles/common.css" type="text/css">
<link rel="stylesheet" href="styles/jquery-ui-1.8.18.custom.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form:form id="employeeInfoForm" name="employeeInfoForm" action="loadEmployeeInfo.do">
	<table>
		<tr>
			<td>First Name:<form:input type="text" path="selectedEmployeeFirstName"></form:input></td>
			<td>Last Name:<form:input type="text" path="selectedEmployeeLastName"></form:input></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="Search Employee" onclick="searchEmployee()"/>
				<input type="button" value="Get Reminders" onclick="getReminders()">
				<input type="submit" value="New Employee">	
			</td>
		</tr>
	</table>
	<br /><br />
	<table>
		<tr>
			<td colspan="2">
				<display:table  class="alternateColor" uid="employeeListTable" name="${employeeList}">
					<display:column headerClass="columnHeader" class="hidden" headerClass="hidden" title="Employee Id" property="employeeId" />
					<display:column headerClass="columnHeader" title="First Name" property="firstName" />
					<display:column headerClass="columnHeader" title="Middle Name" property="middleName" />
					<display:column headerClass="columnHeader" title="Last Name" property="lastName" />
					<display:column headerClass="columnHeader" title="Status" property="status" />
					<display:column headerClass="columnHeader"><input type="button" value="Load Employee" onclick="loadEmployee(${employeeListTable.employeeId})"/></display:column>
					<display:column headerClass="columnHeader"><input type="button" value="Delete Employee" onclick="deleteEmployee(${employeeListTable.employeeId})"/></display:column>
				</display:table>
			</td>
		</tr>
	</table>
</form:form>

<script type="text/javascript">
function loadEmployee(employeeId){
	$("#employeeInfoForm").attr("action","/HomeCare/loadEmployeeInfo.do?employeeId="+employeeId);
	$("#employeeInfoForm").submit();
};

function deleteEmployee(employeeId){
	$("#employeeInfoForm").attr("action","/HomeCare/deleteEmployeeInfo.do?employeeId="+employeeId);
	$("#employeeInfoForm").submit();
};

function getReminders(){
	$("#employeeInfoForm").attr("action","/HomeCare/getReminders.do");
	$("#employeeInfoForm").submit();
}

function searchEmployee(){
	$("#employeeInfoForm").attr("action","/HomeCare/getAllEmployees.do");
	$("#employeeInfoForm").submit();
}

</script>