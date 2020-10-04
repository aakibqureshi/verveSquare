package com.vervesquare.qa.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestUtil {

	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICITLY_WAIT = 10;
	
	public int setDate5DaysFromToday() {
		
		  DateTimeFormatter date = DateTimeFormatter.ofPattern("dd");  
		   LocalDateTime now = LocalDateTime.now();  
		   int todaysDate = Integer.parseInt(date.format(now));
		   return todaysDate+6;
		   
	}
	
	public int setDate6DaysFromToday() {
		  DateTimeFormatter date = DateTimeFormatter.ofPattern("dd");  
		   LocalDateTime now = LocalDateTime.now();  
		   int todaysDate = Integer.parseInt(date.format(now));
		   return todaysDate+9;
		   
	}
	
	
	
	
}
