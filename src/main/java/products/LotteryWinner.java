package products;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/* A Singletons often control access to resources, such as database connections or sockets. 
 * In our example, we will assume an automatic lottery participation, where some lucky customer
 * gets to win 100 euro. Thus, all customers use the same and single action of lottery.
 */
public class LotteryWinner {
	

    // static variable single_instance of type Singleton 
    private static LotteryWinner winner = null; 
    public String msg;
    // variable of type String 
    
	
	// a method that finds the winner
	public int getRandomWinner(){
		System.out.println("Initalizing Process for finding the winner Customer");
		
		// count all the records of a table - to know the population of customers
		String sql = "SELECT COUNT(*) AS POPULATION FROM CUSTOMER;";
		int population=0;
		
		//connection with DB - JDBC
		try (Connection con = utils.ConnectionFactory.getConnection(); Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery(sql);
			//table returns one row
			population = rs.getInt(1);
		} catch (SQLException ex) {
			System.out.println("Attempt to retrieve balance failed");
		}
						
		//algorithm
		Random ran = new Random();		
		int winnerCustomerId = 	ran.nextInt(population);
		return winnerCustomerId;
	}
	
	//private constructor
	private LotteryWinner() {
		msg = "You have won 100 euros at Bank's lottery";
	}
	
	/* this static method creates an instance of
	the singleton class */
	public static LotteryWinner getInstance(){
		
		if (winner == null) {
            winner = new LotteryWinner(); 
		}
	return winner;
	}

}


	
