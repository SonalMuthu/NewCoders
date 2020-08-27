package library;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import library.borrowbook.BorrowBookUI;
import library.borrowbook.bORROW_bOOK_cONTROL;
import library.entities.Book;
import library.entities.Calendar;
import library.entities.Library;
import library.entities.Loan;
import library.entities.Member;
import library.fixbook.FixBookUI;
import library.fixbook.fIX_bOOK_cONTROL;
import library.payfine.PayFineUI;
import library.payfine.pAY_fINE_cONTROL;
import library.returnBook.ReturnBookUI;
import library.returnBook.rETURN_bOOK_cONTROL;


public class Main {
	/*private static Scanner IN;
	private static Library LIB;
	private static String MENU;
	private static Calendar CAL;
	private static SimpleDateFormat SDF; */
	// variable names changed
	private static Scanner in;
	private static Library lib;
	private static String menu;
	private static Calendar cal;
	private static SimpleDateFormat sdf;
	
	
	//private static String Get_menu() {
	private static String getMEnu() { // method name changed
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nLibrary Main Menu\n\n")
		  .append("  M  : add member\n")
		  .append("  LM : list members\n")
		  .append("\n")
		  .append("  B  : add book\n")
		  .append("  LB : list books\n")
		  .append("  FB : fix books\n")
		  .append("\n")
		  .append("  L  : take out a loan\n")
		  .append("  R  : return a loan\n")
		  .append("  LL : list loans\n")
		  .append("\n")
		  .append("  P  : pay fine\n")
		  .append("\n")
		  .append("  T  : increment date\n")
		  .append("  Q  : quit\n")
		  .append("\n")
		  .append("Choice : ");
		  
		return sb.toString();
	}


	public static void main(String[] args) {		
		try {			
			in = new Scanner(System.in);//IN = new Scanner(System.in);
			lib = Library.getInstance(); //LIB = Library.GeTiNsTaNcE();
			cal = Calendar.getInstance();  //CAL = Calendar.gEtInStAnCe();
			sdf = new SimpleDateFormat("dd/MM/yyyy"); //SDF = new SimpleDateFormat("dd/MM/yyyy");
	
			for (Member m : lib.listMembers()) { //for (Member m : LIB.lIsT_MeMbErS()) {
				output(m);
			}
			output(" ");
			for (Book b : lib.listBooks()) { //for (Book b : LIB.lIsT_BoOkS()) {
				output(b);
			}
						
			menu = getMenu(); //MENU = Get_menu();
			
			boolean e = false;
			
			while (!e) {
				
				output("\n" + sdf.format(cal.getDate())); // output("\n" + SDF.format(CAL.gEt_DaTe()));
				String c = input(menu); //String c = input(MENU);
				
				switch (c.toUpperCase()) {
				
				case "M": 
					addMember(); //ADD_MEMBER();
					break;
					
				case "LM": 
					listMembers(); //LIST_MEMBERS();
					break;
					
				case "B": 
					addBook(); //ADD_BOOK();
					break;
					
				case "LB": 
					listBooks; //LIST_BOOKS();
					break;
					
				case "FB": 
					fixBooks();//FIX_BOOKS();
					break;
					
				case "L": 
					birrowBook(); //BORROW_BOOK();
					break;
					
				case "R": 
					returnBook(); //RETURN_BOOK();
					break;
					
				case "LL": 
					listCurrentLoans(); //LIST_CURRENT_LOANS();
					break;
					
				case "P": 
					payFines(); //PAY_FINES();
					break;
					
				case "T": 
					incrementDate(); //INCREMENT_DATE();
					break;
					
				case "Q": 
					e = true;
					break;
					
				default: 
					output("\nInvalid option\n");
					break;
				}
				
				Library.Save(); //Library.SaVe();
			}			
		} catch (RuntimeException e) {
			output(e);
		}		
		output("\nEnded\n");
	}	

	
	private static void payFines() { //private static void PAY_FINES() {
		new PayFineUI(new payFineControl()).run();	//new PayFineUI(new pAY_fINE_cONTROL()).RuN();	
	}


