import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NavigationExamples {
	
	WebDriver driver =null;

	public void facebookLogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhara\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		
		WebElement createButton = driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));
		createButton.click();
		
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
		
		
		
		/*Thread.sleep(5000);
		
		Select dayDropDown=new Select(driver.findElement(By.id("day")));
		dayDropDown.selectByIndex(1);
		
		
		Select monthDropDown=new Select(driver.findElement(By.id("month")));
		monthDropDown.selectByValue("1");
		
		Select yearDropDown=new Select(driver.findElement(By.id("year")));
		yearDropDown.selectByVisibleText("1987");
		
		Thread.sleep(10000);
		
		int s=driver.findElements(By.cssSelector("select#year option")).size();
		System.out.println(s+"  == size of the above List ");
		
		driver.findElements(By.cssSelector("input[name='sex']")).get(0).click();
		
		Thread.sleep(10000);*/
		
		driver.close();
	}
}
