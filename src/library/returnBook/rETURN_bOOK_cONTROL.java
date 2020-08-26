package library.returnBook;
import library.entities.Book;
import library.entities.Library;
import library.entities.Loan;

//public class rETURN_bOOK_cONTROL 
public class ReturnBookControl {  //changed class name rETURN_bOOK_cONTROL to ReturnBookControl

	//private ReturnBookUI Ui;
	private ReturnBookUI ui; //variable name Ui to ui
	//private enum cOnTrOl_sTaTe { INITIALISED, READY, INSPECTING };
	private enum ControlState { INITIALISED, READY, INSPECTING }; //// changed cOnTrOl_sTaTe to ControlState
	//private cOnTrOl_sTaTe sTaTe;
	private ControlState state;// changed variable name and type
	
	//private Library lIbRaRy;
	private Library library;// changed variable name lIbRaRy to library 
	//private Loan CurrENT_loan;
	private Loan currentLoan;// changed variablename CurrENT_loan to currentLoan
	

	//public rETURN_bOOK_cONTROL()
	public RetutnBookControl() { //change method name rETURN_bOOK_cONTROL() to ReturnBookControl()
		//this.lIbRaRy = Library.GeTiNsTaNcE();
		this.Library = Library.GetInstance(); // change lIbRaRy to Library and GeTiNsTaNcE() to GetInstance()
		//sTaTe = cOnTrOl_sTaTe.INITIALISED;
		state = ControlState.INITIALISED;// changed variable sTaTe to state and cOnTrOl_sTaTe to ControlState
	}
	
	
	//public void sEt_uI(ReturnBookUI uI)
	public void setUI(ReturnBookUI ui) { // changed function name setUI and parameter variable name ui
		//if (!sTaTe.equals(cOnTrOl_sTaTe.INITIALISED)) 
		if (!state.equals(ControlState.INITIALISED)) // changed variable sTaTe to state and enum cOnTrOl_sTaTe to ControlState
			throw new RuntimeException("ReturnBookControl: cannot call setUI except in INITIALISED state");
		
		//this.Ui = uI;
		this.ui = ui;  // change variable Ui to ui and parameter variable uI to ui
		//uI.sEt_sTaTe(ReturnBookUI.uI_sTaTe.READY);
		ui.SetState(ReturnBookUI.uiState.READY);
		//sTaTe = cOnTrOl_sTaTe.READY;
		state = ControlState.READY;	
	}


