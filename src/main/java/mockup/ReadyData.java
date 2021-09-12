package mockup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Account;
import models.Customer;

//populate DB with mock up data 
public class ReadyData {
	
	//we set a list of customers - - Composite Pattern - Obj within obj -> List within ReadyData
	private List<Customer> bankCustomers = new ArrayList<Customer>();
	private List<Account> bankAccounts = new ArrayList<Account>();
	
	//this is a method to create our mock up data
	public void setMockBankCustomers() {
		bankCustomers.add(new Customer("Nikolaos", "Aleksandrakis"));
		bankCustomers.add(new Customer("Konstantinos", "Bolis"));
		bankCustomers.add(new Customer("Panagiotis", "Agalou"));
		bankCustomers.add(new Customer("Ioannis", "Patsoulis"));
		
		for (Customer cust: bankCustomers) {
		String sql = "INSERT INTO CUSTOMER (name, lastname) VALUES (?,?);";
		try (Connection con = utils.ConnectionFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, cust.getName());
			ps.setString(2, cust.getLastName());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Failed to insert Customer!");
			}
		}
	}
	
	
	public void setMockBankAccounts() {
		bankAccounts.add(new Account("5022852123789", 200, 1));
		bankAccounts.add(new Account("5022789456789", 100, 1));
		bankAccounts.add(new Account("5015456987412", 50, 2));
		bankAccounts.add(new Account("5015586955412", 100, 2));
		bankAccounts.add(new Account("5032025410879", 1000, 3));
		bankAccounts.add(new Account("5001520698012", 500, 4));
		for (Account acc: bankAccounts) {
		String sql = "INSERT INTO ACCOUNT (account, balance, customer_id) VALUES (?,?,?);";
		try (Connection con = utils.ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, acc.getAccount());
			ps.setInt(2, acc.getBalance());
			ps.setInt(3, acc.getCustomerId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Failed to insert Account Data!");
			}
		}
	}
}
