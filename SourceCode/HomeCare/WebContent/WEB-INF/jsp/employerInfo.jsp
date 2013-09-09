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
	<div class="div_blackheader">Edit Employer Info</div>
	<div class="maindata_div" align="center">
         <table border="0" cellpadding="5" cellspacing="5" class="table">
			<%@ include file="loggedInUserInfo.jsp" %>
			<form:hidden path="employerInfo.employerId"/>
			<tr>
				<td class="menu_td" align="right">
	            	<%@ include file="leftMenu.jsp" %>
	            </td>
				<td class="data_td" align="center">
					<div class="div_edituser">
						<table border="0" cellpadding="2" cellspacing="2" style="width: 80%;">
							<tr>
								<td class="td_editnames">Employer Name:</td>
								<td class="td_editfields"><form:input type="text" path="employerInfo.employerName"></form:input></td>
							</tr>
							<tr>
								<td class="td_editnames">Email:</td>
								<td class="td_editfields"><form:input type="text" path="employerInfo.email"></form:input></td>
							</tr>
							<tr>
								<td class="td_editnames">Password:</td>
								<td class="td_editfields"><form:input type="text" path="employerInfo.password"></form:input></td>
							</tr>
							<tr>
                                <td></td>
                                <td>
                                    <input type="button" name="Save" value="Save" class="btn_css" onclick="submitUser()"/>
                                </td>
                            </tr>
						</table>
					</div>	
				</td>		
			</tr>
		</table>
	</div>
</form:form>
<script type="text/javascript">
	function submitUser(){
		$("#userForm").attr("action","/HomeCare/saveEmployer.do");
		$("#userForm").submit();
	}

</script>