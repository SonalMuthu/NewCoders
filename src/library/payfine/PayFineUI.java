package library.payfine;
import java.util.Scanner;

//Author: Akshay Patel
//Reviewer: Milan Vala
//Mediator: Sonal Muthukumarana

public class PayFineUI {
	


	// public static enum uI_sTaTe { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };
	public static enum UIState { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };	// changed uI_sTaTe to UIState

	// private pAY_fINE_cONTROL CoNtRoL;
	private payFineControl control;						// changed pAY_fINE_cONTROL to payFineControl and varaible name CoNtRoL to control
	private Scanner input;
	// private uI_sTaTe StAtE;
	private UIState state;							// changed variable name StAtE to state and uI_sTaTe to UIState

	
	// public PayFineUI(pAY_fINE_cONTROL control) {
	public PayFineUI(payFineControl control) {				// changed argument pAY_fINE_cONTROL to payFineControl
		// this.CoNtRoL = control;
		this.control = control;
		input = new Scanner(System.in);
		// StAtE = uI_sTaTe.INITIALISED;				// changed class name uI_sTaTe to UIState
		state = UIState.INITIALISED;
		// control.SeT_uI(this);
		control.setUI(this);						// chaned method name SeT_uI to setUI
	}
	
	
	// public void SeT_StAtE(uI_sTaTe state) {
	public void setState(UIState state) {					// chaend method name SeT_StAtE to setState and uI_sTaTet to UIState
		// this.StAtE = state;
		this.state = state;						// variable name StAtE to state
	}


	// public void RuN() {
	public void run() {							// changed class name RuN() to run()
		output("Pay Fine Use Case UI\n");
		
		while (true) {
			
			// switch (StAtE) {
			switch (state) {					// changed StAtE to state
			
			case READY:
				// String Mem_Str = input("Swipe member card (press <enter> to cancel): ");
				String memStr = input("Swipe member card (press <enter> to cancel): ");	// changed string name Mem_Str to memStr
				// if (Mem_Str.length() == 0) {
				if (memStr.length() == 0) {			// changed string name Mem_Str to memStr
					// CoNtRoL.CaNcEl();
					control.cancel();			// changed CoNtRoL to control and method changed CaNcEl() to cancel()
					break;
				}
				try {
					// int Member_ID = Integer.valueOf(Mem_Str).intValue();
					int memberId = Integer.valueOf(memStr).intValue();	// changed variable name Member_ID to memberId
					// CoNtRoL.CaRd_sWiPeD(Member_ID);
					control.cardSwiped(memberId);		// changed CoNtRoL to control and variable name Member_ID to memberId
				}
				catch (NumberFormatException e) {
					output("Invalid memberId");
				}
				break;
				
			case PAYING:
				// double AmouNT = 0;
				double amount = 0;				// changed variable name AmouNT to amount
				// String Amt_Str = input("Enter amount (<Enter> cancels) : ");
				String amtStr = input("Enter amount (<Enter> cancels) : ");	// changed string name Amt_Str to amtStr
				// if (Amt_Str.length() == 0) {
				if (amtStr.length() == 0) {			// changed string name Amt_Str to amtStr
					// CoNtRoL.CaNcEl();
					control.cancel();			// changed method name CaNcEl() to cancel() 
					break;
				}
				try {
					// AmouNT = Double.valueOf(Amt_Str).doubleValue();
					amount = Double.valueOf(amtStr).doubleValue();	// changed AmouNT to amount and String name Amt_Str to amtStr
				}
				catch (NumberFormatException e) {}
				// if (AmouNT <= 0) {
				if (AmouNT <= 0) {				// changed AmouNT to amount
					output("Amount must be positive");
					break;
				}
				// CoNtRoL.PaY_FiNe(AmouNT);
				control.payFine(amount);			// changed CoNtRoL to control and parameter AmouNT to amount
				break;
								
			case CANCELLED:
				output("Pay Fine process cancelled");
				return;
			
			case COMPLETED:
				output("Pay Fine process complete");
				return;
			
			default:
				output("Unhandled state");
				// throw new RuntimeException("FixBookUI : unhandled state :" + StAtE);
				throw new RuntimeException("FixBookUI : unhandled state :" + state);	// changed variable name StAtE to state
			
			}		
		}		
	}

	
	private String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}	
		
		
	private void output(Object object) {
		System.out.println(object);
	}	
			

	// public void DiSplAY(Object object) {
	public void display(Object object) {					// changee method name DiSplAY() to display()
		output(object);
	}


}
