<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form:form id="employeeInfoForm" name="employeeInfoForm" action="saveEmployeeInfo.do">
	<input type="hidden" name="employeeInfo.employeeId" value="${command.employeeInfo.employeeId}" />
	<form:hidden path="employeeSaved"/>
	
                    <table border="0" cellpadding="5" cellspacing="5" style="width: 100%;">
                        <tr>
                            <td style="text-align: left; padding: 0px 0px 0px 10px;font-size: 14px;">
                                <a href="/HomeCare/getAllEmployees.do">
                                    <img src="/HomeCare/styles/images/Icon_Home.png" alt="" align="middle" style="margin: -5px 0px 0px 0px;"></a>
                                > Employee Management
                            </td>
                            <td style="text-align: right;font-size: 14px;">
                                <a href="#">
                                    <img src="/HomeCare/styles/images/Img_User.png" alt="" align="middle" /></a>&nbsp; Welcome,
                                		<c:if test="${sessionScope.user} != null">
                                			${sessionScope.user.lastName}
                                		</c:if>
                                 | <a href="/HomeCare/logout.do" >Logout</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="menu_td" align="right">
                               <%@ include file="leftMenu.jsp" %>
                            </td>
                            <td class="data_td" align="left">
                                <div class="container">
                                    <ul class="tabs">
                                        <li><a href="#personal">Personal</a></li>
                                        <li><a href="#basics">Basics</a></li>
                                        <li><a href="#licenses">Licenses</a></li>
                                        <li><a href="#employment">Employment</a></li>
                                    </ul>
                                    <div style="height: 10px;">
                                    </div>
                                    <div class="tab_container">
                                        <div id="personal" class="tab_content">
                                            <table border="0" cellpadding="0" cellspacing="0" class="bg_data">
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        First Name
                                                    </td>
                                                    <td>
                                                        <form:input maxlength="32" id="firstName" path="employeeInfo.firstName" />
                                                    </td>
                                                    <td>
                                                        Middle Name
                                                    </td>
                                                    <td>
                                                        <form:input maxlength="1" path="employeeInfo.middleName" />
                                                    </td>
                                                    <td>
                                                        Last Name
                                                    </td>
                                                    <td>
                                                        <form:input maxlength="32" id="lastName" path="employeeInfo.lastName" />
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Email Address
                                                    </td>
                                                    <td>
                                                        <form:input id="emailAddress" maxlength="50" path="employeeInfo.emailAddress" />
                                                    </td>
                                                    <td>
                                                        Phone Number
                                                    </td>
                                                    <td>
                                                        <form:input id="phoneNumber" maxlength="10" path="employeeInfo.phoneNumber" />
                                                    </td>
                                                    <td>
                                                        Designation
                                                    </td>
                                                    <td>
                                                        <form:input id="designation" maxlength="20" path="employeeInfo.designation" />
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Employment Date
                                                    </td>
                                                    <td>
                                                        <form:input id="employmentDate" maxlength="10" path="employeeInfo.employmentDate" cssClass="datepicker-example1"/>
                                                    </td>
                                                    <td>
                                                        Status
                                                    </td>
                                                    <td>
                                                       <form:select path="employeeInfo.status">
												  			<form:option value='A' label="Active" />
												  			<form:option value='IA' label="In Active"/>
											       		</form:select>
                                                    </td>
                                                    <td>
                                                        Department
                                                    </td>
                                                    <td>
                                                        <form:select id="department" onchange="enableDisableFieldsOnDeptChange()" path="employeeInfo.department">
												  			<form:option value='100' label="100-Admin" />
												  			<form:option value='200' label="200-Clinical"/>
												  			<form:option value='300' label="300-Contract"/>
											       		</form:select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div id="basics" class="tab_content" align="center">
                                            <table border="0" cellpadding="0" cellspacing="0" class="bg_data">
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Application
                                                    </td>
                                                    <td>
                                                        <form:select id="application" path="employeeInfo.application">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                    <td>
                                                        Resume
                                                    </td>
                                                    <td>
														<form:select id="resume" path="employeeInfo.resume">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>                                                    </td>
                                                    <td>
                                                        Reference Check
                                                    </td>
                                                    <td>
                                                        <form:select id="referenceChecks" path="employeeInfo.referenceChecks">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Job Description
                                                    </td>
                                                    <td>
                                                        <form:select id="signedJobDescription" path="employeeInfo.signedJobDescription">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
												  		</form:select>
                                                    </td>
                                                    <td>
                                                        Policy
                                                    </td>
                                                    <td>
                                                        <form:select id="policy" path="employeeInfo.policy">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                    <td>
                                                        Orientation
                                                    </td>
                                                    <td>
                                                        <form:select id="orientationCheckList" path="employeeInfo.orientationChecklist">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Statement Of Confidentiality
                                                    </td>
                                                    <td>
                                                        <form:select id="statementOfConfidentiality" path="employeeInfo.statementOfConfidentiality">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                    <td>
                                                        Social Security Card
                                                    </td>
                                                    <td>
                                                        <form:select id="socialSecurityCard" path="employeeInfo.socialSecurityCard">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                    <td>
                                                        NonCompete
                                                    </td>
                                                    <td>
                                                        <form:select id="nonCompete" path="employeeInfo.nonCompete">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div id="licenses" class="tab_content" align="center">
                                            <table border="0" cellpadding="0" cellspacing="0" class="bg_data">
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Initial Comp EVal
                                                    </td>
                                                    <td>
                                                        <form:input id="initialCompetencyEvaluation" maxlength="10" path="employeeInfo.initialCompetencyEvaluation" cssClass="datepicker-example1"/>
                                                    </td>
                                                    <td>
                                                        Ongo Comp Value
                                                    </td>
                                                    <td>
                                                        <form:input id="ongoinCompetencyEvaluation" maxlength="10" path="employeeInfo.ongoinCompetencyEvaluation" cssClass="datepicker-example1"/>
                                                    </td>
                                                    <td>
                                                        Annual Evaluation
                                                    </td>
                                                    <td>
                                                        <form:input id="annualEvaluation" maxlength="10" path="employeeInfo.annualEvaluation" cssClass="datepicker-example1"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Prof License
                                                    </td>
                                                    <td>
                                                        <form:input id="profLicense" maxlength="10" path="employeeInfo.profLicense" cssClass="datepicker-example1"/>
                                                    </td>
                                                    <td>
                                                        Auto Insurance
                                                    </td>
                                                    <td>
                                                        <form:input id="proofValidCarInsurance" maxlength="10" path="employeeInfo.proofValidCarInsurance" cssClass="datepicker-example1"/>
                                                    </td>
                                                    <td>
                                                        CPR Card
                                                    </td>
                                                    <td>
                                                        <form:input id="cprCard" maxlength="10" path="employeeInfo.cprCard" cssClass="datepicker-example1"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        TB Test
                                                    </td>
                                                    <td>
                                                        <form:input id="tbTest" maxlength="10" path="employeeInfo.tbTest" cssClass="datepicker-example1"/>
                                                    </td>
                                                    <td>
                                                        Hippa Training
                                                    </td>
                                                    <td>
                                                        <form:select id="hippaTraining" path="employeeInfo.hippaTraining">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                    <td>
                                                        Osha Training
                                                    </td>
                                                    <td>
                                                        <form:select id="oshaTraining" path="employeeInfo.oshaTraining">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Drivers License
                                                    </td>
                                                    <td>
                                                        <form:input id="driversLicense" maxlength="10" path="employeeInfo.driversLicense" cssClass="datepicker-example1"/>
                                                    </td>
                                                    <td>
                                                        HVB Test
                                                    </td>
                                                    <td>
                                                        <form:select id="hvbTest" path="employeeInfo.hvbTest">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                    <td>
                                                        Verification Prof License
                                                    </td>
                                                    <td>
                                                        <form:select id="verificationProfLicense" path="employeeInfo.verificationProfLicense">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div id="employment" class="tab_content" align="center">
                                            <table border="0" cellpadding="0" cellspacing="0" class="bg_data">
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        I9
                                                    </td>
                                                    <td>
                                                        <form:select id="i9" path="employeeInfo.i9">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                    <td>
                                                        Federal W4
                                                    </td>
                                                    <td>
                                                        <form:select id="federalW4" path="employeeInfo.federalW4">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                    <td>
                                                        Michigan W4
                                                    </td>
                                                    <td>
                                                        <form:select id="michiganW4" path="employeeInfo.michiganW4">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Criminal Check
                                                    </td>
                                                    <td>
                                                        <form:select id="criminalCheck" path="employeeInfo.criminalCheck">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                    <td>
                                                        Authorization Criminal Check
                                                    </td>
                                                    <td>
                                                        <form:select id="authorizationCriminalCheck" path="employeeInfo.authorizationCriminalCheck">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                    <td>
                                                        Fingerprints Results
                                                    </td>
                                                    <td>
                                                        <form:select id="fingerprintsResults" path="employeeInfo.fingerprintsResults">
												  			<form:option value='' label="--Select--" />
												  			<form:options items="${yesNoList}" />
											       		</form:select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="6" class="emptyspace">
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div style="clear: both; height: 10px;">
                                </div>
                                <div align="center" style="margin: 0px 0px 0px 0px;">
                                	<input type="button" value="Submit" class="btn_css" onclick="submitEmployee()">
                                	&nbsp;
                                	<input type="button" value="New Employee" class="btn_css" onclick="newEmployee()">
                                	&nbsp;	
									<input type="button" value="Get All Employees" class="btn_css" onclick="getAllEmployees()">
									&nbsp;
									<input type="button" value="Get Reminders" class="btn_css" onclick="getRemindersByEmployee(${command.employeeInfo.employeeId})">
                                </div>
                            </td>
                        </tr>
                    </table>
	</form:form>
