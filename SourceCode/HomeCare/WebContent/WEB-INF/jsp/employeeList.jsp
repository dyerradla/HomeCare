<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="../../styles/common.css" type="text/css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form:form name="employeeInfoForm" action="saveEmployeeInfo.do">
	<display:table  name="${employeeList}">
		<display:column title="First Name" property="firstName" />
		<display:column title="Middle Name" property="middleName" />
		<display:column title="Last Name" property="lastName" />
		<display:column title="Create Dt" property="createDt" />
		<display:column title="Create User Id" property="createUserId" />
	</display:table>
</form:form>