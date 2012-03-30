<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="styles/common.css" type="text/css">
<link rel="stylesheet" href="styles/jquery-ui-1.8.18.custom.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
 <!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>-->
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
				<table>
					<tr>
						<td>First Name:</td>
						<td><form:input path="employeeInfo.firstName" /></td>
					</tr>
					<tr>
						<td>Middle Name:</td>
						<td><form:input path="employeeInfo.middleName" /></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><form:input path="employeeInfo.lastName" /></td>
					</tr>
					<tr>
						<td>designation:</td>
						<td><form:input path="employeeInfo.designation" /></td>
					</tr>
					<tr>
						<td>application:</td>
						<td>
							<form:radiobutton path="employeeInfo.application" value="Y" label="Y" />
							<form:radiobutton path="employeeInfo.application" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>resume:</td>
						<td>
							<form:radiobutton path="employeeInfo.resume" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.resume" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>referenceChecks:</td>
						<td>
							<form:radiobutton path="employeeInfo.referenceChecks" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.referenceChecks" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>signedJobDescription:</td>
						<td>
							<form:radiobutton path="employeeInfo.signedJobDescription" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.signedJobDescription" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>orientationChecklist:</td>
						<td>
							<form:radiobutton path="employeeInfo.orientationChecklist" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.orientationChecklist" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>statementOfConfidentiality:</td>
						<td>
							<form:radiobutton path="employeeInfo.statementOfConfidentiality" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.statementOfConfidentiality" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>policy:</td>
						<td>
							<form:radiobutton path="employeeInfo.policy" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.policy" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>initialCompetencyEvaluation:</td>
						<td><form:input path="employeeInfo.initialCompetencyEvaluation" cssClass="datepicker"/></td>
					</tr>
					<tr>
						<td>ongoinCompetencyEvaluation:</td>
						<td><form:input path="employeeInfo.ongoinCompetencyEvaluation" cssClass="datepicker"/></td>
					</tr>
					<tr>
						<td>annualEvaluation:</td>
						<td><form:input path="employeeInfo.annualEvaluation" cssClass="datepicker"/></td>
					</tr>
					<tr>
						<td>hippaTraining:</td>
						<td>
							<form:radiobutton path="employeeInfo.hippaTraining" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.hippaTraining" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>oshaTraining:</td>
						<td>
							<form:radiobutton path="employeeInfo.oshaTraining" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.oshaTraining" value="N" label="N" />
						</td>
					</tr>
					
				</table>		
			</td>
			<td>
				<table>
					<tr>
						<td>cprCard:</td>
						<td><form:input path="employeeInfo.cprCard" cssClass="datepicker"/></td>
					</tr>
					<tr>
						<td>profLicense:</td>
						<td><form:input path="employeeInfo.profLicense" cssClass="datepicker"/></td>
					</tr>
					<tr>
						<td>verificationProfLicense:</td>
						<td>
							<form:radiobutton path="employeeInfo.verificationProfLicense" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.verificationProfLicense" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>socialSecurityCard:</td>
						<td>
							<form:radiobutton path="employeeInfo.socialSecurityCard" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.socialSecurityCard" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>nonCompete:</td>
						<td>
							<form:radiobutton path="employeeInfo.nonCompete" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.nonCompete" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>driversLicense:</td>
						<td><form:input path="employeeInfo.driversLicense" cssClass="datepicker"/></td>
					</tr>
					<tr>
						<td>proofValidCarInsurance:</td>
						<td><form:input path="employeeInfo.proofValidCarInsurance" cssClass="datepicker"/></td>
					</tr>
					<tr>
						<td>authorizationCriminalCheck:</td>
						<td>
							<form:radiobutton path="employeeInfo.authorizationCriminalCheck" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.authorizationCriminalCheck" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>criminalCheck:</td>
						<td>
							<form:radiobutton path="employeeInfo.criminalCheck" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.criminalCheck" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>fingerprintsResults:</td>
						<td>
							<form:radiobutton path="employeeInfo.fingerprintsResults" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.fingerprintsResults" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>federalW4:</td>
						<td>
							<form:radiobutton path="employeeInfo.federalW4" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.federalW4" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>michiganW4:</td>
						<td>
							<form:radiobutton path="employeeInfo.michiganW4" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.michiganW4" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>i9:</td>
						<td>
							<form:radiobutton path="employeeInfo.i9" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.i9" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>tbTest:</td>
						<td><form:input path="employeeInfo.tbTest" cssClass="datepicker"/></td>
					</tr>
					<tr>
						<td>hvbTest:</td>
						<td>
							<form:radiobutton path="employeeInfo.hvbTest" value="Y" label="Y" /> 
							<form:radiobutton path="employeeInfo.hvbTest" value="N" label="N" />
						</td>
					</tr>
					<tr>
						<td>emailAddress:</td>
						<td><form:input path="employeeInfo.emailAddress" /></td>
					</tr>
					<tr>
						<td>phoneNumber:</td>
						<td><form:input path="employeeInfo.phoneNumber" /></td>
					</tr>
					</table>		
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit"><input type="button" value="Get Reminders" onclick="getReminders()"></td>
		</tr>
	</table>
</form:form>
<script>
	function getReminders(){
		$("#employeeInfoForm").attr("action","/HomeCare/getReminders.do");
		$("#employeeInfoForm").submit();
	}

</script>