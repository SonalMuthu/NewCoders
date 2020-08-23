package library.borrowbook;
import java.util.ArrayList;
import java.util.List;

import library.entities.Book;
import library.entities.Library;
import library.entities.Loan;
import library.entities.Member;

//public class bORROW_bOOK_cONTROL
public class borrowBookControl { // bORROW_bOOK_cONTROL change to borrowBookControl
	
	private BorrowBookUI uI;
	
	/*private Library lIbRaRy;
	private Member mEmBeR;*/
	private Library lIbRaRy;
	private Member mEmBeR;
	private enum CONTROL_STATE { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED };
	private CONTROL_STATE state; //sTaTe change to state
	
	private List<Book> booksPending; //pEnDiNg_LiSt change to booksPending
	private List<Loan> completedList; //cOmPlEtEd_LiSt change to completedList
	private Book book; //bOoK change to book
	
	
	public borrowBookControl() { //bORROW_bOOK_cONTROL change to borrowBookControl
		this.library = Library.getInstance(); //lIbRaRy change to library // GeTiNsTaNcE change to getInstance
		state = controlState.initialised; //sTaTe change to state //CONTROL_STATE change to controlState //INITIALISED change to initialised
	}
	

	public void setUI(BorrowBookUI Ui) { //SeT_Ui setUI
		if (!state.equals(controlState.initialised)) //sTaTe change state
			throw new RuntimeException("BorrowBookControl: cannot call setUI except in INITIALISED state");
			
		this.uI = Ui;
		Ui.SeT_StAtE(BorrowBookUI.uI_STaTe.READY);
		sTaTe = CONTROL_STATE.READY;		
	}

		
	public void swiped(int memberId) { //SwIpEd change to swiped //mEmBeR_Id change to memberId
		if (!state.equals(controlState.ready)) //sTaTe change to state
			throw new RuntimeException("BorrowBookControl: cannot call cardSwiped except in READY state");
			
		member = library.getmember(mEmBeR_Id); //lIbRaRy change to library //gEt_MeMbEr change to getmember
		if (member == null) { //mEmBeR change to member
			uI.display("Invalid memberId"); //DiSpLaY change to display
			return;
		}
		if (library.memberBorrow(member)) { //lIbRaRy change to library //cAn_MeMbEr_BoRrOw memberBorrow //mEmBeR change to member
			pendingList = new ArrayList<>(); //pEnDiNg_LiSt change to pendingList
			uI.setState(BorrowBookUI.uI_STaTe.SCANNING); //SeT_StAtE change to setState
			sTaTe = controlState.SCANNING; //CONTROL_STATE change to controlState
		}
		else {
			uI.display("Member cannot borrow at this time"); //DiSpLaY change to display
			uI.setState(BorrowBookUI.uI_STaTe.RESTRICTED);  //SeT_StAtE change to setState
		}
	}
	
	
	public void scanned(int bOoKiD) { //ScAnNeD change to scanned
		book = null; //bOoK change to book
		if (!state.equals(controlState.SCANNING)) //sTaTe change to state 
			throw new RuntimeException("BorrowBookControl: cannot call bookScanned except in SCANNING state");
			
		book = library.getbook(bookId); //bOoK change to book //bOoKiD change to bookId //lIbRaRy change to library //gEt_BoOk change to getbook
		if (book == null) {
			uI.display("Invalid bookId"); //DiSpLaY change to display
			return;
		}
		if (!bOoK.isavailabe()) { //iS_AvAiLaBlE change to isavailabe
			uI.DiSpLaY("Book cannot be borrowed");
			return;
		}
		pEnDiNg_LiSt.add(bOoK);
		for (Book B : pEnDiNg_LiSt) 
			uI.DiSpLaY(B.toString());
		
		if (lIbRaRy.gEt_NuMbEr_Of_LoAnS_ReMaInInG_FoR_MeMbEr(mEmBeR) - pEnDiNg_LiSt.size() == 0) {
			uI.DiSpLaY("Loan limit reached");
			CoMpLeTe();
		}
	}
	
	
	public void Complete() { //CoMpLeTe change to Complete
		if (pEnDiNg_LiSt.size() == 0) 
			CaNcEl();
		
		else {
			uI.display("\nFinal Borrowing List"); //DiSpLaY change to display
			for (Book bOoK : pEnDiNg_LiSt) 
				uI.DiSpLaY(bOoK.toString());
			
			cOmPlEtEd_LiSt = new ArrayList<Loan>();
			uI.SeT_StAtE(BorrowBookUI.uI_STaTe.FINALISING);
			sTaTe = CONTROL_STATE.FINALISING;
		}
	}


	public void CommitLoans() { //CoMmIt_LoAnS change to CommitLoans
		if (!sTaTe.equals(CONTROL_STATE.FINALISING)) 
			throw new RuntimeException("BorrowBookControl: cannot call commitLoans except in FINALISING state");
			
		for (Book B : pEnDiNg_LiSt) {
			Loan lOaN = lIbRaRy.iSsUe_LoAn(B, mEmBeR);
			cOmPlEtEd_LiSt.add(lOaN);			
		}
		uI.DiSpLaY("Completed Loan Slip");
		for (Loan LOAN : cOmPlEtEd_LiSt) 
			uI.DiSpLaY(LOAN.toString());
		
		uI.SeT_StAtE(BorrowBookUI.uI_STaTe.COMPLETED);
		sTaTe = CONTROL_STATE.COMPLETED;
	}

	
	public void Cancel() { //CaNcEl change to Cancel
		uI.SeT_StAtE(BorrowBookUI.uI_STaTe.CANCELLED);
		sTaTe = CONTROL_STATE.CANCELLED;
	}
	
	
}
