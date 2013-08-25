<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="styles/common.css" type="text/css">
<link rel="stylesheet" href="styles/jquery-ui-1.8.18.custom.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form:form id="userForm" name="userForm" action="saveUser.do">
	<table>
		<%@ include file="loggedInUserInfo.jsp" %>
		<form:hidden path="user.employerId" value="${sessionScope.user.employerId}"/>
		<form:hidden path="user.userId"/>
		<tr>
			<td class="menu_td" align="right">
            	<%@ include file="leftMenu.jsp" %>
            </td>
			<td class="data_td" align="left">
				<table border="0" cellpadding="0" cellspacing="0" class="bg_data">
					<tr>
						<td>First Name:</td><td><form:input type="text" path="user.firstName"></form:input></td>
					</tr>
					<tr>
						<td>Last Name:</td><td><form:input type="text" path="user.lastName"></form:input></td>
					</tr>
					<tr>
						<td>Middle Name:</td><td><form:input type="text" path="user.middleName"></form:input></td>
					</tr>
					<tr>
						<td>User Name:</td><td><form:input type="text" path="user.userName"></form:input></td>
					</tr>
					<tr>
						<td>Password:</td><td><form:input type="text" path="user.password"></form:input></td>
					</tr>
					<tr>
						<td>Role:</td>
						<td><form:select path="user.role">
							<form:option value="A">Administrator</form:option>
							<form:option value="U">User</form:option>
						</form:select>
					</tr>
				</table>
				<br />
				<input type="button" name="Save" value="Save" onclick="submitUser()"/>
			</td>		
		</tr>
	</table>
</form:form>
<script type="text/javascript">
	function submitUser(){
		$("#userForm").attr("action","/HomeCare/saveUser.do");
		$("#userForm").submit();
	}

</script>