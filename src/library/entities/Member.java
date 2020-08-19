//Author: Akshay Patel
//Reviewer: Milan Vala
//Mediator: Sonal Muthukumarana

package library.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Member implements Serializable {

	//private String LaSt_NaMe;
	private String lastName;						// changed variable name LaSt_NaMe to lastName
	//private String FiRsT_NaMe;
	private String firstName;						// changed variable name FiRsT_NaMe to firstName
	//private String EmAiL_AdDrEsS;
	private String emailAdress;						// changed variable name EmAiL_AdDrEsS to emailAdress
	//private int PhOnE_NuMbEr;
	private int phoneNumber;						// changed variable name PhOnE_NuMbEr to phoneNumber
	//private int MeMbEr_Id;
	private int memberId;							// changed variable name MeMbEr_Id to memberId
	//private double FiNeS_OwInG;
	private double finesOwing;						// changed variable name FiNeS_OwInG to finesOwing
	
	//private Map<Integer, Loan> cUrReNt_lOaNs
	private Map<Integer, Loan> currentLoans;				// changed variable name cUrReNt_lOaNs to currentLoans

	
	// public Member(String lAsT_nAmE, String fIrSt_nAmE, String eMaIl_aDdReSs, int pHoNe_nUmBeR, int mEmBeR_iD) 
	public Member(String lastName, String firstName, String emailAdress, int phoneNumber, int memberId) {  // changing variable name according code style guideline
		// this.LaSt_NaMe = lAsT_nAmE;
		this.lastName = lastName;					// changed variable name LaSt_NaMe to lastName
		// this.FiRsT_NaMe = fIrSt_nAmE;
		this.firstName = firstName;					// changed variable name FiRsT_NaMe to firstName
		// this.EmAiL_AdDrEsS = eMaIl_aDdReSs;
		this.emailAdress = emailAdress;					// changed variable name EmAiL_AdDrEsS to emailAdress
		// this.PhOnE_NuMbEr = pHoNe_nUmBeR;
		this.phoneNumber = phoneNumber;					// changed variable name PhOnE_NuMbEr to phoneNumber
		// this.MeMbEr_Id = mEmBeR_iD;
		this.memberId = memberId;					// changed variable name MeMbEr_Id to memberId
		
		// this.cUrReNt_lOaNs = new HashMap<>();
		this.currentLoans = new HashMap<>();				// hanged variable name cUrReNt_lOaNs to currentLoans
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// sb.append("Member:  ").append(MeMbEr_Id).append("\n")
		sb.append("Member:  ").append(memberd).append("\n")		// changed variable name MeMbEr_Id to memberId
		  //.append("  Name:  ").append(LaSt_NaMe).append(", ").append(FiRsT_NaMe).append("\n")
		  .append("  Name:  ").append(lastName).append(", ").append(firstName).append("\n") 	// changed variable name LaSt_NaMe to lastName
		 // .append("  Email: ").append(EmAiL_AdDrEsS).append("\n")
		  .append("  Email: ").append(emailadress).append("\n")		// changed variable name EmAiL_AdDrEsS to emailAdress	
		 // .append("  Phone: ").append(PhOnE_NuMbEr)
		  .append("  Phone: ").append(phoneNumber)			// changed variable name PhOnE_NuMbEr to phoneNumber
		  .append("\n")
		 // .append(String.format("  Fines Owed :  $%.2f", FiNeS_OwInG))
		  .append(String.format("  Fines Owed :  $%.2f", finesOwning))	// changed FiNeS_OwInG to finesOwning
		  .append("\n");
		
		// for (Loan LoAn : cUrReNt_lOaNs.values()) {			// changed LoAn to loan and cUrReNt_lOaNs to currentLoans
		for (Loan loan : currentLoans.values()) {
			// sb.append(LoAn).append("\n");
			sb.append(loan).append("\n");				// changed LoAn to loan
		}		  
		return sb.toString();
	}

	
	public int GeT_ID() {
		return MeMbEr_Id;
	}

	
	public List<Loan> GeT_LoAnS() {
		return new ArrayList<Loan>(cUrReNt_lOaNs.values());
	}

	
	public int gEt_nUmBeR_Of_CuRrEnT_LoAnS() {
		return cUrReNt_lOaNs.size();
	}

	
	public double FiNeS_OwEd() {
		return FiNeS_OwInG;
	}

	
	public void TaKe_OuT_LoAn(Loan lOaN) {
		if (!cUrReNt_lOaNs.containsKey(lOaN.GeT_Id())) 
			cUrReNt_lOaNs.put(lOaN.GeT_Id(), lOaN);
		
		else 
			throw new RuntimeException("Duplicate loan added to member");
				
	}

	
	public String GeT_LaSt_NaMe() {
		return LaSt_NaMe;
	}

	
	public String GeT_FiRsT_NaMe() {
		return FiRsT_NaMe;
	}


	public void AdD_FiNe(double fine) {
		FiNeS_OwInG += fine;
	}
	
	public double PaY_FiNe(double AmOuNt) {
		if (AmOuNt < 0) 
			throw new RuntimeException("Member.payFine: amount must be positive");
		
		double change = 0;
		if (AmOuNt > FiNeS_OwInG) {
			change = AmOuNt - FiNeS_OwInG;
			FiNeS_OwInG = 0;
		}
		else 
			FiNeS_OwInG -= AmOuNt;
		
		return change;
	}


	public void dIsChArGeLoAn(Loan LoAn) {
		if (cUrReNt_lOaNs.containsKey(LoAn.GeT_Id())) 
			cUrReNt_lOaNs.remove(LoAn.GeT_Id());
		
		else 
			throw new RuntimeException("No such loan held by member");
				
	}

}
