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
		control.setUI(this); // SeT_Ui to setUI
	}

	
	private String Input(String prompt) { //iNpUT changed to Input //PrOmPt changed to prompt
		System.out.print(prompt); //PrOmPt changed to prompt
		return Input.nextLine(); //iNpUT changed to Input
	}	
		
		
	private void Output(Object object) { //OuTpUt changed to Output //ObJeCt changes to object
		System.out.println(object); //ObJeCt changes to object 
	}
	
			
	public void SetState(UIState state) { //SeT_StAtE changed to SetState //uI_STaTe changed to UIState
		//this.StaTe = StAtE;
		this.state = state;
	}

	
	public void Run() { //RuN changed to Run
		OuTpUt("Borrow Book Use Case UI\n"); //OuTpUt changed to output
		
		while (true) {
			
			switch (state) { //StaTe changed to state			
			
			case CANCELLED:
				output("Borrowing Cancelled"); //OuTpUt changed to output
				return;

			/*			case READY:
				String MEM_STR = iNpUT("Swipe member card (press <enter> to cancel): ");
				if (MEM_STR.length() == 0) {
					CoNtRoL.CaNcEl();
					break;*/	
			case READY:
				String member = input("Swipe member card (press <enter> to cancel): ");// iNpUT change into input //MEM_STR change to member
				if (member.length() == 0) {
					control.cancel(); //CoNtRoL changed to control //CaNcEl changed to cancel
					break;
				}
				try {
					int memberId = Integer.valueOf(MEM_STR).intValue(); //MeMbEr_Id change to memberId
					control.swiped(memberId); //CoNtRoL change to control //SwIpEd change to swiped
				}
				catch (NumberFormatException e) {
					output("Invalid Member Id"); //OuTpUt chaged to output
				}
				break;

				
			case RESTRICTED:
				input("Press <any key> to cancel");//iNpUT changed to input
				control.cancel(); // CoNtRoL change control // CaNcEl change to cancel
				break;
			
				
			case SCANNING:
				String bookinput = input("Scan Book (<enter> completes): "); //BoOk_StRiNg_InPuT change to bookinput //iNpUT change to input
				if (bookinput.length() == 0) {
					control.complete(); //CoNtRoL change to control // CoMpLeTe change to complete
					break;
				}
				try {
					int bid = Integer.valueOf(BoOk_StRiNg_InPuT).intValue(); //BiD change to bid
					control.scanned(bid); //CoNtRoL change to control //ScAnNeD change to scanned
					
				} catch (NumberFormatException e) {
					output("Invalid Book Id"); //OuTpUt change to output
				} 
				break;
					
				
			case FINALISING:
				String answer = input("Commit loans? (Y/N): "); //iNpUT change to input answer
				if (answer.toUpperCase().equals("N")) {
					control.cancel();//CoNtRoL change to control //CaNcEl changes to cancel
					
				} else {
					control.commitLoans(); //CoNtRoL change to control //CoMmIt_LoAnS changed to commitLoans
					input("Press <any key> to complete "); //iNpUT change to input
				}
				break;
				
				
			case COMPLETED:
				output("Borrowing Completed"); //OuTpUt changed to output
				return;
	
				
			default:
				output("Unhandled state"); //OuTpUt change to output
				throw new RuntimeException("BorrowBookUI : unhandled state :" + state);	//StaTe change to state		
			}
		}		
	}


	public void Display(Object object) { // DiSpLaY changed to Display
		output(object);	//OuTpUt changed to output	
	}


}
