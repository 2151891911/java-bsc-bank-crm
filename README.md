# Bank Console Application

<br>
<br>

## Intent

The main purpose is to demonstrate a sample project of:
- Basic java code
- Basic Object Oriented Programming
- Basic Use of Interface
- Connection with mySQL
- Basic querying with mySQL - JDBC
- Design Patters
	- Observer
	- Singleton
	- Factory
	- Abstract factory
	- Strategy
	- Facade
	- Composite
- Show basic Exceptions & handling
- Basic Use of Enums


## Database Tables 

table: Customer
	private String name;
	private String lastName;
	private String wealthysegment;
	private String gdpr;
	
table: Account
	private int account;
	private int balance;
	(many accounts to one customer)

table: Card
    private int accounts;
	private int cardNumber;
	(many cards to one customer)

<br>

## mySQL Tables Creation - DB name crm_bank

**CUSTOMER TABLE**
```SQL
CREATE TABLE crm_bank.customer (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  lastname VARCHAR(45) NOT NULL,
  wealthysegment VARCHAR(3) NOT NULL DEFAULT 'no',
  gdpr VARCHAR(3) NOT NULL DEFAULT 'no',
  PRIMARY KEY (id));
```

**CARD TABLE**
In the next tables a foreign key option is checked. This means that we create a foreign key that connects the customer id to the card number. Should be filled (not null). Cascade is selected to update automatically the keys on both (parent and child) tables.
```SQL
CREATE TABLE crm_bank.card (
  cardnumber INT NOT NULL,
  expdate DATE NOT NULL,
  pin INT NOT NULL,
  customer_id INT NOT NULL,
  PRIMARY KEY (cardnumber),
  INDEX card_customer_id_idx (customer_id ASC) VISIBLE,
  CONSTRAINT card_customer_id
    FOREIGN KEY (customer_id)
    REFERENCES crm_bank.customer (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
```

**ACCOUNT TABLE**
```SQL
CREATE TABLE crm_bank.account (
  accountnumber VARCHAR(13) NOT NULL,
  balance INT NOT NULL,
  customer_id INT NOT NULL,
  PRIMARY KEY (accountnumber),
  INDEX account_customer_id_idx (customer_id ASC) VISIBLE,
  CONSTRAINT account_customer_id
    FOREIGN KEY (customer_id)
    REFERENCES crm_bank.customer (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
```

Bolis Konstantinos 06/11/2020

<br>