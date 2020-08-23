package library.fixbook;
import java.util.Scanner;

//Author: Akshay Patel
//Reviewer: Milan Vala
//Mediator: Sonal Muthukumarana

public class FixBookUI {

	// public static enum uI_sTaTe { INITIALISED, READY, FIXING, COMPLETED };
	public static enum UIState { INITIALISED, READY, FIXING, COMPLETED };		// changed class name uI_sTaTe to UIState

	//private fIX_bOOK_cONTROL CoNtRoL;
	private FixBookControl control;							// changed class name fIX_bOOK_cONTROL to FixBookControl
	// private Scanner InPuT;
	private Scanner input;								// changed variable name InPuT to input
	// private uI_sTaTe StAtE;
	private UIState state;								// changed variable name StAtE to state

	
	// public FixBookUI(fIX_bOOK_cONTROL CoNtRoL) {
	public FixBookUI(FixBookControl control) {					// changed class name fIX_bOOK_cONTROL to FixBookControl
		// this.CoNtRoL = CoNtRoL;
		this.control = control;							// changed varaible name CoNtRoL to control
		// InPuT = new Scanner(System.in);
		input = new Scanner(System.in);						// changed InPuT to input
		//StAtE = uI_sTaTe.INITIALISED;
		state = UIState.INITIALISED;						// changed uI_sTaTe to UIState 
		// CoNtRoL.SeT_Ui(this);
		control.setUI(this);							// changed mehtod name SeT_Ui to setUI
	}


	// public void SeT_StAtE(uI_sTaTe state) {
	public void setState(UIState state) {						// changed method name SeT_StAtE to setState and uI_sTaTe to UIState
		// this.StAtE = state;
		this.state = state;							// changed StAtE to state
	}

	
	// public void RuN() {
	public void run() {								// changed method name RuN() to run()
		// OuTpUt("Fix Book Use Case UI\n");
		output("Fix Book Use Case UI\n");					// changed OuTpUt to output()
		
		while (true) {
			
			// switch (StAtE) {
			switch (state) {						// changed parameter StAtE to state
			
			case READY:
				// String BoOk_EnTrY_StRiNg = iNpUt("Scan Book (<enter> completes): ");
				String bookEntryString = input("Scan Book (<enter> completes): ");	// changed string name BoOk_EnTrY_StRiNg to bookEntryString
				// if (BoOk_EnTrY_StRiNg.length() == 0) 
				if (bookEntryString.length() == 0) 					//  changed string name BoOk_EnTrY_StRiNg to bookEntryString
					// CoNtRoL.SCannING_COMplete();
					control.scanningComplete();					// changed CoNtRoL to control
				
				else {
					try {
						// int BoOk_Id = Integer.valueOf(BoOk_EnTrY_StRiNg).intValue();
						int bookId = Integer.valueOf(bookEntryString).intValue();	// changed integer BoOk_Id to bookId and BoOk_EnTrY_StRiNg to to bookEntryString
						// CoNtRoL.BoOk_ScAnNeD(BoOk_Id);
						control.bookScanned(bookId);				// changed CoNtRoL to control and BoOk_ScAnNeD to bookScanned and Book_Id to bookId
					}
					catch (NumberFormatException e) {
						// OuTpUt("Invalid bookId");
						output("Invalid bookId");				// changed OuTpUt to output
					}
				}
				break;	
				
			case FIXING:
				// String AnS = iNpUt("Fix Book? (Y/N) : ");
				String and = input("Fix Book? (Y/N) : ");		// changed string name AnS to ans and iNpUt to input
				// boolean FiX = false;
				boolean fix = false;					// changed boolean FiX to fix
				// if (AnS.toUpperCase().equals("Y")) 
				if (ans.toUpperCase().equals("Y")) 			// changed string name AnS to ans
					// FiX = true;
					fix = true;					// changed boolean FiX to fix
				
				// CoNtRoL.FiX_BoOk(FiX);
				control.fixBook(fix);					// changed FiX_BoOk to fixBook and changed parameter FiX to fix
				break;
								
			case COMPLETED:
				// OuTpUt("Fixing process complete");
				output("Fixing process complete");			// changed OuTpUt to output
				return;
			
			default:
				// OuTpUt("Unhandled state");	
				output("Unhandled state");				// changed OuTpUt to output
				// throw new RuntimeException("FixBookUI : unhandled state :" + StAtE);
				throw new RuntimeException("FixBookUI : unhandled state :" + state);	// changed variable name StAtE to state		
			
			}		
		}
		
	}

	
	private String iNpUt(String prompt) {
		System.out.print(prompt);
		return InPuT.nextLine();
	}	
		
		
	private void OuTpUt(Object object) {
		System.out.println(object);
	}
	

	public void dIsPlAy(Object object) {
		OuTpUt(object);
	}
	
	
}
