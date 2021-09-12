package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import models.Customer;


public class CustomerService{

	// get a customer input from user
	public Customer recordCustomer() {
		// first name
		System.out.println("Please input Customer's First Name: ");
		Scanner name = new Scanner(System.in);
		String firstName = name.nextLine().toUpperCase();
		name.close();
		// last name
		System.out.println("Please input Customer's Last Name: ");
		Scanner last = new Scanner(System.in);
		String lastName = last.nextLine().toUpperCase();
		last.close();
		return new Customer(firstName, lastName);
	}

	// the actual method that does insert the customer to DB - JDBC
	public void insertCustomer(Customer cust) {
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

	// delete all customers - management tool
	public void deleteAllCustomers() {
		String sql = "DELETE * FROM CUSTOMER;";
		try (Connection con = utils.ConnectionFactory.getConnection();) {
			Statement st = con.createStatement();
			st.executeQuery(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Connection Failed");
		}
	}

	// get a list of all customers from the DB - simple JDBC
	public List<Customer> getAllCustomers() {
		List<Customer> result = new ArrayList<Customer>();
		String sql = "SELECT * FROM CUSTOMER;";
		try (Connection con = utils.ConnectionFactory.getConnection(); Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery(sql);
			// while there is still more customers - loop
			while (rs.next()) {
				Customer temp = new Customer();
				temp.setName(rs.getString(1));
				temp.setLastName(rs.getString(2));
				result.add(temp);
			}
		} catch (SQLException ex) {
			System.out.println("failed to get all customers.");
			ex.printStackTrace();
		}
		return result;
	}

	// get customer personal data via his id
	public Customer getCustomerById() {
		System.out.println("Please Provide the Customer Id to report his/her data:");
		Scanner sc = new Scanner(System.in);
		int customerId = sc.nextInt();
		sc.close();
		String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = " + customerId + "?;";
		Customer temp = new Customer();
		try (Connection con = utils.ConnectionFactory.getConnection();) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			temp.setName(rs.getString(2));
			temp.setLastName(rs.getString(3));
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Connection Failed");
		}
		return temp;
	}

	//to just get the balance
	public int getTotalCustomerBalance() {
		System.out.println("Please Input Customer id to show total position:");
		Scanner sc = new Scanner(System.in);
		int customerId = sc.nextInt();
		sc.close();
		int customerPosition=0;
		String sql = "SELECT SUM(BALANCE) AS TOTALBALANCE FROM ACCOUNT WHERE CUSTOMER_ID= " + customerId + ";";
		try (Connection con = utils.ConnectionFactory.getConnection(); Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery(sql);
			customerPosition = rs.getInt(1);
		} catch (SQLException ex) {
			System.out.println("Connection Failed.");
		}
		return customerPosition;
	}
	

}
