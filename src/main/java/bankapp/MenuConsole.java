package bankapp;

import java.util.InputMismatchException;
import java.util.Scanner;
import factrories.FactoryProvider;
import factrories.InsuranceFactory;
import products.CardCredit;
import products.CardDebit;
import repos.Insurance;
import repos.Reports;
import services.AccountService;
import services.CustomerService;
import services.ReportService;
import strategies.CardDeactivationContext;

//creation of menu in console - flow practice
public class MenuConsole {
	
	//instantiation of services and options - Facade Pattern
	private CustomerService customerService;
	private AccountService accountService;
	
	//interface implementation
	Reports repo = new ReportService();
	
	//factory implementation
	InsuranceFactory insureConstruct = new InsuranceFactory();
	
	//Strategy Context implementation - create obj and apply some behavior to it.
	CardCredit ccredit = new CardCredit();
	CardDebit cdebit = new CardDebit();
	CardDeactivationContext ctx = new CardDeactivationContext(ccredit, new CardDebit());
	
	//initialize input and counters/switches
	Scanner sc = new Scanner(System.in);
	int menuchoice;
	boolean transact = false;
	boolean product = false;

	//transact = false
	public void menuMain(int menuchoice) {
		switch (menuchoice) { 
			case 1: customerService.insertCustomer(customerService.recordCustomer());
			break;
			case 2: repo.insertMockData();
			break;
			case 3: repo.showTotalCustomerBalance();
			break;
			case 4: repo.showAllCustomers();
			break;
			case 5: customerService.deleteAllCustomers();
			break;
			case 6: transact = true;
			break;
			default: System.out.println("Please provide proper input");
			break;
		}
	}
	
	//transact = true
	public void menuTransact(int menuchoice) {
		switch (menuchoice) {
			case 1: accountService.withdraw();
			break;
			case 2: accountService.deposit();
			break;
			case 3: repo.showTotalCustomerBalance();
			break;
			case 4: transact = false;
			break;
			default: System.out.println("Please provide proper input");
			break;
		}
	}
	
	// for design patterns implementation abstract factory and factory patterns 
	public void getProduct(int menuchoice) {
		switch (menuchoice) {
		case 1: CardCredit credit = (CardCredit) FactoryProvider.getFactory("Card").create("DEBIT");
		System.out.println(credit);//abstract factory pattern
		break;
		case 2: CardDebit debit = (CardDebit) FactoryProvider.getFactory("Card").create("DEBIT");
		System.out.println(debit);//abstract factory pattern
		break;
		case 3: Insurance auto = insureConstruct.create("AUTO");
		System.out.println(auto);//factory pattern
		break;
		case 4: Insurance life = insureConstruct.create("LIFE");
		System.out.println(life);//factory pattern
		break;
		case 5: 
		case 6: transact = false;
		break;
		}
		
	}
	
	public void printMenuOptions(boolean transact) {
			System.out.println();
		if (transact == false) {
			System.out.println("\t[1] Record a Customer.");
			System.out.println("\t[2] Set Mock Data.");
			System.out.println("\t[3] Show Customer Balance");
			System.out.println("\t[4] Show all Customers.");
			System.out.println("\t[5] Delete all Customers.");
			System.out.println("\t[6] Make Transaction.");	
		} else {
			System.out.println("\t[1] Withdraw Money.");
			System.out.println("\t[2] Deposit Money.");
			System.out.println("\t[3] Customer Position.");
			System.out.println("\t[4] Go Back.");
		}
	}
	
	public void playMenu() {
			System.out.println("\t [Bank Cashier Application]\n");
			
		do {
    	    System.out.println("   Choose Menu option or press '0' to exit: \n");
			printMenuOptions(transact);
    	    menuchoice = sc.nextInt();

			if (!(menuchoice < 7 && menuchoice > -1)) {
				throw new InputMismatchException("Wrong Input");
			} else if (transact == false) {
				menuMain(menuchoice);	
			} else if (transact == true) {
				menuTransact(menuchoice);
			}
		} while (menuchoice != 0);
		sc.close();
		//outside the loop say bye (start = 0)
		System.out.println("");
		System.out.println("\tThanks for Using Cashier App. Bye.");
	}
}


		

