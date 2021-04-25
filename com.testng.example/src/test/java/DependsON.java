import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tools.ant.taskdefs.optional.depend.ClassFileUtils;
import org.apache.tools.ant.util.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.google.j2objc.annotations.J2ObjCIncompatible;

import io.restassured.path.json.JsonPath;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


@Test
public class DependsON {
	WebDriver driver = null;

	/*
	 * @Test public void test() throws InterruptedException {
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\bhara\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 * driver=new ChromeDriver(); driver.get("https://www.google.com");
	 * 
	 * boolean b1=driver.findElement(By.className("gLFyf")).isDisplayed();
	 * System.out.println(b1+"Class Name"); boolean
	 * b2=driver.findElement(By.linkText("Gmail")).isDisplayed();
	 * System.out.println(b2+"Link Text"); boolean
	 * b3=driver.findElement(By.partialLinkText("mail")).isDisplayed();
	 * System.out.println(b3+"Partial Link Text"); boolean
	 * b4=driver.findElement(By.cssSelector("input[title='Search']")).isDisplayed();
	 * System.out.println(b4+"Css Selector"); boolean
	 * b5=driver.findElement(By.xpath("//input[@title='Search']")).isEnabled();
	 * System.out.println(b5+"Xpath"); int i
	 * =driver.findElements(By.tagName("input")).size();
	 * System.out.println(i+"Count");
	 * 
	 * 
	 * Boolean b
	 * =driver.findElement(By.xpath("//input[@title='Search']")).isEnabled();
	 * System.out.println(b);
	 * 
	 * driver.findElement(By.xpath("//input[@title='Search']")).
	 * sendKeys("Automation Testing"); Thread.sleep(5000); String v=
	 * driver.findElement(By.xpath("//input[@title='Search']")).getAttribute("value"
	 * );
	 * 
	 * String v1=
	 * driver.findElement(By.xpath("//input[@title='Search']")).getText();
	 * System.out.println(v+"== Text Box value");//driver.findElement(By.
	 * cssSelector("input[value='Google Search']")).click();
	 * 
	 * System.out.println(v1+" GetText Value"); Assert.assertTrue(b,
	 * "Text Boxis not displayed");
	 * 
	 * 
	 * 
	 * driver.close(); }
	 */

	/*
	 * public JSONObject jsonTest() throws FileNotFoundException, IOException,
	 * ParseException { JSONParser jsonPaser = new JSONParser(); Object obj = null;
	 * JSONObject jsonObject = null; obj = jsonPaser.parse(new
	 * FileReader("C:\\Users\\bhara\\Downloads\\myfile.json")); jsonObject =
	 * (JSONObject) obj; return jsonObject;
	 * 
	 * }
	 * 
	 * public JsonPath jsonTest() throws FileNotFoundException, IOException,
	 * ParseException { JsonPath jsonPath=null; jsonPath = new
	 * JsonPath(Files.newBufferedReader(Paths.get(
	 * "C:\\Users\\bhara\\Downloads\\myfile.json"))); return jsonPath;
	 * 
	 * }
	 * 
	 * @Test public void readDataFromJson() throws FileNotFoundException,
	 * IOException, ParseException { JsonPath path =jsonTest();
	 * System.out.println(path.getString("fruit"));
	 * System.out.println(path.getString("size")); } ul[jsname='k77Iif'] li a[href]
	 */

	@Test
	public void screenshotExample() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bhara\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com");

		driver.findElement(By.cssSelector("a[aria-label='Google apps']")).click();
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[role='presentation']")));
		
		List<WebElement> e= driver.findElements(By.xpath("//ul[@jsname='k77Iif']/li/a"));
		System.out.println(e.size());
		
		driver.findElements(By.xpath("//ul[@jsname='k77Iif']/li/a")).get(1).click();
		
		driver.switchTo().defaultContent();
		
		

		driver.close();
	}
}

