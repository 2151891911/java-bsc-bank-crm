package services;

import mockup.ReadyData;
import models.Account;
import models.Customer;
import repos.Reports;

// a class to write results to console - report
// it has to contain an implementation of ALL methods of interface
public class ReportService implements Reports {
	
	//set up resources
	CustomerService scust = new CustomerService();
	AccountService sacc = new AccountService();
	ReadyData data = new ReadyData();
			
	
	@Override
	public void showAccountBalance() {
		int balance = sacc.getAccountBalance();
		System.out.println(balance);
	}
	
	
	//could use method -> scust.getAllCustomers().forEach(System.out::println);
	

	@Override
	public void showAllCustomers() {
        StringBuilder sb = new StringBuilder("\t      Displaying List of Recorded Customers: ");
        for (Customer cust : scust.getAllCustomers()) {
            sb.append("\n");
            sb.append(cust);
        }
        System.out.println(sb);//prints all customers as a list to the console
	}

	@Override
	public void showAllAccountsById() {
        StringBuilder sb = new StringBuilder("\t   Displaying List of Accounts for the Selected Customer: ");
        for (Account acc : sacc.getAllAccountsById()) {
            sb.append("\n");
            sb.append(acc);
        }
        System.out.println(sb);//prints all accounts as a list to the console
	}

	@Override
	public void showTotalCustomerBalance() {
		int reportCustomerPosition = scust.getTotalCustomerBalance();
		System.out.println("Total Balance is: " + reportCustomerPosition);
	}

	@Override
	public void insertMockData() {
		data.setMockBankCustomers();
		data.setMockBankAccounts();
	}

}
