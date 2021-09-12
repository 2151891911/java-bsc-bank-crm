package models;

import java.util.ArrayList;
import java.util.List;
import observers.AccountObserver;

/* This is the model class that will be the observable subject as per the observer pattern. 
 * Hence, it has a list of its observers, a method to add them, and methods to notify them. 
 */
public class Account {

	private String account;
	private int balance;
	private int customerId;
	// composite pattern and a prerequisite for the observer pattern
	private List<AccountObserver> observers = new ArrayList<AccountObserver>();

	
	public Account() {
		super();
	}
	
	public Account(String account, int balance, int customerId) {
		super();
		this.account = account;
		this.balance = balance;
		this.customerId = customerId;		
	}
	
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBalance() {
		return balance;
	}

	// a. we wish to notify for the setting of the balance
	public void setBalance(int balance) {
		this.balance = balance;
		// each time something changes in the balance the observer is notified
		notifyObservers();
	}

	// b. we wish to add the observers in the list and through their father class
	public void addAccountObserver(AccountObserver accobs) {
		observers.add(accobs);
	}

	/* each observer calls the update() method. This method runs DIFFERENTY for each
	 * observer which leads to different interpretation of the same data
	 */
	public void notifyObservers() {
		for (AccountObserver accobs : observers) {
			// this refers to the whole Account object
			accobs.update(this);
		}
	}


}
