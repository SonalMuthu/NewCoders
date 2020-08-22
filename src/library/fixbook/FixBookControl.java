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


	public void BoOk_ScAnNeD(int BoOkId) {
		if (!StAtE.equals(CoNtRoL_StAtE.READY)) 
			throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
			
		CuRrEnT_BoOk = LiBrArY.gEt_BoOk(BoOkId);
		
		if (CuRrEnT_BoOk == null) {
			Ui.dIsPlAy("Invalid bookId");
			return;
		}
		if (!CuRrEnT_BoOk.iS_DaMaGeD()) {
			Ui.dIsPlAy("Book has not been damaged");
			return;
		}
		Ui.dIsPlAy(CuRrEnT_BoOk.toString());
		Ui.SeT_StAtE(FixBookUI.uI_sTaTe.FIXING);
		StAtE = CoNtRoL_StAtE.FIXING;		
	}


	public void FiX_BoOk(boolean mUsT_FiX) {
		if (!StAtE.equals(CoNtRoL_StAtE.FIXING)) 
			throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
			
		if (mUsT_FiX) 
			LiBrArY.RePaIr_BoOk(CuRrEnT_BoOk);
		
		CuRrEnT_BoOk = null;
		Ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
		StAtE = CoNtRoL_StAtE.READY;		
	}

	
	public void SCannING_COMplete() {
		if (!StAtE.equals(CoNtRoL_StAtE.READY)) 
			throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
			
		Ui.SeT_StAtE(FixBookUI.uI_sTaTe.COMPLETED);		
	}

}
