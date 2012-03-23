<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="../../styles/common.css" type="text/css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form:form name="employeeInfoForm" action="saveEmployeeInfo.do">
	<table>
		<tr>
			<td>First Name:</td>
			<td><form:input path="firstName" /></td>
		</tr>
		<tr>
			<td>Middle Name:</td>
			<td><form:input path="middleName" /></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><form:input path="lastName" /></td>
		</tr>
		<tr>
			<td>designation:</td>
			<td><form:input path="designation" /></td>
		</tr>
		<tr>
			<td>application:</td>
			<td>
				<form:radiobutton path="application" value="Y" label="Y" />
				<form:radiobutton path="application" value="N" label="N" />
			</td>
		</tr>
		<tr>
			<td>resume:</td>
			<td>
				<form:radiobutton path="resume" value="Y" label="Y" /> 
				<form:radiobutton path="resume" value="N" label="N" />
			</td>
		</tr>
		<tr>
			<td>referenceChecks:</td>
			<td><form:input path="referenceChecks" /></td>
		</tr>
		<tr>
			<td>signedJobDescription:</td>
			<td><form:input path="signedJobDescription" /></td>
		</tr>
		<tr>
			<td>orientationChecklist:</td>
			<td><form:input path="orientationChecklist" /></td>
		</tr>
		<tr>
			<td>statementOfConfidentiality:</td>
			<td><form:input path="statementOfConfidentiality" /></td>
		</tr>
		<tr>
			<td>policy:</td>
			<td><form:input path="policy" /></td>
		</tr>
		<tr>
			<td>initialCompetencyEvaluation:</td>
			<td><form:input path="initialCompetencyEvaluation" /></td>
		</tr>
		<tr>
			<td>ongoinCompetencyEvaluation:</td>
			<td><form:input path="ongoinCompetencyEvaluation" /></td>
		</tr>
		<tr>
			<td>annualEvaluation:</td>
			<td><form:input path="annualEvaluation" /></td>
		</tr>
		<tr>
			<td>hippaTraining:</td>
			<td><form:input path="hippaTraining" /></td>
		</tr>
		<tr>
			<td>oshaTraining:</td>
			<td><form:input path="oshaTraining" /></td>
		</tr>
		<tr>
			<td>cprCard:</td>
			<td><form:input path="cprCard" /></td>
		</tr>
		<tr>
			<td>profLicense:</td>
			<td><form:input path="profLicense" /></td>
		</tr>
		<tr>
			<td>verificationProfLicense:</td>
			<td><form:input path="verificationProfLicense" /></td>
		</tr>
		<tr>
			<td>socialSecurityCard:</td>
			<td><form:input path="socialSecurityCard" /></td>
		</tr>
		<tr>
			<td>nonCompete:</td>
			<td><form:input path="nonCompete" /></td>
		</tr>
		<tr>
			<td>driversLicense:</td>
			<td><form:input path="driversLicense" /></td>
		</tr>
		<tr>
			<td>proofValidCarInsurance:</td>
			<td><form:input path="proofValidCarInsurance" /></td>
		</tr>
		<tr>
			<td>authorizationCriminalCheck:</td>
			<td><form:input path="authorizationCriminalCheck" /></td>
		</tr>
		<tr>
			<td>criminalCheck:</td>
			<td><form:input path="criminalCheck" /></td>
		</tr>
		<tr>
			<td>fingerprintsResults:</td>
			<td><form:input path="fingerprintsResults" /></td>
		</tr>
		<tr>
			<td>federalW4:</td>
			<td><form:input path="federalW4" /></td>
		</tr>
		<tr>
			<td>michiganW4:</td>
			<td><form:input path="michiganW4" /></td>
		</tr>
		<tr>
			<td>i9:</td>
			<td><form:input path="i9" /></td>
		</tr>
		<tr>
			<td>tbTest:</td>
			<td><form:input path="tbTest" /></td>
		</tr>
		<tr>
			<td>hvbTest:</td>
			<td><form:input path="hvbTest" /></td>
		</tr>
		<tr>
			<td>emailAddress:</td>
			<td><form:input path="emailAddress" /></td>
		</tr>
		<tr>
			<td>phoneNumber:</td>
			<td><form:input path="phoneNumber" /></td>
		</tr>
		<tr>
			<td>phoneNumber:</td>
			<td><form:input path="phoneNumber" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form:form>