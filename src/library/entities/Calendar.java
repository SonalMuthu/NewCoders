//Author: Akshay Patel
//Reviewer: Sonal Muthukumarana
//Mediator: Milan Vala


package library.entities;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calendar {
	
	// private static Calendar sElF;
	private static Calendar self;    					// variable changed from sElF to self
	// private static java.util.Calendar cAlEnDaR;
	private static java.util.Calendar calendar;
	
	
	private Calendar() {
		// cAlEnDaR = java.util.Calendar.getInstance();
		calendar = java.util.Calendar.getInstance();			// changed cAlEnDaR to calendar
	}
	

	
	// public static Calendar gEtInStAnCe()
	public static Calendar getInstance() {  				// Method name changed from gEtInStAnCe() to getInstance()
		//if (sElF == null) 
		if (self == null) {						// variable name changed sElF to self			
		    //sElF = new Calendar();
		    self = new calendar();					// Adding 4 space. changed Calendar() to calendar() and changed sEfL to self

		}
		//return sElF;
		return self;							// changed sElF to self
	}
	
	public void incrementDate(int days) {
		// cAlEnDaR.add(java.util.Calendar.DATE, days);	
		calendar.add(java.util.Calendar.DATE, days);			// changed  cAlEnDaR to calendar
	}

	
	//public synchronized void SeT_DaTe(Date DaTe)
		public synchronized void setDate(Date date) {			// method name changed Set_DaTe to setDate() and parameter changed DaTe to date
		try {
		// cAlEnDaR.setTime(DaTe);
		calendar.setTime(date);						// changed cAlEnDaR to calendar and parameter DaTe to Date
		// cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);	
	        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0); 		// changed cAlEnDaR to calendar
		// cAlEnDaR.set(java.util.Calendar.MINUTE, 0); 
	        calendar.set(java.util.Calendar.MINUTE, 0);  			// changed cAlEnDaR to calendar
		//  cAlEnDaR.set(java.util.Calendar.SECOND, 0); 
	        calendar.set(java.util.Calendar.SECOND, 0);  			// changed cAlEnDaR to calendar
		//   cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
	        calendar.set(java.util.Calendar.MILLISECOND, 0);		// changed cAlEnDaR to calendar
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	// public synchronized Date gEt_DaTe()
	public synchronized Date getDate() {					// changed method name gEt_DaTe to getDate
		try {
		// cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);	
	        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);  		// changed cAlEnDaR to calendar
	        // cAlEnDaR.set(java.util.Calendar.MINUTE, 0);  
		calendar.set(java.util.Calendar.MINUTE, 0); 			// changed cAlEnDaR to calendar
	        // cAlEnDaR.set(java.util.Calendar.SECOND, 0); 
		calendar.set(java.util.Calendar.SECOND, 0); 			// changed cAlEnDaR to calendar
	        // cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
		calendar.set(java.util.Calendar.MILLISECOND, 0);		// changed cAlEnDaR to calendar
			// return cAlEnDaR.getTime();
			return calendar.getTime();				// hanged cAlEnDaR to calendar
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	// public synchronized Date gEt_DuE_DaTe(int loanPeriod)
	public synchronized Date getDueDate(int loanPeriod) {			// Method name changed gEt_DuE_DaTe to getDueDate
		// Date nOw = gEt_DaTe();
		Date now = getDate();						// changed gEt_DaTe to getDate and n0w to now
		// cAlEnDaR.add(java.util.Calendar.DATE, loanPeriod);
		calendar.add(java.util.Calendar.DATE.loanPeriod);		// hanged cAlEnDaR to calendar
		// Date dUeDaTe = cAlEnDaR.getTime();
		Date dueDate = calendar.getTime();				//  changed dUeDate to dueDate and cAlEnDaR to calendar
		// cAlEnDaR.setTime(nOw);
		calendar.setTime(now);						// changed cAlEnDaR to calendar and nOw to now
		// return dUeDaTe;				
		return dueDate;							// changed dUeDaTe to dueDate
	}	
	
	// public synchronized long GeT_DaYs_DiFfErEnCe(Date targetDate) {
	public synchronized long getDaysDifference(Date targetDate) {		// changed GeT_DaYs_DiFfErEnCe to getDaysDifference
		

		// long Diff_Millis = gEt_DaTe().getTime() - targetDate.getTime();
		long diffMillis = getDate().getTime() - targetDate.getTime();	// chnaged Diff_Millis to diffNullis and gEt_DaTe() to getDate()
	        // long Diff_Days = TimeUnit.DAYS.convert(Diff_Millis, TimeUnit.MILLISECONDS);		
	        long diffDays = TimeUnit.DAYS.convert(diffMillis, timeUnit.MILLISECONDS);	// changed  Diff_Days to diffDays

	    // return Diff_Days;
	    return diffDays;							//  changed Diff_Days to diifDays
	}

}
