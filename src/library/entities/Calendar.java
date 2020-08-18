//Author: Akshay Patel
//Reviewer: Sonal Muthukumarana
//Mediator: Milan Vala


package library.entities;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calendar {
	
	// private static Calendar sElF;
	private static Calendar self;    						// variable changed from sElF to self
	private static java.util.Calendar cAlEnDaR;
	
	
	private Calendar() {
		cAlEnDaR = java.util.Calendar.getInstance();
	}
	

	
	// public static Calendar gEtInStAnCe()
	public static Calendar getInstance() {  				// Method name changed from gEtInStAnCe() to getInstance()
		//if (sElF == null) {
		if (self == null) {
		    //sElF = new Calendar();
		    self = new calendar();					// Adding 4 space. changed Calendar() to calendar()

		}
		//return sElF;
		return self;
	}
	
	public void incrementDate(int days) {
		cAlEnDaR.add(java.util.Calendar.DATE, days);		
	}

	
	//public synchronized void SeT_DaTe(Date DaTe)
		public synchronized void setDate(Date date) {
		try {
			// cAlEnDaR.setTime(DaTe);
			calendar.setTime(Date);
		// cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);	
	        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0); 
		// cAlEnDaR.set(java.util.Calendar.MINUTE, 0); 
	        calendar.set(java.util.Calendar.MINUTE, 0);  
		//  cAlEnDaR.set(java.util.Calendar.SECOND, 0); 
	        calendar.set(java.util.Calendar.SECOND, 0);  
		//   cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
	        calendar.set(java.util.Calendar.MILLISECOND, 0);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	// public synchronized Date gEt_DaTe()
	public synchronized Date getDate() {
		try {
		// cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);	
	        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        // cAlEnDaR.set(java.util.Calendar.MINUTE, 0);  
		calendar.set(java.util.Calendar.MINUTE, 0); 
	        // cAlEnDaR.set(java.util.Calendar.SECOND, 0); 
		calendar.set(java.util.Calendar.SECOND, 0); 
	        // cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
		calendar.set(java.util.Calendar.MILLISECOND, 0);
			return cAlEnDaR.getTime();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	// public synchronized Date gEt_DuE_DaTe(int loanPeriod)
	public synchronized Date getDueDate(int loanPeriod) {
		Date nOw = gEt_DaTe();
		// cAlEnDaR.add(java.util.Calendar.DATE, loanPeriod);
		calendar.add(java.util.Calendar.Date, loanPeriod);
		Date dUeDaTe = cAlEnDaR.getTime();
		// cAlEnDaR.setTime(nOw);
		calendar.setTime(now);
		return dUeDaTe;
	}
	
	public synchronized long GeT_DaYs_DiFfErEnCe(Date targetDate) {
		

		// long Diff_Millis = gEt_DaTe().getTime() - targetDate.getTime();
		long diffMillis = getDate().getTime() - targetDate.getTime();
	        // long Diff_Days = TimeUnit.DAYS.convert(Diff_Millis, TimeUnit.MILLISECONDS);		
	        long Diff_Days = TimeUnit.DAYS.convert(diffMillis, timeUnit.MILLISECONDS);

	    return Diff_Days;
	}

}
