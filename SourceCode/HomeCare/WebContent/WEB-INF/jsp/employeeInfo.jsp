<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="../../styles/common.css" type="text/css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form:form name="employeeInfoForm" action="saveEmployeeInfo.do">
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
						<td><form:input path="employeeInfo.referenceChecks" /></td>
					</tr>
					<tr>
						<td>signedJobDescription:</td>
						<td><form:input path="employeeInfo.signedJobDescription" /></td>
					</tr>
					<tr>
						<td>orientationChecklist:</td>
						<td><form:input path="employeeInfo.orientationChecklist" /></td>
					</tr>
					<tr>
						<td>statementOfConfidentiality:</td>
						<td><form:input path="employeeInfo.statementOfConfidentiality" /></td>
					</tr>
					<tr>
						<td>policy:</td>
						<td><form:input path="employeeInfo.policy" /></td>
					</tr>
					<tr>
						<td>initialCompetencyEvaluation:</td>
						<td><form:input path="employeeInfo.initialCompetencyEvaluation" /></td>
					</tr>
					<tr>
						<td>ongoinCompetencyEvaluation:</td>
						<td><form:input path="employeeInfo.ongoinCompetencyEvaluation" /></td>
					</tr>
					<tr>
						<td>annualEvaluation:</td>
						<td><form:input path="employeeInfo.annualEvaluation" /></td>
					</tr>
					<tr>
						<td>hippaTraining:</td>
						<td><form:input path="employeeInfo.hippaTraining" /></td>
					</tr>
					<tr>
						<td>oshaTraining:</td>
						<td><form:input path="employeeInfo.oshaTraining" /></td>
					</tr>
					
				</table>		
			</td>
			<td>
				<table>
					<tr>
						<td>cprCard:</td>
						<td><form:input path="employeeInfo.cprCard" /></td>
					</tr>
					<tr>
						<td>profLicense:</td>
						<td><form:input path="employeeInfo.profLicense" /></td>
					</tr>
					<tr>
						<td>verificationProfLicense:</td>
						<td><form:input path="employeeInfo.verificationProfLicense" /></td>
					</tr>
					<tr>
						<td>socialSecurityCard:</td>
						<td><form:input path="employeeInfo.socialSecurityCard" /></td>
					</tr>
					<tr>
						<td>nonCompete:</td>
						<td><form:input path="employeeInfo.nonCompete" /></td>
					</tr>
					<tr>
						<td>driversLicense:</td>
						<td><form:input path="employeeInfo.driversLicense" /></td>
					</tr>
					<tr>
						<td>proofValidCarInsurance:</td>
						<td><form:input path="employeeInfo.proofValidCarInsurance" /></td>
					</tr>
					<tr>
						<td>authorizationCriminalCheck:</td>
						<td><form:input path="employeeInfo.authorizationCriminalCheck" /></td>
					</tr>
					<tr>
						<td>criminalCheck:</td>
						<td><form:input path="employeeInfo.criminalCheck" /></td>
					</tr>
					<tr>
						<td>fingerprintsResults:</td>
						<td><form:input path="employeeInfo.fingerprintsResults" /></td>
					</tr>
					<tr>
						<td>federalW4:</td>
						<td><form:input path="employeeInfo.federalW4" /></td>
					</tr>
					<tr>
						<td>michiganW4:</td>
						<td><form:input path="employeeInfo.michiganW4" /></td>
					</tr>
					<tr>
						<td>i9:</td>
						<td><form:input path="employeeInfo.i9" /></td>
					</tr>
					<tr>
						<td>tbTest:</td>
						<td><form:input path="employeeInfo.tbTest" /></td>
					</tr>
					<tr>
						<td>hvbTest:</td>
						<td><form:input path="employeeInfo.hvbTest" /></td>
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
			<td colspan="2"><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form:form>
