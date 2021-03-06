package library.payfine;
import library.entities.Library;
import library.entities.Member;

//Author: Akshay Patel
//Reviewer: Sonal Muthukumarana
//Mediator: Milan Vala

//public class pAY_fINE_cONTROL 
public class PayFineControl {							// class names start with an uppercase, changed pAY_fINE_cONTROL to PayFineControl
	
	// private PayFineUI Ui;
	private PayFineUI ui;							// changed variable name UI to ui
	// private enum cOnTrOl_sTaTe { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };
	private enum ControlState { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };	// changed cOnTrOl_sTaTe to ControlState
	// private cOnTrOl_sTaTe StAtE;
	private ControlState state;						// changed class name cOnTrOl_sTaTe to ControlState and variable name StAtE to state
	
	// private Library LiBrArY;
	private Library library;						// changed variable name LiBrArY to library
	// private Member MeMbEr;
	private Member member;							// changed variable name MeMbEr to member


	// public pAY_fINE_cONTROL() {
	public payFineControl() {						// changed function name pAY_fINE_cONTROL() to payFineControl
		// this.LiBrArY = Library.GeTiNsTaNcE();
		this.library = Library.getInstance();				// changed variable LiBrArY to library and method GeTiNsTaNcE() to getInstance()
		// StAtE = cOnTrOl_sTaTe.INITIALISED;
		state = ControlState.INITIALISED;				// varible StAtE to state and class cOnTrOl_sTaTe to ControlState
	}
	
	
	// public void SeT_uI(PayFineUI uI) {
	public void seUI(PayFineUI ui) {					// changed method name SeT_uI to setUI and uI to ui
		// if (!StAtE.equals(cOnTrOl_sTaTe.INITIALISED)) {
		if (!state.equals(ControlState.INITIALISED)) {			// changed StAtE to state and cOnTrOl_sTaTe to ControlState
			throw new RuntimeException("PayFineControl: cannot call setUI except in INITIALISED state");
		}	
		// this.Ui = uI;
		this.ui = ui;							// changed variable name Ui to ui 
		// uI.SeT_StAtE(PayFineUI.uI_sTaTe.READY);
		ui.setState(PayFineUI.uiState.READY);				// changed SeT_StAtE to setStatet and uI_sTaTe to uiState
		// StAtE = cOnTrOl_sTaTe.READY;	
		state = ControlState.READY;
	}


	// public void CaRd_sWiPeD(int MeMbEr_Id) {
	public void cardSwiped(int memberId) {					// changed method name CaRd_sWiPeD to cardSwiped and MeMbEr_Id to memebrId
		// if (!StAtE.equals(cOnTrOl_sTaTe.READY)) 
		if (!state.equals(ControlState.READY)) 				// changed StAtE to state and cOnTrOl_sTaTe to ControlState
			throw new RuntimeException("PayFineControl: cannot call cardSwiped except in READY state");
			
		// MeMbEr = LiBrArY.gEt_MeMbEr(MeMbEr_Id);
		member = library.getMember(memberId);				// changed LiBrArY to library and gEt_MeMbEr to getMember
		
		// if (MeMbEr == null) {
		if (member == null) {						// changed MeMbEr to member
			// Ui.DiSplAY("Invalid Member Id");
			ui.display("Invalid Member Id");			// changed DiSplAY to display and Ui to ui
			return;
		}
		// Ui.DiSplAY(MeMbEr.toString());
		ui.display(member.toString());					// changed DiSplAY to display and changed MeMbEr to member
		// Ui.SeT_StAtE(PayFineUI.uI_sTaTe.PAYING);
		ui.setState(PayFineUI.uiState.PAYING);				// changed SeT_StAtE to setState and uI_sTaTe to uiState
		// StAtE = cOnTrOl_sTaTe.PAYING;
		state = ControlState.PAYING;					// changed cOnTrOl_sTaTe to ControlState and StAtE to state
	}	
	
	
	// public void CaNcEl() {
	public void cancel() {							// changed method CaNcEl() to cancel()
		// Ui.SeT_StAtE(PayFineUI.uI_sTaTe.CANCELLED);
		ui.setState(PayFineUI.uiState.CANCELLED);			// changed Ui to ui and SeT_StAtE to setState
		// StAtE = cOnTrOl_sTaTe.CANCELLED;
		state = ControlState.CANCELLED;					// changed StAtE to state and cOnTrOl_sTaTe to ControlState
	}


	// public double PaY_FiNe(double AmOuNt) {
	public double payFine(double amount) {					// changed method name PaY_FiNe to payFine and variable AmOuNt to amount
		// if (!StAtE.equals(cOnTrOl_sTaTe.PAYING)) 
		if (!state.equals(ControlState.PAYING)) 			// changed variable StAtE to state and class name cOnTrOl_sTaTe to ControlState
			throw new RuntimeException("PayFineControl: cannot call payFine except in PAYING state");
			
		// double ChAnGe = MeMbEr.PaY_FiNe(AmOuNt);
		double change = member.payFine(amount);				// chnaged varible name ChAnGe to change and parameter AmOuNt to amount
		// if (ChAnGe > 0) 
		if (change > 0) 						// changed variable name ChAnGe to change
			// Ui.DiSplAY(String.format("Change: $%.2f", ChAnGe));
			ui.disply(String.format("Change: $%.2f", change));	// changed variable name ChAnGe to change and Ui to ui
		
		// Ui.DiSplAY(MeMbEr.toString());
		ui.display(member.toString());					// changed method name DiSplAY to display and variable Ui to ui
		// Ui.SeT_StAtE(PayFineUI.uI_sTaTe.COMPLETED);
		ui.setState(payFineUI.uiState.COMPLETED);				// changed function name SeT_StAtE to setState and uI_sTaTe to uiState
		// StAtE = cOnTrOl_sTaTe.COMPLETED;
		state = ControlState.COMPLETED;						// changed StAtE to state and cOnTrOl_sTaTe to ControlState
		// return ChAnGe;
		return Change;								// changed variable name ChAnGe to change
	}
	


}
