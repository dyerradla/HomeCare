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
								<td class="column_value"><form:input path="employeeInfo.phoneNumber" /></td>
								<td class="column_label">Designation:</td>
								<td class="column_value"><form:input path="employeeInfo.designation" /></td>
							</tr>
							<tr>
								<td class="column_label">Employment Date:</td>
								<td class="column_value"><form:input id="employmentDate" readonly="true" path="employeeInfo.employmentDate" cssClass="datepicker"/></td>
								<td class="column_label">Status:</td>
								<td class="column_value">
									<form:select path="employeeInfo.status">
							  			<form:option value='A' label="Active" />
							  			<form:option value='IA' label="In Active"/>
						       		</form:select>
						       	</td>
						       	<td class="column_label">Department:</td>
								<td class="column_value">
									<form:select path="employeeInfo.department">
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
									<form:select path="employeeInfo.application">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
		                        </td>
							
								<td class="column_label">Resume:</td>
								<td class="column_value">
									<form:select path="employeeInfo.resume">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
		                        </td>
							
								<td class="column_label">Reference Checks:</td>
								<td class="column_value">
									<form:select path="employeeInfo.referenceChecks">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							</tr>
							
							<tr>
								<td class="column_label">Job Description:</td>
								<td class="column_value">
									<form:select path="employeeInfo.signedJobDescription">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
		
								<td class="column_label">Policy:</td>
								<td class="column_value">
									<form:select path="employeeInfo.policy">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
		
								<td class="column_label">Orientation:</td>
								<td class="column_value">
									<form:select path="employeeInfo.orientationChecklist">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							</tr>
							
							<tr>
								<td class="column_label">Statement Of Confidentiality:</td>
								<td class="column_value">
									<form:select path="employeeInfo.statementOfConfidentiality">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							
								<td class="column_label">Social Security Card:</td>
								<td class="column_value">
									<form:select path="employeeInfo.socialSecurityCard">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
								
								<td class="column_label">NonCompete:</td>
								<td class="column_value">
									<form:select path="employeeInfo.nonCompete">
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
								<td class="column_value"><form:input readonly="true" path="employeeInfo.initialCompetencyEvaluation" cssClass="datepicker"/></td>
							
								<td class="column_label">Ongo Comp Eval:</td>
								<td class="column_value"><form:input readonly="true" path="employeeInfo.ongoinCompetencyEvaluation" cssClass="datepicker"/></td>
							
								<td class="column_label">Annual Evaluation:</td>
								<td class="column_value"><form:input readonly="true" path="employeeInfo.annualEvaluation" cssClass="datepicker"/></td>
							</tr>
							
							<tr>
								<td class="column_label">Proof License:</td>
								<td class="column_value"><form:input readonly="true" path="employeeInfo.profLicense" cssClass="datepicker"/></td>
							
								<td class="column_label">Auto Insurance:</td>
								<td class="column_value"><form:input readonly="true" path="employeeInfo.proofValidCarInsurance" cssClass="datepicker"/></td>
								
								<td class="column_label">CPR Card:</td>
								<td class="column_value"><form:input readonly="true" path="employeeInfo.cprCard" cssClass="datepicker"/></td>
							</tr>
							
							<tr>
								<td class="column_label">TB Test:</td>
								<td class="column_value"><form:input readonly="true" path="employeeInfo.tbTest" cssClass="datepicker"/></td>
							
								<td class="column_label">Hippa Training:</td>
								<td class="column_value">
									<form:select path="employeeInfo.hippaTraining">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							
								<td class="column_label">Osha Training:</td>
								<td class="column_value">
									<form:select path="employeeInfo.oshaTraining">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							</tr>
							
							<tr>
								<td class="column_label">Drivers License:</td>
								<td class="column_value"><form:input readonly="true" path="employeeInfo.driversLicense" cssClass="datepicker"/></td>
							
								<td class="column_label">HVB Test:</td>
								<td class="column_value">
									<form:select path="employeeInfo.hvbTest">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							
								<td class="column_label">Verification Prof License:</td>
								<td class="column_value">
									<form:select path="employeeInfo.verificationProfLicense">
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
									<form:select path="employeeInfo.i9">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
		
								<td class="column_label">Federal W4:</td>
								<td class="column_value">
									<form:select path="employeeInfo.federalW4">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
		
								<td class="column_label">Michigan W4:</td>
								<td class="column_value">
									<form:select path="employeeInfo.michiganW4">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							</tr>
							
							<tr>
								<td class="column_label">Criminal Check:</td>
								<td class="column_value">
									<form:select path="employeeInfo.criminalCheck">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
								
								<td class="column_label">Authorization Criminal Check:</td>
								<td class="column_value">
									<form:select path="employeeInfo.authorizationCriminalCheck">
							  			<form:option value='' label="--Select--" />
							  			<form:options items="${yesNoList}" />
						       		</form:select>
								</td>
							
								<td class="column_label">Fingerprints Results:</td>
								<td class="column_value">
									<form:select path="employeeInfo.fingerprintsResults">
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