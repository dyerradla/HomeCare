function validateForm(){
	var errorMessage = "";
	var errorExists = false;
	if(!isValidName($('#firstName').val(),true)){
		errorExists = true;
		errorMessage += "Please Enter Valid First Name" + "\n";
	}
	
	if(!isValidName($('#lastName').val(),true)){
		errorExists = true;
		errorMessage += "Please Enter Valid Last Name" + "\n";
	}
	
	if(!isValidName($('#middleName').val(),false)){
		errorExists = true;
		errorMessage += "Please Enter Valid Middle Name" + "\n";
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
	
	if(!validPhoneNumber( $('#phoneNumber').val())){
		errorExists = true;
		errorMessage += "Please Enter valid Phone Number" + "\n";
	}
	
	if(!onlyAlphabetsAndSpace($('#designation').val())){
		errorExists = true;
		errorMessage += "Please Enter valid Designation" + "\n";
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

function submitEmployee(){
	$("#employeeInfoForm").attr("action","/HomeCare/saveEmployeeInfo.do");
	if(!validateForm()){
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
//		$('#initialCompetencyEvaluation').attr("disabled","disabled");
//		$('#ongoinCompetencyEvaluation').attr("disabled","disabled");
//		$('#annualEvaluation').attr("disabled","disabled");
//		$('#hippaTraining').attr("disabled","disabled");
//		$('#oshaTraining').attr("disabled","disabled");
//		$('#hvbTest').attr("disabled","disabled");
		
		// Employment Section
		$('#i9').attr("disabled","disabled");
		$('#federalW4').attr("disabled","disabled");
		$('#michiganW4').attr("disabled","disabled");
		$('#criminalCheck').attr("disabled","disabled");
		$('#authorizationCriminalCheck').attr("disabled","disabled");
		$('#fingerprintsResults').attr("disabled","disabled");
	}
}
