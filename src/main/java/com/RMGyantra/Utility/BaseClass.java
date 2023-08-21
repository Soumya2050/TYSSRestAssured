package com.RMGyantra.Utility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	protected static WebDriver sdriver;
	protected WebDriver driver = null;
	protected DataBaseUtility dLib = new DataBaseUtility();
	protected ExcelUtility eLib = new ExcelUtility();
	protected FileUtility fLib = new FileUtility();
	protected JavaUtility jLib = new JavaUtility();
	protected JsonUtility json = new JsonUtility();

	protected String path;/* This is for properties */
	protected String ePath;/* This is for testscript data */
	protected String excelPath;/* This is for excel */
	protected String jSon;

	/**
	 * This method is used for connect to the data base
	 * 
	 * @throws SQLException
	 */

	@BeforeSuite
	public void connectToDataBase() throws SQLException {
		dLib.connectDB();
		System.out.println("Data Base is connected ");
	}

	@AfterSuite
	public void closeDataBase() throws SQLException {
		dLib.closeDB();
		System.out.println("Data Base is successfully closed");
	}

}
