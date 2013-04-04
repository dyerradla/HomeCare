<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="stylesheet" href="styles/common.css" type="text/css" />
<link rel="stylesheet" href="styles/jquery-ui-1.8.18.custom.css" type="text/css">

<script type="text/javascript" src="js/JScript.js"></script>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form:form id="employeeInfoForm" name="employeeInfoForm" action="">
	<div>
		<c:forEach var="employeeDocument" items="${employeeInfo.employeeDocuments}">
			
		</c:forEach>
	</div>
</form:form>
