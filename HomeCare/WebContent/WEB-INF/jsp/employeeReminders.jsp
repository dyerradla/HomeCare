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
	<div class="div_blackheader">Validate User</div>
	<div class="maindata_div" align="center">
		<table border="0" cellpadding="5" cellspacing="5" class="table">
			<%@ include file="loggedInUserInfo.jsp" %>	
			<tr>
				<td class="menu_td" align="right">
	            	<%@ include file="leftMenu.jsp" %>
	            </td>
				<td class="data_td" align="center">
					<c:forEach var="employeeReminder" items="${employeeReminders}">
						<ul id="treeMenu">
							  <li class="contentContainer" id="employee${employeeReminder.key}">
							  	<c:set var="employeeReminderMessageList" value="${employeeReminder.value.employeeReminderMessage}"/>
							  	<div style="text-align: left;"><c:out value="${employeeReminder.key}"/>(${fn:length(employeeReminderMessageList)} Reminders Found) 
								  	<input type="button" value="Send Email" class="btn_css" onclick="sendEmail(${employeeReminder.value.employeeId},'${employeeReminder.value.status}')"/>
								  	<input type="button" value="Load Employee" class="btn_css" onclick="loadEmployee(${employeeReminder.value.employeeId})"/>
							  	</div>
							  	<ul style="display: none;">
							  		<c:if test="${empty employeeReminder.value.employeeReminderMessage}">No Reminders Found</c:if>
							  	 	<c:forEach var="employeeReminderMessage" items="${employeeReminder.value.employeeReminderMessage}">
								  		<li style="text-align: left;">
										 	<c:out value="${employeeReminderMessage}"/>
									 	</li>
							 		 </c:forEach>
								 </ul>
							 </li>
						 </ul>
					</c:forEach>
					<div style="text-align: left; padding: 10px 0px;">
                       	<input type="button" value="Email All Employee Remiders" onclick="emailAllReminders()" class="btn_css"/>
                    </div>
				</td>
			</tr>
		</table>
	</div>
</form:form>
<script type="text/javascript">
	$(document).ready(function() {
	
	//Class 'contentContainer' refers to 'li' that has child with it.
	//By default the child ul of 'contentContainer' will be set to 'display:none'
	
	    $("#treeMenu li").toggle(			
		
			  function() { // START FIRST CLICK FUNCTION
				  $(this).children('ul').slideDown()
				  if ($(this).hasClass('contentContainer')) {   
					  $(this).removeClass('contentContainer').addClass('contentViewing');
				  }
			  }, // END FIRST CLICK FUNCTION
			  
			  function() { // START SECOND CLICK FUNCTION
				  $(this).children('ul').slideUp();
	
				  if ($(this).hasClass('contentViewing')) {
					  $(this).removeClass('contentViewing').addClass('contentContainer');
				  }
			  } // END SECOND CLICK FUNCTIOn
		); // END TOGGLE FUNCTION 
				
	}); // END DOCUMENT READY

	
	function emailAllReminders(){
		$("#employeeInfoForm").attr("action","/HomeCare/emailAllReminders.do");
		$("#employeeInfoForm").submit();
	}
	
	function loadEmployee(employeeId){
		$("#employeeInfoForm").attr("action","/HomeCare/loadEmployeeInfo.do?employeeId="+employeeId);
		$("#employeeInfoForm").submit();
	}
	
	function sendEmail(employeeId,status){
		if("A" == status){
			$.ajax({
				type : 'GET',
				url : '/HomeCare/sendEmail.do',
				data : {
					employeeId : employeeId
				},
				error : function(){
					alert('Error in Sending the Email');
				},
				success : function(){
					alert('Email send Successfully');
				}
			});
		}	
		else{
			alert("Email can't be send for InActive Employees");
		}
	}
</script>