	//public void bOoK_sCaNnEd(int bOoK_iD) {
	public void bookScanned(int bookID) { //// changed function name bOoK_sCaNnEd to bookScanned and parameter variable bOoK_iD to bookID
		//if (!sTaTe.equals(cOnTrOl_sTaTe.READY)) 
		if (!state.equals(ControlState.READY)) { // add curly brecket and changed sTaTe to state and enum cOnTrOl_sTaTe to ControlState
			throw new RuntimeException("ReturnBookControl: cannot call bookScanned except in READY state");
		//Book cUrReNt_bOoK = lIbRaRy.gEt_BoOk(bOoK_iD);
		Book CurrentBook = library.getBook(bookID);// changed variable cUrReNt_bOoK to currentBook and lIbRaRy to library, bOoK_iD to bookID and gEt_BoOk(bookID) to getBook(bookID)
		}
		//if (cUrReNt_bOoK == null) {
		if (CurentBook == null) { // changed cUrReNt_bOoK to CurrentBook
			//Ui.DiSpLaY("Invalid Book Id");
			ui.DiSpLaY("Invalid Book Id"); // changed Ui to ui
			return;
		}
		//if (!cUrReNt_bOoK.iS_On_LoAn()) {
		if (!currentBook.IsOnLoan()) { // changed variable name cUrReNt_bOoK to currentBook and iS_On_LoAn() to IsOnLoan()
			ui.DiSpLaY("Book has not been borrowed");   // Ui to ui
			return;
		}		
		//CurrENT_loan = lIbRaRy.GeT_LoAn_By_BoOkId(bOoK_iD);
		currentLoan = library.getLoanByBookID(bookID);  // changed variable CurrENT_loan to currentLoan, lIbRaRy to library and parameter variable bOoK_iD to bookID	
		//double Over_Due_Fine = 0.0;
		double overDueFine= 0.0; //changed variable name Over_Due_Fine to overDueFine
		//if (CurrENT_loan.Is_OvEr_DuE()) 
		if (currentLoan.Is_OvEr_DuE()) { // Add curly bracket and CurrENT_loan to currentLoan
			//Over_Due_Fine = lIbRaRy.CaLcUlAtE_OvEr_DuE_FiNe(CurrENT_loan);
			overDueFine = library.CaLcUlAtE_OvEr_DuE_FiNe(currentLoan);//// changed Over_Due_Fine to overDueFine and lIbRaRy to library and CurrENT_loan to currentLoan
		}
		//Ui.DiSpLaY("Inspecting");
		ui.Display("Inspecting");
		//Ui.DiSpLaY(cUrReNt_bOoK.toString());
		ui.Display(CurrentBook.toString());//Ui to ui and cUrRNt_b0ok toCurrentBook
		//Ui.DiSpLaY(CurrENT_loan.toString());
		ui.Display(CurrentLoan.toString());//Ui to ui nad CurrENT_loa to CurrentLoan
		
		//if (CurrENT_loan.Is_OvEr_DuE())
		if (CurrentLoan.Is_OvEr_DuE()) { //add curly brecket
			//Ui.DiSpLaY(String.format("\nOverdue fine : $%.2f", Over_Due_Fine));
			Ui.Display(String.format("\nOverdue fine : $%.2f", OverDueFine));
		}
		//Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.INSPECTING);
		ui.setState(ReturnBookUI.uiState.INSPECTING);
		//sTaTe = cOnTrOl_sTaTe.INSPECTING;
		state = ControlState.INSPECTING;		
	}


	//public void sCaNnInG_cOmPlEtE() {
	public void scanningComplete() { // changed function name sCaNnInG_cOmPlEtE to scanningComplete
		//if (!sTaTe.equals(cOnTrOl_sTaTe.READY))
		if (!sTaTe.equals(ControlState.READY)){ //  add curly bracket and cOnTrOl_sTaTe to ControlState
			throw new RuntimeException("ReturnBookControl: cannot call scanningComplete except in READY state");
		}
		//Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.COMPLETED);
		ui.setState(ReturnBookUI.uI_sTaTe.COMPLETED);		
	}


	// public void dIsChArGe_lOaN(boolean iS_dAmAgEd)
	public void dischargeLoan(boolean isDamaged) {// // changed function name dIsChArGe_lOaN to dischargeLoan and paramter variable iS_dAmAgEd to isDamaged
		//if (!sTaTe.equals(cOnTrOl_sTaTe.INSPECTING))
		if (!state.equals(ControlState.INSPECTING)) {// add curly brecket and changed sTaTe to state and cOnTrOl_sTaTe to ControlState
			throw new RuntimeException("ReturnBookControl: cannot call dischargeLoan except in INSPECTING state");
		}
		//lIbRaRy.DiScHaRgE_LoAn(CurrENT_loan, iS_dAmAgEd);
		library.DiScHaRgE_LoAn(currentLoan, isDamaged);  // changed lIbRaRy to library, CurrENT_loan to currentLoan and iS_dAmAgEd to isDamaged
		//CurrENT_loan = null;
		currentLoan = null;//changed CurrENT_loan to currentLoan
		//Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.READY);
		ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.READY);//Ui to ui
		//sTaTe = cOnTrOl_sTaTe.READY;	
		state = ControlState.READY;	// changed sTaTe to state and cOnTrOl_sTaTe to ControlState			
	}


}
