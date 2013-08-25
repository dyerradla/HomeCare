<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="styles/common.css" type="text/css">
<link rel="stylesheet" href="styles/jquery-ui-1.8.18.custom.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form:form id="userForm" name="userForm" action="saveEmployer.do">
	<table>
		<%@ include file="loggedInUserInfo.jsp" %>
		<form:hidden path="employerInfo.employerId"/>
		<tr>
			<td class="menu_td" align="right">
            	<%@ include file="leftMenu.jsp" %>
            </td>
			<td class="data_td" align="left">
			  
	         	<table border="0" cellpadding="0" cellspacing="0" class="bg_data">
					<tr>
						<td>Employer Name:</td><td><form:input type="text" path="employerInfo.employerName"></form:input></td>
					</tr>
					<tr>
						<td>Email:</td><td><form:input type="text" path="employerInfo.email"></form:input></td>
					</tr>
					<tr>
						<td>Password:</td><td><form:input type="text" path="employerInfo.password"></form:input></td>
					</tr>
				</table>	
			<br>
			<input type="button" name="Save" value="Save" onclick="submitUser()"/>
			</td>		
		</tr>
	</table>
</form:form>
<script type="text/javascript">
	function submitUser(){
		$("#userForm").attr("action","/HomeCare/saveEmployer.do");
		$("#userForm").submit();
	}

</script>