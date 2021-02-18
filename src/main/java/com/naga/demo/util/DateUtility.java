package com.naga.demo.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
import static java.time.temporal.TemporalAdjusters.firstInMonth;
@Component
public class DateUtility {

	private Timestamp timestamp;
	
	public String changeDateFormat(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String formatDate=LocalDate.parse(date, formatter).format(formatter2);
		
	    return formatDate;
		
	}
	
	
	public java.util.Date convertStringToDate(String date)  {
		java.util.Date uDate =null;
		try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         uDate = sdf.parse(date);
		}catch(Exception exception) {
			exception.printStackTrace();
		}
        return uDate;
    }
	
	public java.util.Date convertStringToMySql(String sourceDate) {

	    // hold the converted date object of String.
	    java.util.Date targetDate = null;
	    try {
	        targetDate = new java.text.SimpleDateFormat("MM/dd/yyyy").parse(sourceDate);
	    } catch (ParseException ex) {
	        ex.printStackTrace();
	    }
	    return targetDate;
	}

	public Date getMysqlDate(String sourceDate) {
	    Date sqlDate = Date.valueOf(new java.text.SimpleDateFormat("yyyy-MM-dd").format(convertStringToMySql(sourceDate)));
	    return sqlDate;
	}

	public Timestamp getCurrentMySqlDateTime() {

	    Calendar calendar = Calendar.getInstance();
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    
	    return timestamp.valueOf(simpleDateFormat.format(calendar.getTime()).toString());
	}
	
	
	public String convertDateToMySql1(java.util.Date sourceDate) {
	    return new java.text.SimpleDateFormat("yyyy-MM-dd").format(sourceDate);
	}
	
	
	public java.util.Date getCurrentDate() {
		java.util.Date date=null;
		try {
			date=new java.util.Date();  
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	    return date;
	}
	
	
	
	public String convert_dd_mm_yyyy_to_yyyy_mm_dd(String date) {
	/*	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    
	    */
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String formatDate=LocalDate.parse(date, formatter).format(formatter2);
		
	    return formatDate;
		
	}
	
	
	public boolean isValidFormat(String value,String format) {
		java.util.Date date = null;
		try {
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(value);
			if (!value.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return date != null;
	}
	
	
	public java.util.Date convertStringToDate_dd_MM_yyyy(String date)  {
		java.util.Date uDate =null;
		try {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
         uDate = sdf.parse(date);
		}catch(Exception exception) {
			exception.printStackTrace();
		}
        return uDate;
    }
	
	
	public String getCurrentFinancialYear() {
		String financialYear ="";
		int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);
         int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
         
         if(day<=5 && month==3){
             year=year-1;
         }
        
         if (month >= 3) {
            
        	 financialYear="April" + year + "-March" + (year + 1);
           
         } else {
            
        	 financialYear="April" + (year - 1) + "-March" + (year);
           
         }
         
         
			
		    return financialYear;
			
		}
	
	public String convert_yyyy_mm_dd_to_dd_mm_yyyy(String date) {
	/*	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    
	    */
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    String formatDate=LocalDate.parse(date, formatter).format(formatter2);
		
	    return formatDate;
		
	}
	
	
	public int getDayOfWeekFromDate(String sourceDate,String format) {
		int day = 0;
		try {
		java.util.Date targetDate = new java.text.SimpleDateFormat(format).parse(sourceDate);
		//  Date now = new Date(input_date);
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(targetDate);
	       day = (calendar.get(Calendar.DAY_OF_WEEK));
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		return day;
	}
	
	
	
	public String addNumberOfDaysToDate(String date,String format,int numberOfDays) {
		String resultDate="";
		try {
			//Given Date in String format
			//String oldDate = "2017-01-29";  
			String oldDate = date;
			//System.out.println("Date before Addition: "+oldDate);
			//Specifying date format that matches the given date
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Calendar c = Calendar.getInstance();
			
			   //Setting the date to the given date
			   c.setTime(sdf.parse(oldDate));
			
			   
			//Number of Days to add
			c.add(Calendar.DAY_OF_MONTH, numberOfDays);  
			//Date after adding the days to the given date
			 resultDate = sdf.format(c.getTime());  
			//Displaying the new Date after addition of Days
			//System.out.println("Date after Addition: "+resultDate);
			
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return resultDate;
		
	}
	
	
	
	public String getDayFullNameFromDate(String date,String format) {
		String dayName="";
		try {
		java.util.Date targetDate = new java.text.SimpleDateFormat(format).parse(date);
		
		 Format dateFormat = new SimpleDateFormat("EEEE");
		 dayName = dateFormat.format(targetDate);
	      
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return dayName;
	}
	
	
	
	public String getToDayDateToView(String format) {

        DateFormat dateFormat = new SimpleDateFormat(format);
        java.util.Date currentDate = new java.util.Date();
        return dateFormat.format(currentDate);
    }
	
	public Date getMySqlDate(String date,String format) {
		  java.sql.Date sqlDate =null;
		try {
	     SimpleDateFormat sdf = new SimpleDateFormat(format);
	     java.util.Date uDate = sdf.parse(date);
	      sqlDate = new java.sql.Date(uDate.getTime());
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	     return sqlDate;
	 }
	
	
	public boolean checkFutureDate(String date, String format) {
		boolean isFutureDate=false;
		try {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		 java.util.Date date1 = sdf.parse(date);
		  
	        java.util.Date date2 = new java.util.Date();
	         //Date1 is after Date2
	        if (date1.after(date2) ) {
	        	isFutureDate = true;
	        	
	        }
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return isFutureDate;
	}
	
	
	public int differenceBetweenTwoDates(String beforeDate,String afterDate,String format) {
		int diff=0;
		try {
			SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date dateBefore = myFormat.parse(beforeDate);
			java.util.Date dateAfter = myFormat.parse(afterDate);
		       long difference = dateAfter.getTime() - dateBefore.getTime();
		       diff = (int)(difference / (1000*60*60*24));
		       
		       
		}catch (Exception e) {
		       e.printStackTrace();
		 }
		return diff;
				
				
				
	}
	
	
	
	public int leavesCountBetweenTwoDays(String beforeDate,String afterDate,String format,boolean includeWeekends) {
		int leavesCount = 0;
		 DateFormat df = new SimpleDateFormat(format);
			
		    
		    
		    java.util.Date date1 = null;
		    java.util.Date date2 = null;
		     try {
		         date1 = df.parse(beforeDate);
		         date2=  df.parse(afterDate);
		     } catch (ParseException ex) {
		         ex.printStackTrace();
		     }
		 
		     
	    
	    long diff = date2.getTime() - date1.getTime();
	   
	    long diffDays = diff / (24 * 60 * 60 * 1000);
	    
	    diffDays =diffDays+1;
	  //  System.out.println("Include Sat Sundays"+diffDays);
	    
	    if(includeWeekends)
	    	leavesCount = (int)diffDays;
	    else {
	    	int count=  saturdaysundaycount(date1, date2);   
	    	long ExcludeSatSundays=diffDays-count;
	    	leavesCount = (int)ExcludeSatSundays;
	    	
	    }
	    
	    
	    //System.out.println("ExcludeSatSundays"+ExcludeSatSundays);
	    
	    return leavesCount;
	}
	
public  int saturdaysundaycount(java.util.Date d1, java.util.Date d2) {
		
	    Calendar c1 = Calendar.getInstance();
	    c1.setTime(d1);

	    Calendar c2 = Calendar.getInstance();
	    c2.setTime(d2);

	    int sundays = 0;
	    int saturday = 0;

	    while (! c1.after(c2)) {
	        if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ){
	            saturday++; 
	        }
	        if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
	            sundays++;
	        }

	        c1.add(Calendar.DATE, 1);
	    }

	   // System.out.println("Saturday Count = "+saturday);
	   // System.out.println("Sunday Count = "+sundays);
	    return saturday + sundays;
	}



//public String convert_yyyy_mm_dd_to_dd_mm_yyyy(String date) {
	public String convertDateFormat(String date,String sourceFotmat,String targetFormat) {
	/*	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    
	    */
	    DateTimeFormatter srcFormatter = DateTimeFormatter.ofPattern(sourceFotmat);
	    DateTimeFormatter destFormatter = DateTimeFormatter.ofPattern(targetFormat);
	    String formatDate=LocalDate.parse(date, srcFormatter).format(destFormatter);
		
	    return formatDate;
		
	}
	
	
	 public static String getCalendarStartDate(Calendar cal){
		 
		 String date  = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-01";
		 
	       /* return "" + cal.get(Calendar.DATE) +"/" +
	                (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR);
	                *
	                */
		 return date;
	    }
	 
	 
	 public static String getCalendarEndDate(Calendar cal){
		 cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		 String date  = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);
		 
	       /* return "" + cal.get(Calendar.DATE) +"/" +
	                (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR);
	                *
	                */
		 return date;
	    }
	 
	 
	 
	 public List<String> getDatesListBetweenTwoDates(String str_date,String end_date ){
		 List<String> datesList = new ArrayList<String>();
		 
		 List<java.util.Date> dates = new ArrayList<java.util.Date>();

		// String str_date ="27/08/2010";
		// String end_date ="02/09/2010";
try {
		 DateFormat formatter ; 

		 formatter = new SimpleDateFormat("MM/dd/yyyy");
		 java.util.Date  startDate = (java.util.Date)formatter.parse(str_date); 
		 java.util.Date  endDate = (java.util.Date)formatter.parse(end_date);
		 long interval = 24*1000 * 60 * 60; // 1 hour in millis
		 long endTime =endDate.getTime() ; // create your endtime here, possibly using Calendar or Date
		 long curTime = startDate.getTime();
		 while (curTime <= endTime) {
		     dates.add(new Date(curTime));
		     curTime += interval;
		 }
		 for(int i=0;i<dates.size();i++){
			 java.util.Date lDate =(java.util.Date)dates.get(i);
		     String ds = formatter.format(lDate);    
		     //System.out.println(" Date is ..." + ds);
		     datesList.add(ds);
		 }
}catch(Exception exception) {
	//exception.printStackTrace();
	System.out.println(exception.getMessage());
}
		 
		 return datesList;
	 }
	 
	 
	 
	 public List<Integer> getYearsListBetweenTwoDates(Calendar startCal,Calendar endCal){
		 List<Integer> yearsList = new ArrayList<Integer>();
		 int startYear = startCal.get(Calendar.YEAR);
		 int endYear = endCal.get(Calendar.YEAR);
		 for(int i=startYear;i<=endYear;i++) {
			 yearsList.add(i);
		 }
		 
		 
		 
		 
		 return yearsList;
	 }
	 
	 
	 public boolean checkDateBetweenTwoDates(String startDate,String endDate,String actualDate,String format) {
		 boolean isBetween = false;
		 try {
		 SimpleDateFormat sdf = new SimpleDateFormat(format);
		 java.util.Date d1 = sdf.parse(startDate);
		 java.util.Date d2 = sdf.parse(actualDate);
		 java.util.Date d3 = sdf.parse(endDate);
		 
		 
		 if (d2.compareTo(d1) >= 0) {
			 
			 if (d2.compareTo(d3) <= 0) {
				 isBetween = true;
			 }
		 }
		 }catch(Exception exception) {
				//exception.printStackTrace();
				System.out.println(exception.getMessage());
			}
		 
		 
		 return isBetween;
		 
	 }
	 
	 
	 
	 
	 public List<String> getCurrentWeekDaysList() {
		 List<String> datesList = new ArrayList<String>();
		 SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("MM/dd/yyyy");
		 
		 Calendar currentCalendar = Calendar.getInstance();
		 currentCalendar.set(Calendar.DAY_OF_WEEK,
				 currentCalendar.getActualMinimum(Calendar.DAY_OF_WEEK));
	        java.util.Date currentWeekStart = currentCalendar.getTime();
	        
	        
	        
	        
	        String date = simpleDateFormat.format(currentWeekStart);
	        datesList.add(date);
	        //System.out.println("date--"+date);
	        
	        for(int i=1;i<=6;i++) {
	        	currentCalendar.add(Calendar.DAY_OF_WEEK, 1);
	        	 java.util.Date tempDate = currentCalendar.getTime();
	        	 date = simpleDateFormat.format(tempDate);
	        	 //System.out.println("date--"+date);
	        	 datesList.add(date);
	        }
	        
	        
	        
		 
		 
		 return datesList;
	 }
	 
	 
	 
	 
	 public String getCurrentWeekStartDate(String format) {
 SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(format);
		 
		 Calendar currentCalendar = Calendar.getInstance();
		 currentCalendar.set(Calendar.DAY_OF_WEEK,
				 currentCalendar.getActualMinimum(Calendar.DAY_OF_WEEK));
		 
		
		 
		 
		 
	        java.util.Date currentWeekStart = currentCalendar.getTime();
	        
	        
	        
	        
	        String date = simpleDateFormat.format(currentWeekStart);
	        
	        
	        return date;
	 }
	 
	 
	 public String getCurrentWeekEndDate(String format) {
		 SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(format);
				 
				 Calendar currentCalendar = Calendar.getInstance();
				 currentCalendar.set(Calendar.DAY_OF_WEEK,
						 currentCalendar.getActualMinimum(Calendar.DAY_OF_WEEK));
				 
				 currentCalendar.add(Calendar.DAY_OF_WEEK, 6);
			        java.util.Date currentWeekEnd = currentCalendar.getTime();
			        
			        
			        
			        
			        String date = simpleDateFormat.format(currentWeekEnd);
			        
			        
			        return date;
			 }
	 
	 
	 
	 public String getYearFromDateString(String date,String format) {
		 String year = "";
		 try {
			 Calendar c = Calendar.getInstance();  
			 year = String.valueOf(c.get(Calendar.YEAR));
			 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		 java.util.Date parse = sdf.parse(date);  
		 
		 c.setTime(parse);  
		 year = String.valueOf(c.get(Calendar.YEAR));
	//	 System.out.println(c.get(Calendar.MONTH) + c.get(Calendar.DATE) + c.get(Calendar.YEAR)); 
		 }catch(Exception exception) {
			 System.out.println(exception.getMessage());
		 }
		 
		 return year;
	 }
	 
	 
	 
	 public String getCurrentDateTime(String format) {
		 String responseString ="";
	DateFormat sdf = new SimpleDateFormat(format);
		 java.util.Date date = new java.util.Date();
		 responseString=sdf.format(date);
	        //System.out.println(sdf.format(date));
	        return responseString;
	 }
	 
	/* public static String convertEmailTemplateFormat2(String date,String sourceFotmatStr) {
			// November 5th, 2019
			String outputFormat = "";
			String yourDate = "";
			SimpleDateFormat format = new SimpleDateFormat("d");
			try {
				// SimpleDateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat sourceFormat = new SimpleDateFormat(sourceFotmatStr);
				java.util.Date sourceDate = sourceFormat.parse(date);
				// SimpleDateFormat outputFormatDay = new SimpleDateFormat("d");
				// SimpleDateFormat outputFormatMonth = new SimpleDateFormat("MMMMM");

				if (date.endsWith("1") && !date.endsWith("11"))
					format = new SimpleDateFormat("d'st' MMMM',' yyyy");
				else if (date.endsWith("2") && !date.endsWith("12"))
					format = new SimpleDateFormat("d'nd' MMMM',' yyyy");
				else if (date.endsWith("3") && !date.endsWith("13"))
					format = new SimpleDateFormat("d'rd' MMMM',' yyyy");
				else
					format = new SimpleDateFormat("d'th' MMMM',' yyyy");

				yourDate = format.format(sourceDate);

			
			} catch (Exception e) {
				e.printStackTrace();
			}

			return yourDate;
		}
	 */
	 
	 public static String convertEmailTemplateFormat2(String date,String sourceFotmatStr) {
			// November 5th, 2019
			String outputFormat = "";
			String yourDate = "";
			SimpleDateFormat format = new SimpleDateFormat("d");
			try {
				// SimpleDateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat sourceFormat = new SimpleDateFormat(sourceFotmatStr);
				java.util.Date sourceDate = sourceFormat.parse(date);
				// SimpleDateFormat outputFormatDay = new SimpleDateFormat("d");
				// SimpleDateFormat outputFormatMonth = new SimpleDateFormat("MMMMM");
				String daysOfDate = String.valueOf(sourceDate.getDate());
				
				
				if (daysOfDate.endsWith("1") || !daysOfDate.endsWith("11"))
					format = new SimpleDateFormat("d'st' MMMM',' yyyy");
				else if (daysOfDate.endsWith("2") ||  !daysOfDate.endsWith("12"))
					format = new SimpleDateFormat("d'nd' MMMM',' yyyy");
				else if (daysOfDate.endsWith("3")  ||  !daysOfDate.endsWith("13"))
					format = new SimpleDateFormat("d'rd' MMMM',' yyyy");
				else
					format = new SimpleDateFormat("d'th' MMMM',' yyyy");

				yourDate = format.format(sourceDate);

				/*
				 * String day = outputFormatDay.format(sourceDate); String monthName =
				 * outputFormatMonth.format(sourceDate); String dayFormat = day;
				 */

				// time24= _24HourSDF.format(_12HourDt);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return yourDate;
		}
	 
	 
		public  String getLastWeekfirstDay(String format) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new java.util.Date());

			cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			cal.add(Calendar.WEEK_OF_YEAR, -1);
			java.util.Date date23 = cal.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			// Parsing the given String to Date object
			String date43 = formatter.format(date23);
			return date43;
		}
		
		public boolean isFutureUpdateDate(String firstDate,String secondDate,String format) {
			boolean isFutureUpdateDate=false;
			try {												
				
				
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				java.util.Date createdDate1=sdf.parse(firstDate);
				java.util.Date endDate1 = sdf.parse(secondDate);
				
				 if (endDate1.after(createdDate1) ) {
			        	isFutureUpdateDate = true;
			        	
			        }
				System.out.println("isFutureUpdateDate"+isFutureUpdateDate);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return isFutureUpdateDate;
		}
		
		
		
		public String getDateFromTimestamp(Timestamp timestamp,String format) {
			String resultDate="";
			
			 Date date=new Date(timestamp.getTime());  
			 DateFormat dateFormat = new SimpleDateFormat(format);  
			  resultDate = dateFormat.format(date);  
			
			return resultDate;
		}
		
		
		
		 public  String convertDateTimeFormatForEmail(String date,String sourceFotmatStr) {
				// November 5th, 2019
				String outputFormat = "";
				String yourDate = "";
				SimpleDateFormat format = new SimpleDateFormat("d");
				try {
					// SimpleDateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy");
					SimpleDateFormat sourceFormat = new SimpleDateFormat(sourceFotmatStr);
					java.util.Date sourceDate = sourceFormat.parse(date);
					// SimpleDateFormat outputFormatDay = new SimpleDateFormat("d");
					// SimpleDateFormat outputFormatMonth = new SimpleDateFormat("MMMMM");
					String daysOfDate = String.valueOf(sourceDate.getDate());
					
					
					if (daysOfDate.endsWith("1") && !daysOfDate.endsWith("11"))
						format = new SimpleDateFormat("d'st' MMMM',' yyyy 'at' hh:mm a");
					else if (daysOfDate.endsWith("2") && !daysOfDate.endsWith("12"))
						format = new SimpleDateFormat("d'nd' MMMM',' yyyy 'at' hh:mm a");
					else if (daysOfDate.endsWith("3") && !daysOfDate.endsWith("13"))
						format = new SimpleDateFormat("d'rd' MMMM',' yyyy 'at' hh:mm a");
					else
						format = new SimpleDateFormat("d'th' MMMM',' yyyy 'at' hh:mm a");

					yourDate = format.format(sourceDate);

					/*
					 * String day = outputFormatDay.format(sourceDate); String monthName =
					 * outputFormatMonth.format(sourceDate); String dayFormat = day;
					 */

					// time24= _24HourSDF.format(_12HourDt);
				} catch (Exception e) {
					e.printStackTrace();
				}

				return yourDate;
			}
		 
		
		 
		 
		 
		 
		 
		 
		 public long getDifferenceBetweenTwoDateesInMinutes(java.util.Date startDate,java.util.Date endDate) {
			 long diffInMinutes = 0;
			 
			 Calendar calendar1 = Calendar.getInstance();
			    calendar1.setTime(startDate);
			    
			    int year1 =  calendar1.get(Calendar.YEAR);
			    int month1 = calendar1.get(Calendar.MONTH)+1;
			    int day1 = calendar1.get(Calendar.DAY_OF_MONTH);
			    
			    int hour1  = calendar1.get(Calendar.HOUR_OF_DAY);
			    int minute1  = calendar1.get(Calendar.MINUTE);
			    
			    
			    Calendar calendar2 = Calendar.getInstance();
			    calendar2.setTime(endDate);
			    
			    int year2 =  calendar2.get(Calendar.YEAR);
			    int month2 = calendar2.get(Calendar.MONTH)+1;
			    int day2 = calendar2.get(Calendar.DAY_OF_MONTH);
			    
			    int hour2  = calendar2.get(Calendar.HOUR_OF_DAY);
			    int minute2  = calendar2.get(Calendar.MINUTE);

			    
			    
			 LocalDateTime dateTime = LocalDateTime.of(year1, month1, day1, hour1, minute1);
		     LocalDateTime dateTime2 = LocalDateTime.of(year2, month2, day2, hour2, minute2);
		      diffInMinutes = java.time.Duration.between(dateTime, dateTime2).toMinutes();
		     
		     
		     return diffInMinutes;
		 }
		
		 
		 
		 
		 public List<String> getWeekStartDatesList(int year,int month){
			 List<String> weekStartDates = new ArrayList<String>();
			 LocalDate currentDate = LocalDate.now();
		        LocalDate now = LocalDate.of(year, month, 1);
		        LocalDate sunday = now.with(firstInMonth(DayOfWeek.SUNDAY));
		        while (sunday.getMonthValue() == month &&sunday.compareTo(currentDate)<=0 ) {
		            // Loop to get every Sunday by adding Period.ofDays(7) the the current Sunday.
		            System.out.println(sunday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		            
		            weekStartDates.add(sunday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		            
		            sunday = sunday.plus(Period.ofDays(7));
		        } 
		        
			 
			 return weekStartDates;
		 }
		 
		 
		 
		 public String addDaysToDate(String date,String format,int numberOfDays) {
			 String finalDate=date;
			 SimpleDateFormat sdf = new SimpleDateFormat(format);
				Calendar c = Calendar.getInstance();
				try{
				   //Setting the date to the given date
				   c.setTime(sdf.parse(date));
				}catch(ParseException e){
					e.printStackTrace();
				 }
				   
				//Number of Days to add
				c.add(Calendar.DAY_OF_MONTH, numberOfDays);  
				//Date after adding the days to the given date
				 finalDate = sdf.format(c.getTime());  
				
				
			 
			 return finalDate;
			 
		 }
		 
		 
		 
		 public boolean checkDaySunday(int year,int month,int day) {
			 boolean isSunday = false;
			 LocalDate date = LocalDate.of(year, month, day);
			 DayOfWeek dayName = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
			if(dayName == DayOfWeek.SUNDAY)
				isSunday = true;
			
			return isSunday;
	      }
			 
			 //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
			  //String date = year+"-"+month+day;

			  //convert String to LocalDate
			  //LocalDate localDate = LocalDate.parse(date, formatter);
			  
		public int getQuarterNumberByMonthName(String monthName) {
			int quarterNumber=1;
			
			if("January".equalsIgnoreCase(monthName)) {
		    	quarterNumber = 1;
		    	
		    }
		   
		    else if("April".equalsIgnoreCase(monthName)) {
		    	quarterNumber = 2;
		    	
		    }
		    else if("July".equalsIgnoreCase(monthName)) {
		    	quarterNumber = 3;
		    	
		    }
		    	  else if("October".equalsIgnoreCase(monthName)) {
		    	quarterNumber = 4;
		    }
		    	
			return quarterNumber;
			
		}
		
		
		
		
		
		public int getDaysDiffreenceFromCurrentDate(String date,String format) {
			int diffDays = 0;
		try {
		    SimpleDateFormat formatter1=new SimpleDateFormat(format);  
		    java.util.Date date1=formatter1.parse(date);  
		    
		    java.util.Date currentDate = new java.util.Date();
		    long duration  = currentDate.getTime() - date1.getTime();

		    long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
		    diffDays = (int)diffInDays;
		    
		}catch(Exception exception) {
			
		}
			
			return diffDays; 
		    
			
			
		}
		
		
		public String getcontactWithinDate(int didNotContactWithin ) {
			SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, -didNotContactWithin);
			java.util.Date date= calendar.getTime();
			String dateFinal=dateformat.format(date);
			return dateFinal;
			}
		
		
		
		
		public String getCompofApprovalDate() {
			
			String date="";
			try {
				SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
			String stringDate=getCurrentDateTime("yyyy-MM-dd");
			java.util.Date date1=dateformat.parse(stringDate);  
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			    
			// manipulate date
			cal.add(Calendar.DATE, 6); 
			java.util.Date dateWith6Days = cal.getTime();
			date = dateformat.format(dateWith6Days);
			System.out.println(dateWith6Days);
			
			date =convertEmailTemplateFormat2(date,"yyyy-MM-dd");
			
			}catch(Exception exception) {
				
			}
			return date;
			
		}
		
		
		
		
		
	public String getCompofApprovalDateFromCreatedDate(String createdDate) {
			
			String date="";
			try {
				SimpleDateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
		
			java.util.Date date1=dateformat.parse(createdDate);  
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			    
			// manipulate date
			cal.add(Calendar.DATE, 6); 
			java.util.Date dateWith6Days = cal.getTime();
			date = dateformat.format(dateWith6Days);
			System.out.println(dateWith6Days);
			
			date =convertEmailTemplateFormat2(date,"MM/dd/yyyy");
			
			}catch(Exception exception) {
				
			}
			return date;
			
		}
		
		public String changeFormatWithTime(String value,String sourceFormat,String destFormat) {
			String returnDate=null;
			try {
			  SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(sourceFormat);
			  SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(destFormat);
			  java.util.Date	actDate = simpleDateFormat1.parse(value);
			  
			  returnDate = simpleDateFormat2.format(actDate);
			}catch(Exception exception) {
				
			}
			 return returnDate;
		}
		
		
		
		
		
		
		public boolean isDateInCurrentWeek(String date,String format) {
			
			  SimpleDateFormat sdf = new SimpleDateFormat(format);
			  
			  int targetWeek = 0;
			  int targetYear = 0;
			  
			  int week = 0;
			  int year = 0;
			try {
				
			  java.util.Date uDate = sdf.parse(date);
			  //current week data
			  Calendar currentCalendar = Calendar.getInstance();
			   week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
			   year = currentCalendar.get(Calendar.YEAR);

			  //input week data
			  Calendar targetCalendar = Calendar.getInstance();
			  //setting current date to calendar
			  targetCalendar.setTime(uDate);		  
			   targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
			   targetYear = targetCalendar.get(Calendar.YEAR);

			 		  
			}catch (ParseException e) {
				e.printStackTrace();
			}
			 return week == targetWeek && year == targetYear && week != 0 && year != 0;
			}
		
		
		public  boolean isBetweenCurrentMonth(String date,String format) {
			SimpleDateFormat sdf  = null;
			java.util.Date givenDate = null;
			java.util.Date today =null;
			
			try {
				 sdf = new SimpleDateFormat(format);
				 givenDate = sdf.parse(date);
			     today = new java.util.Date();

			}catch (Exception e) {
				e.printStackTrace();
			}
			 
		    return givenDate.getMonth() == today.getMonth() && givenDate.getYear() == today.getYear();
		}
		
		public boolean isCurrentDate(String date,String format) {
			SimpleDateFormat sdf  = null;
			java.util.Date givenDate = null;
			java.util.Date today =null;
			
			try {
				 sdf = new SimpleDateFormat(format);
				 givenDate = sdf.parse(date);
			     today = new java.util.Date();

			}catch (Exception e) {
				e.printStackTrace();
			}
			 
		    return givenDate.getMonth() == today.getMonth() && givenDate.getYear() == today.getYear() && givenDate.getDate() == today.getDate();
		} 
		
		/*
		 * end of date changes on 28-01-2021 by Naga Sai Bade
		 */
}
