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
				LiBrArY_fIlE.close();	
			}
			catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	
	public int gEt_BoOkId() {
		return bOoK_Id;
	}
	
	
	public int gEt_MeMbEr_Id() {
		return mEmBeR_Id;
	}
	
	
	private int gEt_NeXt_BoOk_Id() {
		return bOoK_Id++;
	}

	
	private int gEt_NeXt_MeMbEr_Id() {
		return mEmBeR_Id++;
	}

	
	private int gEt_NeXt_LoAn_Id() {
		return lOaN_Id++;
	}

	
	public List<Member> lIsT_MeMbErS() {		
		return new ArrayList<Member>(MeMbErS.values()); 
	}


	public List<Book> lIsT_BoOkS() {		
		return new ArrayList<Book>(CaTaLoG.values()); 
	}


	public List<Loan> lISt_CuRrEnT_LoAnS() {
		return new ArrayList<Loan>(CuRrEnT_LoAnS.values());
	}


	public Member aDd_MeMbEr(String lastName, String firstName, String email, int phoneNo) {		
		Member member = new Member(lastName, firstName, email, phoneNo, gEt_NeXt_MeMbEr_Id());
		MeMbErS.put(member.GeT_ID(), member);		
		return member;
	}

	
	public Book aDd_BoOk(String a, String t, String c) {		
		Book b = new Book(a, t, c, gEt_NeXt_BoOk_Id());
		CaTaLoG.put(b.gEtId(), b);		
		return b;
	}

	
	public Member gEt_MeMbEr(int memberId) {
		if (MeMbErS.containsKey(memberId)) 
			return MeMbErS.get(memberId);
		return null;
	}

	
	public Book gEt_BoOk(int bookId) {
		if (CaTaLoG.containsKey(bookId)) 
			return CaTaLoG.get(bookId);		
		return null;
	}

	
	public int gEt_LoAn_LiMiT() {
		return lOaNlImIt;
	}

	
	public boolean cAn_MeMbEr_BoRrOw(Member member) {		
		if (member.gEt_nUmBeR_Of_CuRrEnT_LoAnS() == lOaNlImIt ) 
			return false;
				
		if (member.FiNeS_OwEd() >= maxFinesOwed) 
			return false;
				
		for (Loan loan : member.GeT_LoAnS()) 
			if (loan.Is_OvEr_DuE()) 
				return false;
			
		return true;
	}

	
	public int gEt_NuMbEr_Of_LoAnS_ReMaInInG_FoR_MeMbEr(Member MeMbEr) {		
		return lOaNlImIt - MeMbEr.gEt_nUmBeR_Of_CuRrEnT_LoAnS();
	}

	
	public Loan iSsUe_LoAn(Book book, Member member) {
		Date dueDate = Calendar.gEtInStAnCe().gEt_DuE_DaTe(loanPeriod);
		Loan loan = new Loan(gEt_NeXt_LoAn_Id(), book, member, dueDate);
		member.TaKe_OuT_LoAn(loan);
		book.BoRrOw();
		LoAnS.put(loan.GeT_Id(), loan);
		CuRrEnT_LoAnS.put(book.gEtId(), loan);
		return loan;
	}
	
	
	public Loan GeT_LoAn_By_BoOkId(int bookId) {
		if (CuRrEnT_LoAnS.containsKey(bookId)) 
			return CuRrEnT_LoAnS.get(bookId);
		
		return null;
	}

	
	public double CaLcUlAtE_OvEr_DuE_FiNe(Loan LoAn) {
		if (LoAn.Is_OvEr_DuE()) {
			long DaYs_OvEr_DuE = Calendar.gEtInStAnCe().GeT_DaYs_DiFfErEnCe(LoAn.GeT_DuE_DaTe());
			double fInE = DaYs_OvEr_DuE * FiNe_PeR_DaY;
			return fInE;
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
