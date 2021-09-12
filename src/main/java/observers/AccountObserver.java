package observers;

import models.Account;

public abstract class AccountObserver {
	
	//so the child can access
	protected Account account;
    //this is the method that each observer has to implement
    public abstract void update(Account a);

}
