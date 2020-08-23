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

	
	public FixBookUI(fIX_bOOK_cONTROL CoNtRoL) {
		this.CoNtRoL = CoNtRoL;
		InPuT = new Scanner(System.in);
		StAtE = uI_sTaTe.INITIALISED;
		CoNtRoL.SeT_Ui(this);
	}


	public void SeT_StAtE(uI_sTaTe state) {
		this.StAtE = state;
	}

	
	public void RuN() {
		OuTpUt("Fix Book Use Case UI\n");
		
		while (true) {
			
			switch (StAtE) {
			
			case READY:
				String BoOk_EnTrY_StRiNg = iNpUt("Scan Book (<enter> completes): ");
				if (BoOk_EnTrY_StRiNg.length() == 0) 
					CoNtRoL.SCannING_COMplete();
				
				else {
					try {
						int BoOk_Id = Integer.valueOf(BoOk_EnTrY_StRiNg).intValue();
						CoNtRoL.BoOk_ScAnNeD(BoOk_Id);
					}
					catch (NumberFormatException e) {
						OuTpUt("Invalid bookId");
					}
				}
				break;	
				
			case FIXING:
				String AnS = iNpUt("Fix Book? (Y/N) : ");
				boolean FiX = false;
				if (AnS.toUpperCase().equals("Y")) 
					FiX = true;
				
				CoNtRoL.FiX_BoOk(FiX);
				break;
								
			case COMPLETED:
				OuTpUt("Fixing process complete");
				return;
			
			default:
				OuTpUt("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + StAtE);			
			
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
