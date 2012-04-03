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
			<td>Last name:<form:input type="text" path="employeeInfo.lastName"></form:input><input type="button" value="Search Employee" onclick="searchEmployee()"/></td>
			<td><input type="button" value="Get Reminders" onclick="getReminders()"></td>
		</tr>
	</table>
	<BR>
	<table>
		<tr>
			<td>
				
				<table>
					<tr>
						<td>First Name:</td>
						<td><form:input path="employeeInfo.firstName" /></td>
					
						<td>Middle Name:</td>
						<td><form:input path="employeeInfo.middleName" /></td>
					
						<td>Last Name:</td>
						<td><form:input path="employeeInfo.lastName" /></td>
					</tr>
					<tr>
						<td>Designation:</td>
						<td><form:input path="employeeInfo.designation" /></td>
					</tr>
				</table>
				
				<fieldset>
				<legend>Basics</legend>
				<table>
					<tr>
						<td>Application:</td>
						<td>
							<form:select path="employeeInfo.application">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
                        </td>
					
						<td>Resume:</td>
						<td>
							<form:select path="employeeInfo.resume">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
                        </td>
					
						<td>Reference Checks:</td>
						<td>
							<form:select path="employeeInfo.referenceChecks">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>
					</tr>
					
					<tr>
						<td>Signed Job Description:</td>
						<td>
							<form:select path="employeeInfo.signedJobDescription">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>

						<td>Policy:</td>
						<td>
							<form:select path="employeeInfo.policy">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>

						<td>Orientation Checklist:</td>
						<td>
							<form:select path="employeeInfo.orientationChecklist">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>
					</tr>
					
					<tr>
						<td>Statement Of Confidentiality:</td>
						<td>
							<form:select path="employeeInfo.statementOfConfidentiality">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>
					
						<td>Social Security Card:</td>
						<td>
							<form:select path="employeeInfo.socialSecurityCard">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>
						
						<td>NonCompete:</td>
						<td>
							<form:select path="employeeInfo.nonCompete">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>
					</tr>
					
					<tr>
						<td>Email Address:</td>
						<td><form:input path="employeeInfo.emailAddress" /></td>
					</tr>
					<tr>
						<td>Phone Number:</td>
						<td><form:input path="employeeInfo.phoneNumber" /></td>
					</tr>
				</table>
				</fieldset>
				
				<fieldset>
				<legend>Licenses</legend>
				<table>
					<tr>
						<td>Initial Competency Evaluation:</td>
						<td><form:input path="employeeInfo.initialCompetencyEvaluation" cssClass="datepicker"/></td>
					
						<td>Ongoing Competency Evaluation:</td>
						<td><form:input path="employeeInfo.ongoinCompetencyEvaluation" cssClass="datepicker"/></td>
					
						<td>Annual Evaluation:</td>
						<td><form:input path="employeeInfo.annualEvaluation" cssClass="datepicker"/></td>
					</tr>
					
					<tr>
						<td>Prof License:</td>
						<td><form:input path="employeeInfo.profLicense" cssClass="datepicker"/></td>
					
						<td>Verification Prof License:</td>
						<td>
							<form:select path="employeeInfo.verificationProfLicense">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>
					
						<td>CPR Card:</td>
						<td><form:input path="employeeInfo.cprCard" cssClass="datepicker"/></td>
					</tr>
					
					<tr>
						<td>TB Test:</td>
						<td><form:input path="employeeInfo.tbTest" cssClass="datepicker"/></td>
					
						<td>Hippa Training:</td>
						<td>
							<form:select path="employeeInfo.hippaTraining">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>
					
						<td>osha Training:</td>
						<td>
							<form:select path="employeeInfo.oshaTraining">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>
					</tr>
					
					<tr>
						<td>HVB Test:</td>
						<td>
							<form:select path="employeeInfo.hvbTest">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>
					
						<td>Drivers License:</td>
						<td><form:input path="employeeInfo.driversLicense" cssClass="datepicker"/></td>
					
						<td>Proof Of Valid Car Insurance:</td>
						<td><form:input path="employeeInfo.proofValidCarInsurance" cssClass="datepicker"/></td>
					</tr>
					
				</table>
				</fieldset>
					
				<fieldset>
				<legend>Employment</legend>
				<table>
					<tr>
						<td>I9:</td>
						<td>
							<form:select path="employeeInfo.i9">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>

						<td>Federal W4:</td>
						<td>
							<form:select path="employeeInfo.federalW4">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>

						<td>Michigan W4:</td>
						<td>
							<form:select path="employeeInfo.michiganW4">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>
					</tr>
					
					<tr>
						<td>Criminal Check:</td>
						<td>
							<form:select path="employeeInfo.criminalCheck">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>
						
						<td>Authorization Criminal Check:</td>
						<td>
							<form:select path="employeeInfo.authorizationCriminalCheck">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>
					
						<td>Fingerprints Results:</td>
						<td>
							<form:select path="employeeInfo.fingerprintsResults">
					  			<form:option value='X' label="--Select--" />
					  			<form:options items="${yesNoList}" />
				       		</form:select>
						</td>
					</tr>
				</table>
				</fieldset>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form:form>
<script>
	function getReminders(){
		$("#employeeInfoForm").attr("action","/HomeCare/getReminders.do");
		$("#employeeInfoForm").submit();
	}
	
	function searchEmployee(){
		$("#employeeInfoForm").attr("action","/HomeCare/getSelectedEmployeeInfo.do");
		$("#employeeInfoForm").submit();
	}

</script>