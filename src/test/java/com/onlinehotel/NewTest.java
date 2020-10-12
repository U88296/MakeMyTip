package com.onlinehotel;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class NewTest {
	
	static WebDriver driver;
	

	  @BeforeClass
	  public void init() {
		  System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Chromedriver86\\Chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://www.makemytrip.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }
	  
  @Test
      public void booking() throws InterruptedException {
	  
	  
	  driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]/i")).click();
	  Thread.sleep(2000);
	  
	  //login
	  WebElement Cont =driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[6]"));
	  Cont.click();
      WebElement username=driver.findElement(By.xpath("//*[@id=\"username\"]"));
	  username.sendKeys("athianilk@gmail.com");
	  WebElement loginSubmit=driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[2]/button"));
	  loginSubmit.click();
	  Thread.sleep(2000);
	  WebElement password=driver.findElement(By.xpath("//*[@id=\"password\"]"));
	  password.sendKeys("Rishita@28");
	  WebElement login=driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[2]/button"));
	  login.submit();
	  
	  //Hotel booking
	  
	  driver.findElement(By.xpath("//li[@class='   menu_Hotels ']/a")).click();
	  driver.findElement(By.id("city")).click();
	  WebElement city=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div/div/div/input"));
	  city.sendKeys("Delhi");
	  city.sendKeys(Keys.ARROW_DOWN);
	  city.sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  WebElement checkin=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[5]/div[6]"));
	  checkin.click();
	  Thread.sleep(2000);
	  WebElement checkout=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[3]"));
	  checkout.click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("guest")).click();
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div/div[4]/div[1]/div[1]/div/div[2]/div/ul[1]/li[2]")).click();
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div/div[4]/div[1]/div[2]/button[2]")).click();
	  driver.findElement(By.id("hsw_search_button")).click();
	  Thread.sleep(2000);
	  
	  //Filtering based on price,locality,Star rating
	  
	  Actions actions = new Actions(driver);
	  WebElement slider=driver.findElement(By.xpath("//*[@id=\"hlistpg_fr_price_per_night\"]/div[2]/div[2]/div/span[1]/div"));
	  actions.moveToElement(slider).click().dragAndDropBy(slider, +50,0 ).build().perform();
	  Thread.sleep(2000);
		 
	  Actions loc=new Actions(driver);
	  WebElement locality=driver.findElement(By.xpath("//*[@id=\"hlistpg_fr_locality\"]/div/div[1]/ul/li[2]/span/label"));
	  loc.moveToElement(locality);
	  loc.click().perform();
	  Thread.sleep(2000);
		 
	  Actions starselect=new Actions(driver);
	  WebElement star=driver.findElement(By.xpath("//*[@id=\"hlistpg_fr_star_category\"]/ul/li[3]/span[1]/label"));
	  starselect.moveToElement(star);
	  starselect.click().perform();
	  Thread.sleep(2000);
	  
	  //selecting hotel
	  
	  driver.findElement(By.id("htl_id_seo_201912120849477248")).click();
		 String parent = driver.getWindowHandle();
		   Set<String> ids = driver.getWindowHandles();
			Iterator<String> it = ids.iterator();
			while (it.hasNext()){
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
	  Thread.sleep(2000);
	  
	  //proceed to book the selected hotel
	  
	  driver.findElement(By.id("detpg_headerright_book_now")).click();
	  Thread.sleep(2000);
	  
	  //Traveller information
	  
	  WebElement title=driver.findElement(By.id("title"));
	  Select dropdwn=new Select(title);
	  dropdwn.selectByVisibleText("Ms"); 
	  driver.findElement(By.id("fName")).sendKeys("Athira");
	  driver.findElement(By.id("lName")).sendKeys("Anilkumar");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[6]/span")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/a")).click();
	  Thread.sleep(2000);
	  
	  //Payment details
	  
	  driver.findElement(By.id("PAYMENT_cardNumber")).sendKeys("5874200015756000");
	  Thread.sleep(2000);
	  driver.findElement(By.id("PAYMENT_nameOnCard")).sendKeys("Athira Anil");
	  WebElement expiry=driver.findElement(By.id("PAYMENT_expiryMonth"));
	  Select s=new Select(expiry);
	  s.selectByVisibleText("06");
	  Thread.sleep(1000);
	  WebElement expiryyr=driver.findElement(By.id("PAYMENT_expiryYear"));
	  Select eyr=new Select(expiryyr);
	  eyr.selectByVisibleText("2023");
	  Thread.sleep(1000);
	  driver.findElement(By.id("PAYMENT_cvv")).sendKeys("123");
	  driver.findElement(By.xpath("//*[@id=\"widgetPayBtnDP\"]")).click();
	  
		
		
  }
  
  
  @AfterMethod
  
   /*public void resultCapture() {
	  File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  String imagepath = System.getProperty("user.dir")+"/screenshot/"+"PaymentErrorImage.png";
	  File destFile = new File(imagepath);
	  FileUtils.copyFile(srcFile,destFile);
	  
	  
  }
  */
  

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
