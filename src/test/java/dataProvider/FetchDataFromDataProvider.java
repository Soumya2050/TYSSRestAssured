package dataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FetchDataFromDataProvider {
	
	@Test(dataProvider = "data")
	public void fetchDataFromDataProvider(String usName,String pasw) {
		
		System.out.println(usName+">>>>>>>>>>>>>>>>>>"+pasw);
	}
	
	
	@DataProvider
	public Object[][] data() throws EncryptedDocumentException, IOException{
		
		FileInputStream fis = new FileInputStream("./src/test/resources/ProjectRMG.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet3");
		
		int lastRow = sh.getLastRowNum()+1;
		int lsatCell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][lsatCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lsatCell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}

}
