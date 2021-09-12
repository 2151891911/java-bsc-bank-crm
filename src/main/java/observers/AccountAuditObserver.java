package observers;

import models.Account;

// this view is to observe for audit purposes
public class AccountAuditObserver extends AccountObserver {

	@Override
	public void update(Account a) {
		if (a.getBalance() > 49999) {
			System.out.println("The transaction needs audition!");
		} else {
			System.out.println("transaction normal.");
		}
	}
}