/*	@Test
	public void readExcel() throws IOException {		
		String otherpath = "C:\\Users\\bhara\\Desktop\\Selenium.xlsx";
		String fileName = "Selenium.xlsx";
		//InputStream file = new InputStream(filePath);
		//File file=new File(otherpath);
		FileInputStream input = new FileInputStream(new File(otherpath));
			
		Workbook book = null;
		String fileExtension = fileName.substring(fileName.indexOf("."));

		if (fileExtension.equals(".xlsx")) {
			book= new XSSFWorkbook(input);
		}
		
		  Sheet mysheetName = book.getSheetAt(0);
		    //Find number of rows in excel file
		    int rowCount = mysheetName.getLastRowNum()-mysheetName.getFirstRowNum();
		    //Create a loop over all the rows of excel file to read it
		    for (int i = 0; i < rowCount+1; i++) {
		        Row row = mysheetName.getRow(i);
		        //Create a loop to print cell values in a row
		        for (int j = 0; j < row.getLastCellNum(); j++) {
		            //Print Excel data in console
		            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
		        }

		        System.out.println();
		    } 

		    }  



		   
	}

	/*
	 * @Test public void alert_handling() {
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\bhara\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 * driver=new ChromeDriver(); driver.navigate().to(
	 * "https://www.selenium.dev/selenium/docs/api/java/index.html?deprecated-list.html"
	 * );
	 * 
	 * 
	 * List<WebElement> elements= driver.findElements(By.tagName("iframe"));
	 * System.out.println(elements.size()); driver .switchTo() .frame (driver
	 * .findElement(By.cssSelector("iframe[name*='packageListFrame']"))); elements=
	 * driver.findElements(By.tagName("iframe"));
	 * System.out.println(elements.size()); driver.switchTo().defaultContent();
	 * elements= driver.findElements(By.tagName("iframe"));
	 * System.out.println(elements.size());
	 * 
	 * driver.close(); }
	 * 
	 * @Test public void clickLink() { System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\bhara\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 * driver=new ChromeDriver();
	 * driver.navigate().to("https://testandquiz.com/selenium/testing.html");
	 * WebElement e= driver.findElement(By.linkText("This is a link"));
	 * 
	 * WebDriverWait wait =new WebDriverWait(driver, 10); wait .until
	 * (ExpectedConditions.visibilityOfAllElements (e));
	 * 
	 * 
	 * driver.close(); }
	 * 
	 * 
	 * 
	 * @Test public void manageCookies() throws InterruptedException {
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\bhara\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 * driver=new ChromeDriver(); driver.navigate().to("https://www.google.com");
	 * 
	 * Set<Cookie> s=driver.manage().getCookies(); System.out.println(s);
	 * 
	 * driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 * driver.manage().deleteAllCookies(); s=driver.manage().getCookies();
	 * System.out.println(s);
	 * 
	 * 
	 * }
	 */
	/*
	 * public void facebookLogin() throws InterruptedException {
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\bhara\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 * driver=new ChromeDriver(); driver.navigate().to("https://www.facebook.com/");
	 * 
	 * WebElement createButton = driver.findElement(By.cssSelector(
	 * "a[data-testid='open-registration-form-button']")); createButton.click();
	 * 
	 * WebElement firstName = driver
	 * .findElement(By.cssSelector("input[name='firstname']"));
	 * 
	 * boolean b = firstName.isDisplayed(); System.out.println(b);
	 * 
	 * Thread.sleep(5000); driver.navigate().to("https://www.google.com/");
	 * 
	 * driver.navigate().back();
	 * 
	 * b = firstName.isDisplayed(); System.out.println(b);
	 * 
	 * Thread.sleep(5000); driver.close(); }
	 */

	/*
	 * public void openBrowser() throws InterruptedException {
	 * 
	 * driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(
	 * "Automation"); Thread.sleep(5000);
	 * driver.findElement(By.cssSelector("input[value='Google Search']")).click();
	 * Thread.sleep(5000); driver.close(); }
	 */


