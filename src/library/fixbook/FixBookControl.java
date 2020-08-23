package library.fixbook;
import library.entities.Book;
import library.entities.Library;

//Author: Akshay Patel
//Reviewer: Sonal Muthukumarana
//Mediator: Milan Vala

// public class fIX_bOOK_cONTROL {
public class FixBookConrol {							// changed class name fIX_bOOK_cONTROL to FixBookControl
	
	// private FixBookUI Ui;
	private FixBookUI ui;							// changed variable name Ui to ui
	// private enum CoNtRoL_StAtE { INITIALISED, READY, FIXING };
	private enum ControlState { INITIALISED, READY, FIXING };		// changed enum CoNtRoL_StAtE to ControlState
	// private CoNtRoL_StAtE StAtE;
	private COntrolState state;						// changed CoNtRoL_StAtE to ControlState and StAtE to state
	
	// private Library LiBrArY;
	private Library library;						// changed LiBrArY to library
	// private Book CuRrEnT_BoOk;
	private Book currentBook;						// changed CuRrEnT_BoOk to currentBook


	// public fIX_bOOK_cONTROL() {
	public FixBookControl() {						// update method name fIX_bOOK_cONTROL() to FixBookControl
		// this.LiBrArY = Library.GeTiNsTaNcE();
		this.library = Library.getInstance();				// changed LiBrArY to library and method name GeTiNsTaNcE() to getInstance()
		// StAtE = CoNtRoL_StAtE.INITIALISED;
		state = ControlState.INITIALISED;				// changed variable name StAtE to state and class name CoNtRoL_StAtE to ControlState
	}
	
	
	// public void SeT_Ui(FixBookUI ui) {
	public void setUI(FixBookUI ui) {					// changed function name SeT_Ui to setUI
		// if (!StAtE.equals(CoNtRoL_StAtE.INITIALISED))
		if (!state.equals(ControlState.INITIALISED)) 			// changed CoNtRoL_StAtEt to ControlState and variable name StAtE to state
			throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
			
		// this.Ui = ui;
		this.ui = ui;							// changed Ui to ui 
		// ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
		ui.setState(FixBookUI.uiState.READY);				// changed method name SeT_StAtE to setState and uI_sTaTe to uiState
		// StAtE = CoNtRoL_StAtE.READY;	
		state = ControlState.READY;					// changed CoNtRoL_StAtE to ControlState and variable name to state
	}	


	// public void BoOk_ScAnNeD(int BoOkId) {
	public void bookSanned(int bookId) {					// changed function name BoOk_ScAnNeD to bookScanned and varible name BoOkId to bookId
		// if (!StAtE.equals(CoNtRoL_StAtE.READY))
		if (!state.equals(ControlState.READY)) 				// changed varible name StAtE to state and class name CoNtRoL_StAtE to ControlState
			throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
			
		// CuRrEnT_BoOk = LiBrArY.gEt_BoOk(BoOkId);
		currentBook = library.getBook(bookId);				// changed CuRrEnT_BoOk to currentBook and parameter name BoOkId to bookId 
		
		//if (CuRrEnT_BoOk == null) {
		if (currentBook == null) {					// changed CuRrEnT_BoOk to currentBook
			// Ui.dIsPlAy("Invalid bookId");
			ui.display("Invalid bookId");				// changed variable name Ui to ui and function dIsPlAy() to display()
			return;
		}
		// if (!CuRrEnT_BoOk.iS_DaMaGeD()) {
		if (!currentBook.isDamaged()) {					// changed variable name CuRrEnT_BoOk to currentBook and iS_DaMaGeD() to isDamaged
			// Ui.dIsPlAy("Book has not been damaged");
			ui.display("Book has not been damaged");		// changed variable name Ui to ui and method name dIsPlAy() to display
			return;
		}
		// Ui.dIsPlAy(CuRrEnT_BoOk.toString());
		ui.display(currentBook.toString());				// changed Ui to ui, dIsPlAy to display and CuRrEnT_BoOk to currentBook
		// Ui.SeT_StAtE(FixBookUI.uI_sTaTe.FIXING);
		ui.serState(FixBookUI.uiState.FIXING);				// changed SeT_StAtE to setState and uI_sTaTe to uiState
		// StAtE = CoNtRoL_StAtE.FIXING;	
		state = ControlState.FIXING;					// changed CoNtRoL_StAtE to ControlState and StAtE to state
	}


	// public void FiX_BoOk(boolean mUsT_FiX) {
	public void fixBook(boolean mesyFix) {					// changed method name FiX_BoOk to fixBook and boolean mUsT_FiX to mustFix
		// if (!StAtE.equals(CoNtRoL_StAtE.FIXING)) 
		if (!state.equals(ControlState.FIXING))				// changed StAtE to state and class name  CoNtRoL_StAtE to ControlState
			throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
			
		// if (mUsT_FiX) 
		if (mustFix) 							// changed boolean mUsT_FiX to mustFix
			// LiBrArY.RePaIr_BoOk(CuRrEnT_BoOk);
			library.repairBook(currentBook);	// changed LiBrArY to library, function RePaIr_BoOk to repiarBook and CuRrEnT_BoOk to currentBook
		
		// CuRrEnT_BoOk = null;
		currentBook = null;						// changed CuRrEnT_BoOk to currentBook		
		// Ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
		ui.setState(FixBookUI.uiState.READY);		// changed SeT_StAtE to setState, uI_sTaTe to uiState and Ui to ui
		// StAtE = CoNtRoL_StAtE.READY;	
		state = ControlState.READY;					// changed variable name StAtE to state and CoNtRoL_StAtE to ControlState
	}

	
	public void SCannING_COMplete() {
		if (!StAtE.equals(CoNtRoL_StAtE.READY)) 
			throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
			
		Ui.SeT_StAtE(FixBookUI.uI_sTaTe.COMPLETED);		
	}

}
