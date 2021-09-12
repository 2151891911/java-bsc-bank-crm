package observers;

import models.Account;

//this view is to observe for high class customers
public class AccountThresholdObserver extends AccountObserver {

	@Override
	public void update(Account a) {
		if (a.getBalance() > 19999) {
			System.out.println("The customer is higher class!");

			//TODO: add amount - get total for that customer report if is wealthy segment
			
			
			
			System.out.println("Customer added to wealthy segment");
		}
	}
}
