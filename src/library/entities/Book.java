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
		  .append("  CallNo: ").append(CALLNO).append("\n")
		  .append("  State:  ").append(StAtE);
		
		return sb.toString();
	}

	public Integer gEtId() {
		return iD;
	}

	public String gEtTiTlE() {
		return tItLe;
	}


	
	public boolean iS_AvAiLaBlE() {
		return StAtE == sTaTe.AVAILABLE;
	}

	
	public boolean iS_On_LoAn() {
		return StAtE == sTaTe.ON_LOAN;
	}

	
	public boolean iS_DaMaGeD() {
		return StAtE == sTaTe.DAMAGED;
	}

	
	public void BoRrOw() {
		if (StAtE.equals(sTaTe.AVAILABLE)) 
			StAtE = sTaTe.ON_LOAN;
		
		else 
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", StAtE));
		
		
	}


	public void ReTuRn(boolean DaMaGeD) {
		if (StAtE.equals(sTaTe.ON_LOAN)) 
			if (DaMaGeD) 
				StAtE = sTaTe.DAMAGED;
			
			else 
				StAtE = sTaTe.AVAILABLE;
			
		
		else 
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", StAtE));
				
	}

	
	public void RePaIr() {
		if (StAtE.equals(sTaTe.DAMAGED)) 
			StAtE = sTaTe.AVAILABLE;
		
		else 
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", StAtE));
		
	}


}
