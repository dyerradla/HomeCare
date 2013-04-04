<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="styles/common.css" type="text/css">
<link rel="stylesheet" href="styles/jquery-ui-1.8.18.custom.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form:form id="userForm" name="userForm" action="validateUser.do">
<form:hidden id="validUser" path="validUser"/>
<div style="display: none;" id="invalidErrorMessage">Invalid UserName Or Password</div>
	<table>
		<tr>
			<td>
				User Name
			</td>
			<td>
				<form:input id="userName" path="user.userName" />
			</td>
		</tr>
		<tr>
			<td>
				Password
			</td>
			<td>
				<form:password id="password" path="user.password"/>
			</td>
		</tr>
	</table>
	<input type="button" value="Login" onclick="login()">
</form:form>
<script>
if($('#validUser').val() == "N"){
	$('#invalidErrorMessage').show();
}

function login(){
	var errorMessage = "";
	var errorExists = false;
	if($('#userName').val() == ''){
		errorExists = true;
		errorMessage += "Please Enter User Name" + "\n";
	}
	if($('#password').val() == ''){
		errorExists = true;
		errorMessage += "Please Enter password" + "\n";
	}
	if(errorExists){
		alert(errorMessage);
		return false;
	}else{
		$("#userForm").submit();	
	}
}
</script>