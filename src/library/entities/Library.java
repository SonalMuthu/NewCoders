package library.entities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Author :Sonal
//Reviwer : Milan
// Mediator : Akshay

@SuppressWarnings("serial")
public class Library implements Serializable {
	
	// changed the constains variables to correct way 
	private static final String LIBRARY_FILE = "library.obj";
	private static final int LOAN_LIMIT = 2;
	private static final int LOAN_PERIOD = 2;
	private static final double FINE_PER_DAY = 1.0;
	private static final double MAX_FINES_OWED = 1.0;
	private static final double DAMAGE_FEE = 2.0;
	
	//change the variable names to correct code styles
	private static LibrarySelf;
	private int bookid;
	private int memberid;
	private int loanid;
	private Date loandate;
	
	//private Map<Integer, Book> CaTaLoG;
	private Map<Integer, Book> catlog; //CaTaLoG changed to catlog
	//private Map<Integer, Member> MeMbErS;
	private Map<Integer, Member> members; // MeMbErS changed to members
	//private Map<Integer, Loan> LoAnS;
	private Map<Integer, Loan> loans; //LoAnS changed to loans
	//private Map<Integer, Loan> CuRrEnT_LoAnS;
	private Map<Integer, Loan> currentloans; //CuRrEnT_LoAnS changed to currentloans
	//private Map<Integer, Book> DaMaGeD_BoOkS;
	private Map<Integer, Book> damagebooks;//DaMaGeD_BoOkS changed to damagebooks
	

