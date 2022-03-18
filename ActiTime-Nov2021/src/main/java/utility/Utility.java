package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	
	public static void screenshot(WebDriver driver,String testID) throws IOException
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(" dd-MM-yyyy hh-mm-ss");
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Kshitij Gaikwad\\OneDrive\\Desktop\\Drive"+"Test_"+ testID +sdf.format(d)+".jpg");
		FileHandler.copy(source, dest);
		
		
	}
public static String getDataFromExcelSheet(String sheet,int row,int cell) throws IOException {
		
		String path = "C:\\Users\\Kshitij Gaikwad\\OneDrive\\Desktop\\excel.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
		String data = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
		
		return data;
}
}
