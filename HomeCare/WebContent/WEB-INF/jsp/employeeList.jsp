<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="styles/EmpoyeeManagement.css" type="text/css">
<link rel="stylesheet" href="styles/jquery-ui-1.8.18.custom.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form:form id="employeeInfoForm" name="employeeInfoForm" action="loadEmployeeInfo.do">
	<div class="div_blackheader">Validate User</div>
	<div class="maindata_div" align="center">
        <table border="0" cellpadding="5" cellspacing="5" class="table">
				<%@ include file="loggedInUserInfo.jsp" %>
				<tr>
					<td class="menu_td" align="right">
		            	<%@ include file="leftMenu.jsp" %>
		            </td>
					<td class="data_td" align="left">
						<table border="0" cellpadding="2" cellspacing="2" style="width: 100%;">
							<tr>
								<td style="width: 33.3%; vertical-align: top;">First Name:<form:input type="text" path="selectedEmployeeFirstName"></form:input></td>
								<td style="width: 33.3%; vertical-align: top;">Last Name:<form:input type="text" path="selectedEmployeeLastName"></form:input></td>
								<td style="width: 33.3%; vertical-align: top;">Status:
									<form:select id="selectedStatus" path="selectedStatus" >
										<form:option value="">All</form:option>
										<form:option value="A">Active</form:option>
										<form:option value="IA">In Active</form:option>
									</form:select>
								</td>
							</tr>
							<tr>
								<td colspan="3" style="text-align: center; padding: 10px 0px;">
									<input type="button" class="btn_css" value="Search Employee" onclick="searchEmployee()"/>
									<input type="button" class="btn_css" value="Get All Reminders" onclick="getReminders()">
									<input type="submit" class="btn_css" value="New Employee">	
								</td>
							</tr>
						</table>
						
						<display:table cellspacing="2" cellpadding="2" class="empdata_table" uid="employeeListTable" name="${employeeList}">
							<display:column class="hidden" headerClass="hidden" title="Employee Id" property="employeeId" />
							<display:column headerClass="td_empheader" title="First Name" property="firstName" />
							<display:column headerClass="td_empheader" title="Middle Name" property="middleName" />
							<display:column headerClass="td_empheader" title="Last Name" property="lastName" />
							<display:column headerClass="td_empheader" title="Status" property="status" />
						</display:table>
						<div class="div_empbtns">
							<input type="button" class="btn_css" value="Load Employee" onclick="loadEmployee()"/>
							<input type="button" class="btn_css" value="Delete Employee" onclick="deleteEmployee(${employeeListTable.employeeId})"/>
						</div>
					</td>
				</tr>
		</table>
		</div>
</form:form>
<style type="text/css">
table.alternateColor tr.selectRow
{
	background-color: blue;
}

</style>
<script type="text/javascript">

$("#employeeListTable tr").click(function(){
	$(this).addClass("selectRow").siblings().removeClass("selectRow");
});

$("#employeeListTable tr").dblclick(function(){
	$(this).addClass("selectRow").siblings().removeClass("selectRow");
	loadEmployee();
});

function loadEmployee(){
	if($("#employeeListTable .selectRow").find(".hidden").text()){
		var employeeId = $("#employeeListTable .selectRow").find(".hidden").text();
		$("#employeeInfoForm").attr("action","/HomeCare/loadEmployeeInfo.do?employeeId="+employeeId);
		$("#employeeInfoForm").submit();	
	}else{
		alert('Plese select an Employee');
	}
};

function deleteEmployee(employeeId){
	if($("#employeeListTable .selectRow").find(".hidden").text()){
		var employeeId = $("#employeeListTable .selectRow").find(".hidden").text();
		$("#employeeInfoForm").attr("action","/HomeCare/deleteEmployeeInfo.do?employeeId="+employeeId);
		$("#employeeInfoForm").submit();	
	}else{
		alert('Plese select an Employee');
	}
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