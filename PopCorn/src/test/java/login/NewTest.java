package login;

import org.testng.annotations.Test;


import utility.Constant;
import utility.ExcelUtils;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;


public class NewTest {
	
	WebDriver driver=null;
	WebElement element;
	
	 @BeforeClass
	  public void beforeClass() {
		  
		  	  
		  System.setProperty("webdriver.chrome.driver","D://PopCorn/driver/chromedriver.exe");
	      driver = new ChromeDriver(); 
		  
	      
	  }
	
  @Test
  public void f() throws Exception {
	  
	  driver.get("http://qa.cms.popcorn.lk/login");
	  /*ExcelUtils.setExcelFile(Constant.Path_TestData, Constant.File_TestData);
	  driver.get(ExcelUtils.getCellData(3, 1));*/
	  driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(ExcelUtils.getCellData(2, 1));
	  driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(ExcelUtils.getCellData(2, 2));
	  driver.findElement(By.xpath(".//*[@id='login_form']/div[4]/div[2]/button")).click();
	  
	  
	  
	  //String message = driver.findElement(By.xpath("//*[@class='alert alert-danger'])"))
	  
	  
	  
	  WebDriverWait wait = new WebDriverWait(driver, 50);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='login_form']/div[1]/div"))));
	  
	  
	  String message=driver.findElement(By.xpath("//*[@id='login_form']/div[1]/div")).getText();
	  
	  String actual = "The username field is required.\n" + 
	  		"The password field is required." ;
	  
	  assertEquals(message,actual);
			  
	  
	 //driver.findElement("//*[@class='alert alert-danger']")
	  
	  //message=driver.
			  
	  //String Actual = FatesObjects.Fates.updated_msg(driver).getText();
		//String Expect = "Success!  \n" + 
				//"Fate Successfully Added.";
		//assertEquals(Actual, Expect);
	  
	  
  }
 

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
