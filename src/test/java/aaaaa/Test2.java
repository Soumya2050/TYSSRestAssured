package aaaaa;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.RMGyantra.Utility.JavaUtility;

public class Test2 {
	
	
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 2);
		Date d = cal.getTime();
		String date = sdf.format(d);
		System.out.println(date);
		
		
		SimpleDateFormat sd = new SimpleDateFormat("MMMM yyyy");
		Date dt = new Date();
		String month = sd.format(dt);
		System.err.println(month);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DATE, 4);
		Date d1 = cal1.getTime();
		String date1 = sdf1.format(d1);
		System.out.println(date1);
		
	}
}
