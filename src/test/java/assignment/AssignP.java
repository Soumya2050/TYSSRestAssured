package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.RMGyantra.Utility.JavaUtility;
import com.mysql.cj.jdbc.Driver;

public class AssignP {

	@Test
	public void con() throws SQLException {
		Connection con = null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement st = con.createStatement();
			String query = "CREATE TABLE soumya (id INTEGER,name char(255), Primary Key(id))";
			try {
				boolean res = st.execute(query);
				System.out.println(res);
				if (!res) {
					System.out.println("Table Already exist"+10/0);
				} else {
					AssignP.execute(st);
				}
			} catch (Exception e) {
				AssignP.execute(st);
			}
		} finally {
			con.close();
		}
	}

	public static void execute(Statement st) throws SQLException {
		ResultSet rs = st.executeQuery("select * from soumya");
		int rsmd = rs.getMetaData().getColumnCount();
		System.out.println("no" + rsmd);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		String aname = sc.next();
		String q1 = "select name from soumya";
		ResultSet res1 = st.executeQuery(q1);
		int res2;
		JavaUtility a = new JavaUtility();
		int id = a.getRandomNum();
		boolean flag = false;
		while (res1.next()) {
			if (res1.getString(1).equals(aname)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("The data is allerdy present in the data base:- ");
		} else {
			String q2 = "insert into soumya values(" + id + ",'" + aname + "')";
			id++;
			res2 = st.executeUpdate(q2);
			if (res2 == 1) {
				System.out.println("Successfully added the details ");
			}
		}
	}

}
