<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form:form id="userForm" name="userForm" action="validateUser.do">
<form:hidden id="validUser" path="validUser"/>

 <table border="0" cellpadding="5" cellspacing="5" style="width: 100%; height: 300px;">
     <tr>
         <td class="login_imagetd">
             <div class="header">
                 Employee File Management
             </div>
             <img src="/HomeCare/styles/images/Login_sideimg.png" alt="" style="width: auto; height: auto;" />
         </td>
         <td class="td_loginbox" align="center">
             <table border="0" cellpadding="3" cellspacing="3" class="table_login">
                 <tr>
                     <td colspan="2" class="empty_space">
						<div style="display: none;color: red;" id="invalidErrorMessage">Invalid UserName Or Password</div>
                     </td>
                 </tr>
                 
                 <tr>
                     <td colspan="2" class="header_member">
                         Member Login
                     </td>
                 </tr>
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
                         <form:password id="password" path="user.password" />
                     </td>
                 </tr>
                 <tr>
                     <td>
                     </td>
                     <td>
                         <a href="#">Forgot Password?</a>
                     </td>
                 </tr>
                 <tr>
                     <td>
                     </td>
                     <td>
                         <input type="button" value="Login" onclick="login()">
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
                         Email : <a href="mailto://abcdef@paragonhomes.com" class="links_support">abcedef@Paragonhomes.com</a>
                     </td>
                 </tr>
                 <tr>
                     <td>
                         Web : &nbsp;<a href="http://google.com" class="links_support" target="_blank">www.google.com</a>
                     </td>
                 </tr>
                 <tr>
                     <td>
                         Mobile : &nbsp;+91-9985016723
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
               
</body>

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