<script>
	enableDisableFieldsOnDeptChange();
	
	$(function() {
		$( '.datepicker-example1' ).datepicker();
		$( '.datepicker-example1' ).blur(function(){
			var valid = true;
			var date = this.value;
			if(date != '' && date.length != 0){
				date = date.replace('/-/g', '');
		        var month = date.substring(0, 2);
		        var day   = date.substring(3, 5);
		        var year  = date.substring(6, 10);

		        if(date.length != 10 || month.length != 2 || day.length != 2 || year.length != 4){
		        	valid = false;
		        }
		        if(valid){
		        	if((month < 1) || (month > 12)) valid = false;
			        else if((day < 1) || (day > 31)) valid = false;
			        else if(((month == 4) || (month == 6) || (month == 9) || (month == 11)) && (day > 30)) valid = false;
			        else if((month == 2) && (((year % 400) == 0) || ((year % 4) == 0)) && ((year % 100) != 0) && (day > 29)) valid = false;
			        else if((month == 2) && ((year % 100) == 0) && (day > 29)) valid = false;	
		        }	
			}
			
			if(!valid){
				alert("Please enter the date in MM/DD/YYYY format or select it from calendar");
				$(this).focus();
			}
		});
		
		// If Employee is saved then we are showing this alert
		if($('#employeeSaved').val()){
			$('#employeeSaved').val('N');
			alert('Employee Information Saved Sucessfully');
		}
		
		
           //Default Action
           $(".tab_content").hide(); //Hide all content
           $("ul.tabs li:first").addClass("active").show(); //Activate first tab
           $(".tab_content:first").show(); //Show first tab content

           //On Click Event
           $("ul.tabs li").click(function () {
               $("ul.tabs li").removeClass("active"); //Remove any "active" class
               $(this).addClass("active"); //Add "active" class to selected tab
               $(".tab_content").hide(); //Hide all tab content
               var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
               $(activeTab).fadeIn(0); //Fade in the active content                
               return false;
           });
	});
	
	function submitEmployee(){
		$("#employeeInfoForm").attr("action","/HomeCare/saveEmployeeInfo.do");
		if(!validateForm()){
			$("#employeeInfoForm").submit();		
		}
	}
	
	function validateForm(){
		var errorMessage = "";
		var errorExists = false;
		if($('#firstName').val() == ''){
			errorExists = true;
			errorMessage += "Please Enter First Name" + "\n";
		}
		if($('#lastName').val() == ''){
			errorExists = true;
			errorMessage += "Please Enter Last Name" + "\n";
		}
		
		if($('#emailAddress').val() == ''){
			errorExists = true;
			errorMessage += "Please Enter Email Address" + "\n";
		}else{
			var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
			if(!emailPattern.test($('#emailAddress').val())){
				errorExists = true;
				errorMessage += "Please Enter valid Email Address" + "\n";
			}
		}
		if($('#employmentDate').val() == ''){
			errorExists = true;
			errorMessage += "Please Enter Employment Date" + "\n";
		}
		if(errorExists){
			alert(errorMessage);
		}
		
		return errorExists;
	}
	
	function enableDisableFieldsOnDeptChange(){
		$("#employeeInfoForm :input").removeAttr("disabled");
		$("#employeeInfoForm :input").removeAttr("disabled");
		if("100" == $('#department').val()){
			$('#profLicense').attr("disabled","disabled");
			$('#cprCard').attr("disabled","disabled");
			$('#tbTest').attr("disabled","disabled");
			$('#oshaTraining').attr("disabled","disabled");
			$('#hvbTest').attr("disabled","disabled");
			$('#verificationProfLicense').attr("disabled","disabled");
		}
		if("300" == $('#department').val()){
			$('#application').attr("disabled","disabled");
			$('#resume').attr("disabled","disabled");
			$('#referenceChecks').attr("disabled","disabled");
			$('#policy').attr("disabled","disabled");
			$('#statementOfConfidentiality').attr("disabled","disabled");
			$('#socialSecurityCard').attr("disabled","disabled");
			$('#nonCompete').attr("disabled","disabled");
			
			// Licenses Section
			$('#initialCompetencyEvaluation').attr("disabled","disabled");
			$('#ongoinCompetencyEvaluation').attr("disabled","disabled");
			$('#annualEvaluation').attr("disabled","disabled");
			$('#hippaTraining').attr("disabled","disabled");
			$('#oshaTraining').attr("disabled","disabled");
			$('#hvbTest').attr("disabled","disabled");
			
			// Employment Section
			$('#i9').attr("disabled","disabled");
			$('#federalW4').attr("disabled","disabled");
			$('#michiganW4').attr("disabled","disabled");
			$('#criminalCheck').attr("disabled","disabled");
			$('#authorizationCriminalCheck').attr("disabled","disabled");
			$('#fingerprintsResults').attr("disabled","disabled");
		}
	}
	
	function newEmployee(){
		$("#employeeInfoForm").attr("action","/HomeCare/loadEmployeeInfo.do?newEmployee=Y");
		$("#employeeInfoForm").submit();
	}

	function getRemindersByEmployee(employeeId){
		$("#employeeInfoForm").attr("action","/HomeCare/getRemindersByEmployee.do?employeeId="+employeeId);
		$("#employeeInfoForm").submit();
	}
	
	function getAllEmployees(){
		$("#employeeInfoForm").attr("action","/HomeCare/getAllEmployees.do");
		$("#employeeInfoForm").submit();
	}
	
	function searchEmployee(){
		$("#employeeInfoForm").attr("action","/HomeCare/getSelectedEmployeeInfo.do");
		$("#employeeInfoForm").submit();
	}
</script>