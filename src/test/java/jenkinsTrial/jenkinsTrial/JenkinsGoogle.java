package jenkinsTrial.jenkinsTrial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JenkinsGoogle {

	WebDriver driver;

	WebDriverWait wait;

	@BeforeMethod
	void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Owner\\eclipse-workspace\\jenkinsTrial\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://www.google.co.in/");

	}

	@Test(priority = 1)
	void googleTitle() {
		
		System.out.println("This is a comment");
		
		System.out.println("Trial");

		String titleOfPage = driver.getTitle();

		Assert.assertEquals(titleOfPage, "Google");

	}

	@Test(priority = 2)
	void searchInput() {
		
		System.out.println("This is a comment");

		WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search']"));

		WebElement searchButton = driver.findElement(
				By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@type='submit' and @value='Google Search']"));

		searchBox.sendKeys("Canada");

		searchButton.click();

	}

	@AfterMethod
	void tearDown() {

		driver.quit();

	}

}
