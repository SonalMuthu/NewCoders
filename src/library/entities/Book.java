package library.entities;
import java.io.Serializable;


@SuppressWarnings("serial")
public class Book implements Serializable {
	

	// private String tItLe;
	private String title;// variablr name changed from tItle to title
	//private String AuThOr; 
	private String author;//variable name changed from Author to author
	//private String CALLNO;
	private String callNo;//variable name changed from CALLNO to callNo
	//private int iD;
	private int id;// variable name changed from iD to id
	
	//private enum sTaTe { AVAILABLE, ON_LOAN, DAMAGED, RESERVED };
	private enum state { AVAILABLE, ON_LOAN, DAMAGED, RESERVED };//variable name changed from sTaTe to state
	private state;
	
	public Book(String author, String title, String callNo, int id) {
		//this.AuThOr = author;
		this.author = author;
		//this.tItLe = title;
		this.title = title;
		//this.CALLNO = callNo;
		this.callNo = callNo;
		//this.iD = id;
		this.id = id;
		//this.StAtE = sTaTe.AVAILABLE;
		this.stste = state.AVAILABLE;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		//sb.append("Book: ").append(iD).append("\n")
		sb.append("Book: ").append(id).append("\n")
		//  .append("  Title:  ").append(title).append("\n")
	            .append("  Title:  ").append(tItLe).append("\n")
	      // .append("  Author: ").append(AuThOr).append("\n")
		  .append("  Author: ").append(author).append("\n")
		  //.append("  CallNo: ").append(CALLNO).append("\n")
		  .append("  CallNo: ").append(callNo).append("\n")
		  //.append("  State:  ").append(StAtE);
		   .append("  State:  ").append(state);
		
		return sb.toString();
	}

	public Integer getId() {    // public Integer gEtId()- method name change from gEtId to getId()
		return id;// variable name chang from iD to id
	}

	public String getTitle() {   // public Integer gEtTiTlE()- method name change from gEtTiTlE() to getTitle()
		return title; // variable name chang from tItLe to title
	}


	
	public boolean isAvAiLaBlE() { 	// public Integer iS_AvAiLaBlE()- method name change from iS_AvAiLaBlE() to isAvalable()
	}

	
	public boolean isOnLoan() {		// public Integer iS_On_LoAn()- method name change from iS_On_LoAn() to isOnLoan()
		return state == state.onLoan;	//return state == stste.onLoan	
	}

	
	public boolean isDamaged() { //public boolean iS_DaMaGeD() {
		return state == state.DAMAGED; //return StAtE == sTaTe.DAMAGED;
	}

	
	public void borrow() { //public void BoRrOw() {
		if (state.equals(state.AVAILABLE)){ //if (StAtE.equals(sTaTe.AVAILABLE)) 
			state = sate.onLoan; //  StAtE = sTaTe.ON_LOAN; 
		}
		else 
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", state)); //throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", StAtE));
		
		
	}


	public void return(boolean damaged) { //public void ReTuRn(boolean DaMaGeD) {
		//if (StAtE.equals(sTaTe.ON_LOAN))
		if (state.equals(state.onLoan)) {		//curly brackets "{ " use for if else statement
			
			if (damaged) { //if (DaMaGeD) {
				state = state.DAMAGED; //StAtE = sTaTe.DAMAGED;
			}
			
			else {
				state = state.AVAILABLE; // StAtE = sTaTe.AVAILABLE
			}
		}
			
		
		else {
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", state)); //throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", StAtE));
		}
				
	}

	
	public void repair() { //public void RePaIr() {
		if (state.equals(state.DAMAGED)) { //if (StAtE.equals(sTaTe.DAMAGED)) {
			state = state.AVAILABLE; //StAtE = sTaTe.AVAILABLE;
		}
		
		else {
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", state)); //throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", StAtE));
		}
		
	}


}
