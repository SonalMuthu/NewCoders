package library.returnBook;
import java.util.Scanner;


public class ReturnBookUI {


	public static enum UiState { INITIALISED, READY, INSPECTING, COMPLETED }; // uI_sTaTe to UiState

	private ReturnBookControl Control; //private rETURN_bOOK_cONTROL CoNtRoL;
	private Scanner Input; //private Scanner iNpUt;
	private UiState State; //uI_sTaTe StATe


	
	public ReturnBookUI(ReturnBookControl Control) {	
		this.control = control; //this.CoNtRoL = cOnTrOL;
		input = new Scanner(System.in); //iNpUt = new Scanner(System.in);
		state = uiState.INITIALISED; //StATe = uI_sTaTe.INITIALISED;
		control.setUi(this); //cOnTrOL.sEt_uI(this);
	}


	public void rut() { //public void RuN() {		
		output("Return Book Use Case UI\n"); //oUtPuT("Return Book Use Case UI\n");
		
		while (true) {
			
			switch (state) { //switch (StATe) {
			
			case INITIALISED:
				break;
				
			case READY:
				String bookInputString = input("Scan Book (<enter> completes): "); //String BoOk_InPuT_StRiNg = iNpUt("Scan Book (<enter> completes): ");
				if (bookInputString.length() == 0) //if (BoOk_InPuT_StRiNg.length() == 0) 
					control.scanningComplete(); //CoNtRoL.sCaNnInG_cOmPlEtE();
				
				else {
					try {
						int bookID = Integer.valueOf(bookInputString).intValue(); //int Book_Id = Integer.valueOf(BoOk_InPuT_StRiNg).intValue();
						contronBookScanned(bookID); //CoNtRoL.bOoK_sCaNnEd(Book_Id);
					}
					catch (NumberFormatException e) {
						output("Invalid bookId"); //oUtPuT("Invalid bookId");
					}					
				}
				break;				
				
			case INSPECTING:
				String ans = input("Is book damaged? (Y/N): "); //String AnS = iNpUt("Is book damaged? (Y/N): ");
				boolean isDamaged = false; //boolean Is_DAmAgEd = false;
				if (ans.toUpperCase().equals("Y")) {	//if (AnS.toUpperCase().equals("Y"))				
					isdamaged = true; //Is_DAmAgEd = true;
					{
				controlDischargeLoan(Is_DAmAgEd); //CoNtRoL.dIsChArGe_lOaN(Is_DAmAgEd);
			
			case COMPLETED:
				output("Return processing complete"); //oUtPuT("Return processing complete");
				return;
			
			default:
				output("Unhandled state"); //oUtPuT("Unhandled state");
				throw new RuntimeException("ReturnBookUI : unhandled state :" + state); //throw new RuntimeException("ReturnBookUI : unhandled state :" + StATe);			
			}
		}
	}

	
	private String input(String prompt) { //private String iNpUt(String PrOmPt) {
		System.out.print(prompt); //System.out.print(PrOmPt);
		return input.nextLine(); //return iNpUt.nextLine();
	}	
		
		
	private void output(Object object) { //private void oUtPuT(Object ObJeCt) {
		System.out.println(object); //System.out.println(ObJeCt);
	}
	
			
	public void display(object object) { //public void DiSpLaY(Object object) {
		output(object); //oUtPuT(object);
	}
	
	public void setState(uiState state) { //public void sEt_sTaTe(uI_sTaTe state) {
		this.state = state; //this.StATe = state;
	}

	
}
