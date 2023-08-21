package dataProvider;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RMGyantra.Utility.JavaUtility;

import Pojo.ReqresPOJO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingDataProvider2 {

	@DataProvider
	public Object[][] data() throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/ProjectRMG.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		int lastRowNum = sh.getLastRowNum() + 1;
		int lastCellNum = sh.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRowNum][lastCellNum];

		for (int i = 0; i < lastRowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				obj[i][j] = sh.getRow(i).getCell(j).toString();
			}
		}
		return obj;
	}

	@Test(dataProvider = "data")
	public void getData(String name, String job) {

		JavaUtility jLib = new JavaUtility();
		baseURI="https://reqres.in";
		
		ReqresPOJO po = new ReqresPOJO(name + "-" + jLib.getRandomNum() + "", job);
		
		given().body(po).contentType(ContentType.JSON)
		
		.when().post("/api/users")
		
		.then().assertThat().log().all();
	}

}
