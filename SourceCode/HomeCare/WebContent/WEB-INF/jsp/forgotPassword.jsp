<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="styles/EmpoyeeManagement.css" type="text/css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form:form id="userForm" name="userForm" action="sendPasswordEmail.do">
	<form:hidden id="status" path="status"/>
	<div class="div_blackheader">Forgot User name/Password</div>
		<div class="maindata_div" align="center">
			 <table border="0" cellpadding="5" cellspacing="5" class="main_logindiv">
			     <tr>
			         <td class="login_imagetd" align="center">
			             <img src="/HomeCare/styles/images/Login_sideimg.png" alt="" style="width: auto; height: auto;" />
			         </td>
			         <td class="td_loginbox" align="center">
			             <table border="0" cellpadding="3" cellspacing="3" class="table_login">
			                 <tr>
			                     <td>
			                         Email
			                     </td>
			                     <td>
			                         <form:input path="email" id="email" size="20"/>
			                     </td>
			                 </tr>
			                 
			                 <tr>
			                     <td>
			                     </td>
			                     <td>
			                         <input type="button" value="Retrieve Password" onclick="sendPasswordEmail()">
			                     </td>
			                 </tr>
			                 <tr>
			                     <td colspan="2" class="empty_space">
			                     </td>
			                 </tr>
			             </table>
			             <table border="0" cellpadding="3" cellspacing="3" class="table_login">
			                 <tr>
			                     <td>
			                     </td>
			                 </tr>
			                 <tr>
			                     <td class="header_member">
			                         For Support and Queries
			                     </td>
			                 </tr>
			                 <tr>
			                     <td>
			                         Email : <a href="mailto://abcdef@paragonhomes.com" class="links_support">info@topcompliance.com</a>
			                     </td>
			                 </tr>
			                 <tr>
			                     <td>
			                         Web : &nbsp;<a href="http://google.com" class="links_support" target="_blank">www.topcompliance.com</a>
			                     </td>
			                 </tr>
			                 <tr>
			                     <td>
			                         Contact : &nbsp;269-364-6780
			                     </td>
			                 </tr>
			                 <tr>
			                     <td>
			                     </td>
			                 </tr>
			             </table>
			         </td>
			     </tr>
			 </table>
		</div>               
	</body>
</form:form>
<script>
	if($('#status').val()){
		alert($('#status').val());
	}

	function sendPasswordEmail(){
		var errorExists = false;
		if($('#email').val() == ''){
			errorExists = true;
		}else{
			var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
			if(!emailPattern.test($('#email').val())){
				errorExists = true;
			}
		}
		
		if(errorExists){
			alert('Please enter a valid email address');
		}
		else{
			$("#userForm").submit();
		}
	}
</script>