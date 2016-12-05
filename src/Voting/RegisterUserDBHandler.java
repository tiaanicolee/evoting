package Voting;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Properties;


/**
 * A Database Handler that interfaces with the database containing
 * the Registered users that can vote.
 */
public class RegisterUserDBHandler {
	/**
	 * The method looks in the database containing the registered users, and it 
	 * returns whether the user is registered or not.
	 * @param username
	 * @param password
	 * @return true if registered, false otherwise
	 */
	public User findUser(String username, String password, String role)
	{
		Connection conn = null;
		User user = null;
		//Statement stmt;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `registered_users` WHERE `username` = ? AND `password` = ? AND `role` = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3,  role);
			ResultSet rs = stmt.executeQuery();
			System.out.print("Names for query username are :" );
			while (rs.next()) {
				  String name = rs.getString("username");
				  String pass = rs.getString("password");
				  String r = rs.getString("role");
				  System.out.println(name+"  " + pass + "  " + r + "  ");
				  user = new User(name, pass, rs.getInt("id"));
			}
			System.out.println();
			
			
			
	        
	        
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return null;
		}
		
		return user;
		
	      
	}
	
	/*
	 * Method to update the vote count in the flat file.
	 */
	public int getVoteCount(User user)
	{
		Connection conn = null;
		int voteCount = 10;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `registered_users` WHERE `username` = ? AND `password` = ? AND `role` = ?");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3,  "V");
			ResultSet rs = stmt.executeQuery();
			System.out.print("Names for query username are :" );
			while (rs.next()) {
				  String name = rs.getString("username");
				  String pass = rs.getString("password");
				  String r = rs.getString("role");
				  System.out.print(name+"  " + pass + "  " + r + "  ");
				  
				  voteCount = rs.getInt("NUMVOTES");
			}
			System.out.println();
	        
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
		}
		return voteCount;
	}
	
	public void setVoteCount(int id) 
	{
		Connection conn = null;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
			String query = "update registered_users set NUMVOTES = 1 WHERE id = " + "'"+ id + "'";
		    PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeUpdate();
	        
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
		}

	}
	
	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "test";
	
	/** The name of the table we are testing with */
	private final String tableName = "REGISTERED_USERS";
	
	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);

		return conn;
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); // This will throw a SQLException if it fails
	        return true;
	    } finally {

	    	// This will run whether we throw an exception or not
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	/**
	 * Connect to MySQL and do some stuff.
	 */
	public void createTable() {

		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}

		// Create a table
		try {
		    String createString =
			        "CREATE TABLE " + this.tableName + " ( " +
			        "ID INTEGER NOT NULL, " +
			        "USERNAME varchar(40) NOT NULL, " +
			        "PASSWORD varchar(40) NOT NULL, " +
			        "ROLE varchar(10) NOT NULL, " +
			        "NUMVOTES INTEGER NOT NULL, " +
			        "PRIMARY KEY (ID))";
			this.executeUpdate(conn, createString);
			System.out.println("Created a table");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		}
		
		
		try {
			String sql = "INSERT INTO " + this.tableName + " VALUES (000000, 'Tia Curry', 'pass', 'EO', 1)";
			this.executeUpdate(conn, sql);
			sql = "INSERT INTO " + this.tableName + " VALUES (8888888, 'Joshua Clark', 'pass1', 'EO', 1)";
			this.executeUpdate(conn, sql);
			sql = "INSERT INTO " + this.tableName + " VALUES (000001, 'Tia Curry', 'pass', 'V', 0)";
			this.executeUpdate(conn, sql);
			sql = "INSERT INTO " + this.tableName + " VALUES (8888889, 'Joshua Clark', 'pass1', 'V', 0)";
			this.executeUpdate(conn, sql);
			
		}
		catch(SQLException e) {
			System.out.println("ERROR: Could not insert into the table");
			e.printStackTrace();
			return;
		}
		
		//print voting table
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select *from " + this.tableName );
			ResultSetMetaData rsmd = rs.getMetaData();
	
			int columnsNumber = rsmd.getColumnCount();                    
	
			// Iterate through the data in the result set and display it. 
			System.out.println("ID\t\tUSERNAME\t\tPASSWORD\tROLE\tNUMBER OF VOTES");
			while (rs.next()) {
			//Print one row          
				for(int i = 1 ; i <= columnsNumber; i++){
		
				      System.out.print(rs.getString(i) + "\t\t"); //Print one element of a row
				}
	
				      System.out.println();//Move to the next line to print the next row.           
			}
		}
			catch (SQLException e) {
			System.out.println("ERROR: Could not print the voting table");
			e.printStackTrace();
			return;
		}
		
		
		
	}
	
	public void dropTable()
	{
		
		//drop voting table
		try {
			Connection conn = this.getConnection();
			System.out.println("Connected to database");
		    String dropString = "DROP TABLE " + this.tableName;
			this.executeUpdate(conn, dropString);
			System.out.println("Dropped the voting table");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not drop the table");
			e.printStackTrace();
		}
	}
	
		
}
