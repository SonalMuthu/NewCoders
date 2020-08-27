package library.entities;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Loan implements Serializable {
	
	//public static enum lOaN_sTaTe { CURRENT, OVER_DUE, DISCHARGED };
	public static enum loanState { CURRENT, OVER_DUE, DISCHARGED };
	//private int LoAn_Id;
	private int loanId;
	//private Book BoOk;
	private Book book;
	//private Member MeMbEr;
	private Member member;
	//private Date DaTe;
	private Date date;
	//private lOaN_sTaTe StAtE;
	private loanState state;


	
	public Loan(int loanId, Book book, Member member, Date deuDate) { //public Loan(int loanId, Book bOoK, Member mEmBeR, Date DuE_dAtE) {
		/* this.LoAn_Id = loanId;
		this.BoOk = bOoK;
		this.MeMbEr = mEmBeR;
		this.DaTe = DuE_dAtE;
		this.StAtE = lOaN_sTaTe.CURRENT; */
		
		this.loanId = loanId;
		this.book = book;
		this.member = member;
		this.date = dueDate;
		this.state = loanState.CURRENT;
	}

	
	public void CheckOverDue() {		// public void cHeCk_OvEr_DuE()-metthod name change:cHeCk_OvEr_DuE() to CheckOverDue
		if (StAtE == lOaN_sTaTe.CURRENT &&
			Calendar.gEtInStAnCe().gEt_DaTe().after(DaTe)) 
			this.StAtE = lOaN_sTaTe.OVER_DUE;			
		
	}

	
	public boolean IsOverDue() {		//public boolean Is_OvEr_DuE()- method name change:Is_OvEr_DuE() to IsOverDue
		return state == LoanState.OverDue;		//return StAtE == lOaN_sTaTe.OVER_DUE;
	}

	
	public Integer getId() { // public Integer GeT_Id()
		return loanId; //return LoAn_Id;
	}


	public Date getDueDate() { //public Date GeT_DuE_DaTe() {
		return date; //return DaTe;
	}
	
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		StringBuilder sb = new StringBuilder();
		sb.append("Loan:  ").append(loanId).append("\n") //sb.append("Loan:  ").append(LoAn_Id).append("\n")
		  .append("  Borrower ").append(member.getId()).append(" : ") //.append("  Borrower ").append(MeMbEr.GeT_ID()).append(" : ")
		  .append(member.getLastName()).append(", ").append(member.getFirstName()).append("\n") //  .append(MeMbEr.GeT_LaSt_NaMe()).append(", ").append(MeMbEr.GeT_FiRsT_NaMe()).append("\n")
		  .append("  Book ").append(book.getId()).append(" : " ) //.append("  Book ").append(BoOk.gEtId()).append(" : " )
		  .append(book.getTittle()).append("\n") // .append(BoOk.gEtTiTlE()).append("\n")
		  .append("  DueDate: ").append(sdf.format(DaTe)).append("\n")
		  .append("  State: ").append(state);		//.append("  State: ").append(StAtE);	
		return sb.toString();
	}


	public Member GeT_MeMbEr() { //public Member getMember() {
		return member; //return MeMbEr;
	}


	public Book getBook() { // public Book GeT_BoOk() {
		return book; //return BoOk;
	}


	public void discharge() { //public void DiScHaRgE() {
		state = loanState.DISCHARGED;	//StAtE = lOaN_sTaTe.DISCHARGED;		
	}

}
