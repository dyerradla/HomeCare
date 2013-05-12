package com.homecare.utility;

import java.util.Date;

public class DateUtility {
	public static boolean isDateNullOrBeforeCurrentDate(Date date){
		boolean isValid = true;
		if(null != date && date.after(new Date())){
			isValid = false;
		}
		return isValid;
	}
	
	public static boolean compareDates(Date date, Date toCompareDate){
		boolean isValid = true;
		if(null != date && null != toCompareDate && date.after(toCompareDate)){
			isValid = false;
		}
		return isValid;
	}
	
}
