package com.RMGyantra.Utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * used to connect to Db & perform DB specific Operations
 * 
 * @author srjen
 *
 */
public class DataBaseUtility {

	Driver driver;
	public static Connection connection;
	ResultSet result;
	FileUtility fLib = new FileUtility();
	String URL;
	String USERNAME;
	String PASSWORD;

	public DataBaseUtility() {

		try {
			URL = Iconstant.dbURL;
			USERNAME = Iconstant.dbUserName;
			PASSWORD = Iconstant.dbPassword;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method will perform the mysql database connection
	 * 
	 * @throws SQLException
	 */
	public void connectDB() throws SQLException {
		try {
			driver = new Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will close the mysql database
	 * 
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		try {
			connection.close();
		} catch (Exception e) {
		}

	}

	/**
	 * This method will execute the querry
	 * 
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet execyteQuery(String query) throws Throwable {
		result = connection.createStatement().executeQuery(query);
		return result;
	}

	/**
	 * This method will execute the querry
	 * 
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public int executeUpdate(String query) throws Throwable {

		int result = connection.createStatement().executeUpdate(query);

		return result;

	}

	/**
	 * This method will execute querry based on querry and it will verify the data.
	 * 
	 * @param querry
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public boolean executeQuerryAndVerify(String querry, int cloumnIndex, String expectedData) throws Throwable {
		boolean flag = false;
		result = connection.createStatement().executeQuery(querry);
		while (result.next()) {
			if (result.getString(cloumnIndex).equalsIgnoreCase(expectedData)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println(expectedData + "==>Data is verified in the data base table");
			return flag;
		} else {
			System.out.println(expectedData + "==>data is not verified in the database");
			return flag;
		}

	}

}