	private static void listCurrentLoans() { // private static void LIST_CURRENT_LOANS() 
		output("");
		for (Loan loan : lib.listCurrentLoans()) { //for (Loan loan : LIB.lISt_CuRrEnT_LoAnS()) {
			output(loan + "\n");
		}		
	}



	private static void listBooks() { //private static void LIST_BOOKS() {
		output("");
		for (Book book : lib.listBooks()) { //for (Book book : LIB.lIsT_BoOkS()) {
			output(book + "\n");
		}		
	}



	private static void listMembers() { //private static void LIST_MEMBERS() {
		output("");
		for (Member member : lib.listMembers()) { //for (Member member : LIB.lIsT_MeMbErS()) {
			output(member + "\n");
		}		
	}



	private static void borrowBook() { //private static void BORROW_BOOK() {
		new BorrowBookUI(new borrowBookControl()).run(); //new BorrowBookUI(new bORROW_bOOK_cONTROL()).RuN();				
	}


	private static void returnBook() { //private static void RETURN_BOOK() {
		new ReturnBookUI(new returnBookControl()).run(); //new ReturnBookUI(new rETURN_bOOK_cONTROL()).RuN();		
	}


	private static void fixBooks() { //private static void FIX_BOOKS() {
		new FixBookUI(new fixBookControl()).run(); //new FixBookUI(new fIX_bOOK_cONTROL()).RuN();		
	}


	private static void incrementDate() { //private static void INCREMENT_DATE() {
		try {
			int days = Integer.valueOf(input("Enter number of days: ")).intValue();
			cal.incrementDate(days); //CAL.incrementDate(days);
			lib.checkCurrentLoans();  //LIB.cHeCk_CuRrEnT_LoAnS();
			output(sdf.format(cal.getDate())); //output(SDF.format(CAL.gEt_DaTe()));
			
		} catch (NumberFormatException e) {
			 output("\nInvalid number of days\n");
		}
	}


	private static void addBook() { //private static void ADD_BOOK() {
		
		String auther = input("Enter author: "); //String AuThOr = input("Enter author: ");
		String title  = input("Enter title: "); //String TiTlE  = input("Enter title: ");
		String callMember = input("Enter call number: "); //String CaLl_NuMbEr = input("Enter call number: ");
		Book book = lib.addBook(author, title, callNumber); //Book BoOk = LIB.aDd_BoOk(AuThOr, TiTlE, CaLl_NuMbEr);
		output("\n" + BoOk + "\n");
		
	}

	
	private static void addMember() { //private static void ADD_MEMBER() {
		try {
			String lastName = input("Enter last name: "); //String LaSt_NaMe = input("Enter last name: ");
			String firstName  = input("Enter first name: "); //String FiRsT_NaMe  = input("Enter first name: ");
			String emailAddress = input("Enter email address: "); //String EmAiL_AdDrEsS = input("Enter email address: ");
			int phoneNumber = Integer.valueOf(input("Enter phone number: ")).intValue(); //int PhOnE_NuMbEr = Integer.valueOf(input("Enter phone number: ")).intValue();
			Member member = lib.addmember(LaSt_NaMe, FiRsT_NaMe, EmAiL_AdDrEsS, PhOnE_NuMbEr); //Member MeMbEr = LIB.aDd_MeMbEr(LaSt_NaMe, FiRsT_NaMe, EmAiL_AdDrEsS, PhOnE_NuMbEr);
			output("\n" + member + "\n"); //output("\n" + MeMbEr + "\n");
			
		} catch (NumberFormatException e) {
			 output("\nInvalid phone number\n");
		}
		
	}


	private static String input(String prompt) {
		System.out.print(prompt);
		return in.nextLine(); //return IN.nextLine();
	}
	
	
	
	private static void output(Object object) {
		System.out.println(object);
	}

	
}
