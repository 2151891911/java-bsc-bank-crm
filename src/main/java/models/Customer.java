package models;

//main class for bank customers
public class Customer {

	private int id;
	private String name;
	private String lastName;
	private String wealthysegment;
	private String gdpr;

	// getters setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getWealthysegment() {
		return wealthysegment;
	}

	public void setWealthysegment(String wealthysegment) {
		this.wealthysegment = wealthysegment;
	}

	public String getGdpr() {
		return gdpr;
	}

	public void setGdpr(String gdpr) {
		this.gdpr = gdpr;
	}
	
	//empty constructor (overloaded)
	public Customer () {}
	
	
	//constructor just: name, lastname
	public Customer(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}

}
