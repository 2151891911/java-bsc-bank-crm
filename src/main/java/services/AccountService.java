package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Account;

/* for business logic on account model. In this case we will create an observer pattern
that will observe withdrawals on accounts and inform the totalBalance field/property. 
Calculation is done via the respective package */

public class AccountService {
	
	public int getAccountBalance (String account, int id) {
		String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNTNUMBER = " + account + " AND CUSTOMER_ID = " + id + ";"; 
		int result=0;
		try (Connection con = utils.ConnectionFactory.getConnection(); Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery(sql);
		result = rs.getInt("balance");
		} catch (SQLException ex) {
			System.out.println("Attempt to retrieve balance failed");
		}
		return result;
	}
	
	// get account balance via input from console - user input - overloaded method
	public int getAccountBalance() {
		//get customer accounts
		System.out.println("Please type the Customer Id to report his/her accounts:");
		Scanner sc = new Scanner(System.in);
		int customerId = sc.nextInt();
		sc.close();
		getAllAccountsById(customerId);
		//define account to show balance
		System.out.println("Please type the Account to report its balance:");
		Scanner sc_acc = new Scanner(System.in);
		String accountNum = sc_acc.next();
		sc_acc.close();		
		return getAccountBalance(accountNum, customerId);
	}

	// useful for reports or other methods
	public List<Account> getAllAccountsById (int id){
		List<Account> result = new ArrayList<Account>();
		String sql = "SELECT * FROM ACCOUNT WHERE CUSTOMER_ID = " + id + ";";
		try (Connection con = utils.ConnectionFactory.getConnection(); Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery(sql);
			// while there are more customers to show - loop
			while (rs.next()) {
				Account temp = new Account();
				temp.setAccount(rs.getString(0));
				temp.setBalance(rs.getInt(1));
				result.add(temp);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	// get customer all accounts via input from console - user input - overloaded method
	public List<Account> getAllAccountsById() {
		List<Account> result = new ArrayList<Account>();
		System.out.println("Please Provide the Customer Id to report his/her total balance:");
		Scanner sc = new Scanner(System.in);
		int customerId = sc.nextInt();
		sc.close();
		getAllAccountsById(customerId);
		return result;
	}
		
	// inform the new balance to DB - useful for withdraw or deposit
	public void updateBalance(int balance, String accountNum, int cusId) {
		String sql = "UPDATE ACCOUNT SET BALANCE = " + balance 
		+ "WHERE ACCOUNTNUMBER = " + accountNum + "AND CUSTOMER_ID = " + cusId + ";";
		try (Connection con = utils.ConnectionFactory.getConnection(); Statement st = con.createStatement();) {
			// we just want to inform the DB via this method
			st.executeQuery(sql);
		} catch (SQLException ex) {
			System.out.println("Attempt to retrieve balance failed");
		}
	}
	
	// the withdraw action has to retrieve info and then update
	public void withdraw() {
			System.out.println("Please type your id:");
			Scanner id_sc = new Scanner(System.in);
			// set withdrawId
			int withdrawId = id_sc.nextInt();
			id_sc.close();
			// show optional accounts
			getAllAccountsById(withdrawId);
			System.out.println("Please type the account you wish to withdraw from:");
			Scanner acc_sc = new Scanner(System.in);
			// set withdrawAccount
			String withdrawAccount = acc_sc.next();
			acc_sc.close();
			System.out.println("Please Insert the ammount you wish to withdraw:");
			Scanner sc = new Scanner(System.in);
			int takeMoney = sc.nextInt();
			sc.close();
			// get balance from DB
			int currentBalance = getAccountBalance(withdrawAccount, withdrawId);
			int resultBalance = currentBalance - takeMoney;
			//set balance to DB
			if (resultBalance<0) {
			System.out.println("You do not have enough money for this withdrawal!");
			System.out.println("type zero [0] to end process.");
			} else {
			updateBalance(resultBalance, withdrawAccount, withdrawId);
			}
		}
	
	// likewise for the deposit
	public void deposit() {
		System.out.println("Please type your id:");
		Scanner id_sc = new Scanner(System.in);
		// set withdrawId
		int depositId = id_sc.nextInt();
		id_sc.close();
		// show optional accounts
		getAllAccountsById(depositId);
		System.out.println("Please type the account you wish to deposit to:");
		Scanner acc_sc = new Scanner(System.in);
		// set withdrawAccount
		String depositAccount = acc_sc.next();
		acc_sc.close();
		System.out.println("Please Insert the ammount you wish to deposit:");
		Scanner sc = new Scanner(System.in);
		int saveMoney = sc.nextInt();
		sc.close();
		// get balance from DB
		int currentBalance = getAccountBalance(depositAccount, depositId);
		int resultBalance = currentBalance + saveMoney;
		updateBalance(resultBalance, depositAccount, depositId);
		}

}
