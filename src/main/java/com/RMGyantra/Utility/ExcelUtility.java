package com.RMGyantra.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This is used to workbook related operation like read,write,getcount etc
 * 
 * @author srjen
 *
 */
public class ExcelUtility {
	/**
	 * This method is used to Read the data from excel based on the row and column
	 * index
	 * 
	 * @param filePath
	 * @param sheetName
	 * @param rowNum
	 * @param cellName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String filePath, String sheetName, int rowNum, int cellName)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(cellName).toString();
		wb.close();
		return data;
	}

	/**
	 * This method is used to read the data based on the testId and required Column
	 * name
	 * 
	 * @param filePath
	 * @param sheetName
	 * @param testId
	 * @param columnHeader
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcelBasedTestId(String path,String sheetName, String testid,String columnHeader) throws Throwable, IOException {
		FileInputStream fin= new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		int testrowno = 0;
		String acttestId = "";
		String data = "";
		for (int i = 0; i <= rowCount; i++) {
			try {
				 acttestId = sheet.getRow(i).getCell(0).toString();} catch (Exception e) {}

			if (acttestId.equalsIgnoreCase(testid)) {
				break;
			}
			testrowno++;
		}
		int cellCount=sheet.getRow(testrowno-1).getLastCellNum();
		int testcolno=0;
		for (int i = 0; i <cellCount ; i++) {
			String actcolHeader = sheet.getRow(testrowno-1).getCell(i).toString();
			if (actcolHeader.equalsIgnoreCase(columnHeader)) {
				break;
			}
			testcolno++;
		}
		try { data = sheet.getRow(testrowno).getCell(testcolno).toString();} catch (Exception e) {}
		
		wb.close();
		return data;
			
	}
	/**
	 * This method is used to get the maximun used row count in required sheet
	 * 
	 * @param filePath
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String filePath, String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		return rowCount;
	}
	/**
	 * This method is used to set the data into the excel
	 * @param filePath
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws IOException
	 */
	public void setDataExcel(String filePath, String sheetName, int rowNum, int cellNum, String data)
			throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cel = row.createCell(cellNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		wb.close();
	}

}
