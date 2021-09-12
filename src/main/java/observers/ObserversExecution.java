package observers;

import models.Account;

//run observers class
public class ObserversExecution {
	
	public void notificationFromTransaction(int amount) {
		
	Account acc = new Account();
	
	//init observing resources
	AccountAuditObserver audit = new AccountAuditObserver();
	acc.addAccountObserver(audit);
	AccountThresholdObserver threshold = new AccountThresholdObserver();
	acc.addAccountObserver(threshold);

	//via the transaction set amount the observer returns a result
	acc.setBalance(amount);
	}

}
