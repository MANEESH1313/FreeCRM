
//------- Start----------
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class testweb {
	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "//S://chromedriver_win32//chromedriver.exe");
		String filePath = "S:\\eclipse-workspace\\FreeCRMTest\\test-output\\qlikfile.xlsx";
		WebDriver wb = new ChromeDriver();

		wb.manage().window().maximize();
		wb.manage().deleteAllCookies();
		wb.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		wb.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		wb.navigate().to("https://demos.qlik.com/qliksense/InsuranceClaims");

		System.out.println(wb.getTitle() + " - WebPage has been launched");

//Thread.sleep(30000); 
//wb.findElement(By.xpath("//*[contains(text(),'Launch Demo')]")).click();    
		wb.findElement(By.xpath("/html/body/div/app/div[3]/detail/div/div[1]/div/div[1]/div[2]/a")).click();

//Thread.sleep(30000);  
		wb.findElement(By.xpath("//*[@id=\"qv-appview-container\"]/div/div/div/div/ul/li[1]/div/div/div/div[1]/div"))
				.click();

		Actions actions = new Actions(wb);
//Thread.sleep(30000); 
		WebElement elementLocator = wb.findElement(By.xpath("//div[contains(text(),'Claims by claim type')]"));
		actions.contextClick(elementLocator).perform();

//Thread.sleep(30000);
		wb.findElement(By.xpath("//span[contains(text(),'View data')]")).click();
		List<WebElement> irows = wb.findElements(By.xpath("//*[@id=\"grid\"]/*//table/tbody/tr"));
//List<WebElement> irows =   wb.findElements(By.xpath("//*[@id=\"grid\"]/div[12]/div[2]/div/div[1]/div/article/div[1]/div/div/div/div[2]/div[1]/div/table//tr"));     
		int iRowsCount = irows.size();
		List<WebElement> icols = wb.findElements(By.xpath("//*[@id=\"grid\"]/*//table//tr[1]/td"));
		int iColsCount = icols.size();

		System.out.println("Selected web table has " + iRowsCount + " Rows and " + iColsCount + " Columns");
		System.out.println();

		FileOutputStream fos = new FileOutputStream(filePath);

		XSSFWorkbook wkb = new XSSFWorkbook();       
		XSSFSheet sheet1 = wkb.createSheet("DataStorage"); 

		for (int i=1;i<=iRowsCount;i++)      
		{      XSSFRow excelRow = sheet1.createRow(i);     
		for (int j=1; j<=iColsCount;j++)                    
		{           
		if (i==1)       
		{           
		WebElement val= wb.findElement(By.xpath("//*[@id=\"grid\"]/*//table/tbody/tr["+i+"]/td["+j+"]"));             
		String  a = val.getText();            
		System.out.print(a);                        

		//XSSFRow excelRow = sheet1.createRow(i);             
		XSSFCell excelCell = excelRow.createCell(j);                  
		excelCell.setCellType(XSSFCell.CELL_TYPE_STRING);                 
		excelCell.setCellValue(a);  

		//wkb.write(fos);       
		}       
		else        
		{           
		WebElement val= wb.findElement(By.xpath("//*[@id=\"grid\"]/*//table//tr["+i+"]/td["+j+"]"));             
		String a = val.getText();                    
		System.out.print(a);                            

		//XSSFRow excelRow = sheet1.createRow(i);             
		XSSFCell excelCell = excelRow.createCell(j);                      
		excelCell.setCellType(XSSFCell.CELL_TYPE_STRING);                   
		excelCell.setCellValue(a);   

		//wkb.write(fos);       
		}       
		}               
		System.out.println();     
		}     
		fos.flush();     
		wkb.write(fos);     
		fos.close();     

	
	}

//------- End----------

}
