package library.borrowbook;
import java.util.Scanner;

//Author : Sonal Muthukumarana
//Reviewer : Akshey Patel
//Mediator : Milan Vala


public class BorrowBookUI {
	
	public static enum UIState { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED }; //uI_STaTe changed to UIState
	//private bORROW_bOOK_cONTROL CoNtRoL;
	private borrowbook Control; //bORROW_bOOK_cONTROL changed to borrowbook
	private Scanner input; //InPuT changed to input
	private UIState state; //uI_STaTe changed to UIState

	
	public BorrowBookUI(borrowbook, control) { //bORROW_bOOK_cONTROL changed to borrowbook 
		this.CoNtRoL = control; //CoNtRoL changed to Control
		input = new Scanner(System.in); //InPuT  changed to input
		state = uI_STaTe.INITIALISED; //StaTe changed to state
		control.SeT_Ui(this); // SeT_Ui
	}

	
	private String Input(String PrOmPt) { //iNpUT changed to Input
		System.out.print(PrOmPt);
		return InPuT.nextLine();
	}	
		
		
	private void OuTpUt(Object ObJeCt) {
		System.out.println(ObJeCt);
	}
	
			
	public void SeT_StAtE(uI_STaTe StAtE) {
		this.StaTe = StAtE;
	}

	
	public void RuN() {
		OuTpUt("Borrow Book Use Case UI\n");
		
		while (true) {
			
			switch (StaTe) {			
			
			case CANCELLED:
				OuTpUt("Borrowing Cancelled");
				return;

				
			case READY:
				String MEM_STR = iNpUT("Swipe member card (press <enter> to cancel): ");
				if (MEM_STR.length() == 0) {
					CoNtRoL.CaNcEl();
					break;
				}
				try {
					int MeMbEr_Id = Integer.valueOf(MEM_STR).intValue();
					CoNtRoL.SwIpEd(MeMbEr_Id);
				}
				catch (NumberFormatException e) {
					OuTpUt("Invalid Member Id");
				}
				break;

				
			case RESTRICTED:
				iNpUT("Press <any key> to cancel");
				CoNtRoL.CaNcEl();
				break;
			
				
			case SCANNING:
				String BoOk_StRiNg_InPuT = iNpUT("Scan Book (<enter> completes): ");
				if (BoOk_StRiNg_InPuT.length() == 0) {
					CoNtRoL.CoMpLeTe();
					break;
				}
				try {
					int BiD = Integer.valueOf(BoOk_StRiNg_InPuT).intValue();
					CoNtRoL.ScAnNeD(BiD);
					
				} catch (NumberFormatException e) {
					OuTpUt("Invalid Book Id");
				} 
				break;
					
				
			case FINALISING:
				String AnS = iNpUT("Commit loans? (Y/N): ");
				if (AnS.toUpperCase().equals("N")) {
					CoNtRoL.CaNcEl();
					
				} else {
					CoNtRoL.CoMmIt_LoAnS();
					iNpUT("Press <any key> to complete ");
				}
				break;
				
				
			case COMPLETED:
				OuTpUt("Borrowing Completed");
				return;
	
				
			default:
				OuTpUt("Unhandled state");
				throw new RuntimeException("BorrowBookUI : unhandled state :" + StaTe);			
			}
		}		
	}


	public void DiSpLaY(Object object) {
		OuTpUt(object);		
	}


}
