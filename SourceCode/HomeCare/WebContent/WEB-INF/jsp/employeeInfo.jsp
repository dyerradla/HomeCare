<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="styles/common.css" type="text/css">
<link rel="stylesheet" href="styles/jquery-ui-1.8.18.custom.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script>
	$(function() {
		$( '.datepicker' ).datepicker();
		$( '.datepicker' ).change(function(){
			var valid = true;
			var date = this.value;
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
			if(!valid){
				alert("Please enter the date in MM/DD/YYYY format or select it from calendar");
				this.focus();
			}
		});
	});
	
	
</script>
<form:form id="employeeInfoForm" name="employeeInfoForm" action="saveEmployeeInfo.do">
	<input type="hidden" name="employeeInfo.employeeId" value="${command.employeeInfo.employeeId}" />
	<table>
		<tr>
			<td>
				<div class="layer">
					<p class="heading">Personal </p>
					<div class="content">
						<table style="width:100%;">
							<tr>
								<td class="column_label">First Name:</td>
								<td class="column_value"><form:input id="firstName" path="employeeInfo.firstName" /></td>
								<td class="column_label">Middle Name:</td>
								<td class="column_value"><form:input path="employeeInfo.middleName" /></td>
								<td class="column_label">Last Name:</td>
								<td class="column_value"><form:input id="lastName" path="employeeInfo.lastName" /></td>
							</tr>
							<tr>
								<td class="column_label">Email Address:</td>
								<td class="column_value"><form:input id="emailAddress" path="employeeInfo.emailAddress" /></td>
								<td class="column_label">Phone Number:</td>
								<td class="column_value"><form:input id="phoneNumber" path="employeeInfo.phoneNumber" /></td>
								<td class="column_label">Designation:</td>
								<td class="column_value"><form:input id="designation" path="employeeInfo.designation" /></td>
							</tr>
							<tr>
								<td class="column_label">Employment Date:</td>
								<td class="column_value"><form:input id="employmentDate" path="employeeInfo.employmentDate" cssClass="datepicker"/></td>
								<td class="column_label">Status:</td>
								<td class="column_value">
									<form:select path="employeeInfo.status">
							  			<form:option value='A' label="Active" />
							  			<form:option value='IA' label="In Active"/>
						       		</form:select>
						       	</td>
						       	<td class="column_label">Department:</td>
								<td class="column_value">
									<form:select id="department" onchange="enableDisableFieldsOnDeptChange()" path="employeeInfo.department">
							  			<form:option value='100' label="100-Admin" />
							  			<form:option value='200' label="200-Clinical"/>
							  			<form:option value='300' label="300-Contract"/>
						       		</form:select>
						       	</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="layer">
					<p class="heading">Basics </p>
					<div class="content">
						<table>
							<tr>
								<td class="column_label">Application:</td>
								<td class="column_value">
									<form:select id="application" path="employeeInfo.application">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
		                        </td>
							
								<td class="column_label">Resume:</td>
								<td class="column_value">
									<form:select id="resume" path="employeeInfo.resume">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
		                        </td>
							
								<td class="column_label">Reference Checks:</td>
								<td class="column_value">
									<form:select id="referenceChecks" path="employeeInfo.referenceChecks">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							</tr>
							
							<tr>
								<td class="column_label">Job Description:</td>
								<td class="column_value">
									<form:select id="signedJobDescription" path="employeeInfo.signedJobDescription">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
		
								<td class="column_label">Policy:</td>
								<td class="column_value">
									<form:select id="policy" path="employeeInfo.policy">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
		
								<td class="column_label">Orientation:</td>
								<td class="column_value">
									<form:select id="orientationCheckList" path="employeeInfo.orientationChecklist">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							</tr>
							
							<tr>
								<td class="column_label">Statement Of Confidentiality:</td>
								<td class="column_value">
									<form:select id="statementOfConfidentiality" path="employeeInfo.statementOfConfidentiality">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							
								<td class="column_label">Social Security Card:</td>
								<td class="column_value">
									<form:select id="socialSecurityCard" path="employeeInfo.socialSecurityCard">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
								
								<td class="column_label">NonCompete:</td>
								<td class="column_value">
									<form:select id="nonCompete" path="employeeInfo.nonCompete">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							</tr>
						</table>
					</div>
				</div>				
				<div class="layer">
					<p class="heading">Licenses </p>
					<div class="content">
						<table>
							<tr>
								<td class="column_label">Initial Comp Eval:</td>
								<td class="column_value"><form:input id="initialCompetencyEvaluation" path="employeeInfo.initialCompetencyEvaluation" cssClass="datepicker"/></td>
							
								<td class="column_label">Ongo Comp Eval:</td>
								<td class="column_value"><form:input id="ongoinCompetencyEvaluation" path="employeeInfo.ongoinCompetencyEvaluation" cssClass="datepicker"/></td>
							
								<td class="column_label">Annual Evaluation:</td>
								<td class="column_value"><form:input id="annualEvaluation" path="employeeInfo.annualEvaluation" cssClass="datepicker"/></td>
							</tr>
							
							<tr>
								<td class="column_label">Proof License:</td>
								<td class="column_value"><form:input id="profLicense" path="employeeInfo.profLicense" cssClass="datepicker"/></td>
							
								<td class="column_label">Auto Insurance:</td>
								<td class="column_value"><form:input id="proofValidCarInsurance" path="employeeInfo.proofValidCarInsurance" cssClass="datepicker"/></td>
								
								<td class="column_label">CPR Card:</td>
								<td class="column_value"><form:input id="cprCard" path="employeeInfo.cprCard" cssClass="datepicker"/></td>
							</tr>
							
							<tr>
								<td class="column_label">TB Test:</td>
								<td class="column_value"><form:input id="tbTest" path="employeeInfo.tbTest" cssClass="datepicker"/></td>
							
								<td class="column_label">Hippa Training:</td>
								<td class="column_value">
									<form:select id="hippaTraining" path="employeeInfo.hippaTraining">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							
								<td class="column_label">Osha Training:</td>
								<td class="column_value">
									<form:select id="oshaTraining" path="employeeInfo.oshaTraining">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							</tr>
							
							<tr>
								<td class="column_label">Drivers License:</td>
								<td class="column_value"><form:input id="driversLicense" path="employeeInfo.driversLicense" cssClass="datepicker"/></td>
							
								<td class="column_label">HVB Test:</td>
								<td class="column_value">
									<form:select id="hvbTest" path="employeeInfo.hvbTest">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							
								<td class="column_label">Verification Prof License:</td>
								<td class="column_value">
									<form:select id="verificationProfLicense" path="employeeInfo.verificationProfLicense">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							</tr>
						</table>
					</div>
				</div>
					
				<div class="layer">
					<p class="heading">Employment </p>
					<div class="content">
						<table>
							<tr>
								<td class="column_label">I9:</td>
								<td class="column_value">
									<form:select id="i9" path="employeeInfo.i9">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
		
								<td class="column_label">Federal W4:</td>
								<td class="column_value">
									<form:select id="federalW4" path="employeeInfo.federalW4">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
		
								<td class="column_label">Michigan W4:</td>
								<td class="column_value">
									<form:select id="michiganW4" path="employeeInfo.michiganW4">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							</tr>
							
							<tr>
								<td class="column_label">Criminal Check:</td>
								<td class="column_value">
									<form:select id="criminalCheck" path="employeeInfo.criminalCheck">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
								
								<td class="column_label">Authorization Criminal Check:</td>
								<td class="column_value">
									<form:select id="authorizationCriminalCheck" path="employeeInfo.authorizationCriminalCheck">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							
								<td class="column_label">Fingerprints Results:</td>
								<td class="column_value">
									<form:select id="fingerprintsResults" path="employeeInfo.fingerprintsResults">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="Submit" onclick="validateForm()">
				<input type="button" value="New Employee" onclick="newEmployee()">	
				<input type="button" value="Get All Employees" onclick="getAllEmployees()">
				<input type="button" value="Get Reminders" onclick="getRemindersByEmployee(${command.employeeInfo.employeeId})">
				
			</td>
		</tr>
	</table>
</form:form>
<script>
	enableDisableFieldsOnDeptChange();
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
			return false;
		}else{
			$("#employeeInfoForm").submit();	
		}
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