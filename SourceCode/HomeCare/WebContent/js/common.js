function isValidName(name,isMandatory){
	var validName = true;
	var rx=/^[A-Za-z]*[A-Za-z ][A-Za-z ]*$/; 
	if(!rx.test(name)){
		validName = false;
	}
	if(!isMandatory && (name== '')){
		validName = true;
	}
	return validName;		
}

function validPhoneNumber(phone){
	var reg=/^\d{3}\-?\d{3}\-?\d{4}$/; 
	return reg.test(phone);
}

function onlyAlphabetsAndSpace(string){
	var reg=/^[A-Za-z]*[A-Za-z ][A-Za-z ]*$/; 
	return reg.test(string);
}

function onlyLetters(letters){
	var reg=/^[1-9]$/; 
	return reg.test(letters);
}

function validateDate(date){
	var valid = true;
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
	return valid;
}