	private Library() {
		//change variables 
		catlog = new HashMap<>(); //CaTaLoG changed to catlog
		members = new HashMap<>(); //MeMbErS changed to members
		loans = new HashMap<>(); //LoAnS changed to loans
		currentloans = new HashMap<>();//CuRrEnT_LoAnS channged to currentloans
		damagebooks = new HashMap<>();//DaMaGeD_BoOkS changed to damagebooks
		//ccorrected the variable names
		bookId = 1; //bOoK_Id changed to bookId
		memberId = 1;//mEmBeR_Id changed to memberId	
		loanId = 1;//lOaN_Id changed to loanId	
	}

	
	public static synchronized Library getInstance() {		
		if (self == null) { //SeLf changed to self
			Path PATH = Paths.get(libraryfile);	//lIbRaRyFiLe changed to libraryfile		
			if (Files.exists(PATH)) {
				//try (ObjectInputStream LiBrArY_FiLe = new ObjectInputStream(new FileInputStream(lIbRaRyFiLe));) {
				try (ObjectInputStream libraryfile = new ObjectInputStream(new FileInputStream(libraryfile));) { //LiBrArY_FiLe changed to libraryfile
			    
					self = (Library) libraryfile.readObject(); //lIbRaRyFiLe changed to libraryfile	
					//Calendar.gEtInStAnCe().SeT_DaTe(SeLf.lOaN_DaTe);
					Calendar.getInstance().SeT_DaTe(SeLf.lOaN_DaTe); //gEtInStAnCe changed to getInstance
					libraryfile.close();
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			else self = new Library();
		}
		return self;
	}

	
	public static synchronized void SaVe() {
		if (self != null) { //SeLf changed to self
			//self.lOaN_DaTe = Calendar.gEtInStAnCe().gEt_DaTe();
			self.loandate = Calendar.getInstance().getdate(); //SeLf changed to self , lOaN_DaTe change to loandate ,gEtInStAnCe changed to getInstance, gEt_DaTe changed to getdate
			try (ObjectOutputStream libraryfile = new ObjectOutputStream(new FileOutputStream(libraryfile));) { //LiBrArY_fIlE changed to libraryfile
				libraryfile.writeObject(self); //LiBrArY_fIlE changed to libraryfile
				libraryfile.flush(); //LiBrArY_fIlE changed to libraryfile
				libraryfile.close();	//LiBrArY_fIlE changed to libraryfile
			}
			catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	
	public int getBookID() { // gEt_BoOkId changed to getBookID
		return bookId; //bOoK_Id changed to bookId
	}
	
	
	public int getMemberId() { //gEt_MeMbEr_Id changed to getMemberId
		return memberId; //mEmBeR_Id changed to memberId
	}
	
	
	private int getNextBookId() { //gEt_NeXt_BoOk_Id changed to getNextBookId
		return bookId++; //bOoK_Id changed to bookId
	}

	
	private int getNextMemberId() { //gEt_NeXt_MeMbEr_Id changed to getNextMemberId
		return memberId++; //mEmBeR_Id changed to memberId
	}

	
	private int getNextLoanId() { //gEt_NeXt_LoAn_Id changed to getNextLoanId
		return loanId++; //lOaN_Id changed to loanId
	}

	
	public List<Member> listMembers() {	//lIsT_MeMbErS changed to listMembers	
		return new ArrayList<Member>(members.values()); //MeMbErS changed to members
	}


	public List<Book> listBooks() { //lIsT_BoOkS changed to listBooks		
		return new ArrayList<Book>(catlog.values()); //CaTaLoG change to catlog
	}


	public List<Loan> listCurrentLoans() { //lISt_CuRrEnT_LoAnS change to listCurrentLoans
		return new ArrayList<Loan>(currentloans.values()); //CuRrEnT_LoAnS changed to currentloans
	}


	public Member addMember(String lastName, String firstName, String email, int phoneNo) { //aDd_MeMbEr change to addMember		
		Member member = new Member(lastName, firstName, email, phoneNo, getNextMemberId()); //gEt_NeXt_MeMbEr_Id changed to getNextMemberId 
		MeMbErS.put(member.getId(), member);	//MeMbErS changed to members
		//GeT_ID changed to getId
		return member;
	}

	
	public Book addbook(String a, String t, String c) {	//aDd_BoOk change to addbook	
		Book b = new Book(a, t, c, getnextbookId()); //gEt_NeXt_BoOk_Id change to getnextbookId
		catalog.put(b.gEtId(), b);  // CaTaLoG change to catalog	//gEtId change to getId	
		return b;
	}

	
	public Member getMember(int memberId) { //gEt_MeMbEr changed to getMember
		if (members.containsKey(memberId)) //MeMbErS changed to members
			return MeMbErS.get(memberId); //MeMbErS changed to members
		return null;
	}

	
	public Book gEt_BoOk(int bookId) { //gEt_BoOk changed to getBook
		if (catalog.containsKey(bookId)) //CaTaLoG changed to catalog
			return catalog.get(bookId); //CaTaLoG changed to catalog		
		return null;
	}

	
	public int getLoanLimit() { //gEt_LoAn_LiMiT changed to getLoanLimit
		return loanlimit; //lOaNlImIt changed to loanlimit
	}

	
	public boolean canMemberBorrow(Member member) {	//cAn_MeMbEr_BoRrOw changed to canMemberBorrow	
		if (member.getNumberOfCurrentLoans() == lOaNlImIt ) // gEt_nUmBeR_Of_CuRrEnT_LoAnS changed to getNumberOfCurrentLoans , //lOaNlImIt changed to loanlimit
			return false;
				
		if (member.finesowed() >= maxFinesOwed) //FiNeS_OwEd changed to finesowed
			return false;
				
		for (Loan loan : member.getLoans()) //GeT_LoAnS changed to getLoans
			if (loan.isoverdue()) //Is_OvEr_DuE changed to isoverdue
				return false;
			
		return true;
	}

	
	public int getRemainingLoans(Member member) {	//gEt_NuMbEr_Of_LoAnS_ReMaInInG_FoR_MeMbEr changed to getRemainingLoans	
		return loanlimit - member.getcurrentloans(); //lOaNlImIt changed to loanlimit //MeMbEr changed to member
		//gEt_nUmBeR_Of_CuRrEnT_LoAnS chaanged to getcurrentloans
	}

	
	public Loan issueLoan(Book book, Member member) { //iSsUe_LoAn changed to issueLoan
		Date dueDate = Calendar.getInstance().getDueDate(loanPeriod); //gEtInStAnCe changed to getInstance //gEt_DuE_DaTe changed to getDueDate
		Loan loan = new Loan(getnextloanId(), book, member, dueDate); //gEt_NeXt_LoAn_Id changed to getnextloanId
		member.takeoutloan(loan); //TaKe_OuT_LoAn changed to takeoutloan
		book.borrow(); //BoRrOw changed to borrow
		LoAnS.put(loan.getId(), loan); //GeT_Id changed to getId
		CuRrEnT_LoAnS.put(book.getId(), loan); //gEtId changed to getId
		return loan;
	}
	
	
	public Loan getloan(int bookId) { //GeT_LoAn_By_BoOkId changed to getloan
		if (currentloans.containsKey(bookId)) //CuRrEnT_LoAnS change to currentloans
			return currentloans.get(bookId); //CuRrEnT_LoAnS change to currentloans
		
		return null;
	}

	
	public double calculatefine(Loan loan) { //CaLcUlAtE_OvEr_DuE_FiNe changed to calculatefine //LoAn change to loan
		if (loan.isoverdue()) { //Is_OvEr_DuE changed to isoverdue
			//long DaYs_OvEr_DuE = Calendar.gEtInStAnCe().GeT_DaYs_DiFfErEnCe(LoAn.GeT_DuE_DaTe());
			long daysoverdue = Calendar.getInstance().getDaysDifference(LoAn.getduedate());
			//double fInE = DaYs_OvEr_DuE * FiNe_PeR_DaY;
			double fine = daysoverdue * fineperday;
			return fine;
		}
		return 0.0;		
	}


	public void DiScHaRgE_LoAn(Loan cUrReNt_LoAn, boolean iS_dAmAgEd) {
		Member mEmBeR = cUrReNt_LoAn.GeT_MeMbEr();
		Book bOoK  = cUrReNt_LoAn.GeT_BoOk();
		
		double oVeR_DuE_FiNe = CaLcUlAtE_OvEr_DuE_FiNe(cUrReNt_LoAn);
		mEmBeR.AdD_FiNe(oVeR_DuE_FiNe);	
		
		mEmBeR.dIsChArGeLoAn(cUrReNt_LoAn);
		bOoK.ReTuRn(iS_dAmAgEd);
		if (iS_dAmAgEd) {
			mEmBeR.AdD_FiNe(damageFee);
			DaMaGeD_BoOkS.put(bOoK.gEtId(), bOoK);
		}
		cUrReNt_LoAn.DiScHaRgE();
		CuRrEnT_LoAnS.remove(bOoK.gEtId());
	}


	public void cHeCk_CuRrEnT_LoAnS() {
		for (Loan lOaN : CuRrEnT_LoAnS.values()) 
			lOaN.cHeCk_OvEr_DuE();
				
	}


	public void RePaIr_BoOk(Book cUrReNt_BoOk) {
		if (DaMaGeD_BoOkS.containsKey(cUrReNt_BoOk.gEtId())) {
			cUrReNt_BoOk.RePaIr();
			DaMaGeD_BoOkS.remove(cUrReNt_BoOk.gEtId());
		}
		else 
			throw new RuntimeException("Library: repairBook: book is not damaged");
		
		
	}
	
	
}
