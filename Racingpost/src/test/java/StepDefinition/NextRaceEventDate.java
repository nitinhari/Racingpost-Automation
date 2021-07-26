package StepDefinition;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import cucumber.api.java.en.Then;

public class NextRaceEventDate {
	
	WebDriver driver;
	
	@Given("^I am on racing site$")
	public void i_am_on_racing_site() throws InterruptedException {
		
	    
	    WebDriverManager.chromedriver().setup();
	    ChromeOptions chromeoptions = new ChromeOptions();
	    
	    chromeoptions.addArguments("disable-popup-blocking");
	    chromeoptions.addArguments("start-maximized");
	    chromeoptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	    chromeoptions.setExperimentalOption("useAutomationExtension", false);
	    
	    
		driver = new ChromeDriver(chromeoptions);
		
		
		driver.get("https://www.racingpost.com/racecards/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("second Passed 1");
		String expUrl = "https://www.racingpost.com/racecards/";
		System.out.println(expUrl);
		String actUrl = driver.getCurrentUrl();
		System.out.println(actUrl);
		boolean currUrl=false;
		if(actUrl.equals(expUrl))
		{ 
			System.out.println("test case paased");
			currUrl = true;
		}
		else
		{ 
			System.out.println("test case failed");
			currUrl = false;
		}
	    
		assertEquals(true, currUrl);
	}

	@When("^I click Big Race Entries Header$")
	public void i_click_Big_Race_Entries_Header() throws Throwable {
	    
		
		System.out.println("Passed 2");
	    String CurActUrl = driver.getCurrentUrl();
	    System.out.println(CurActUrl);
	    driver.manage().window().maximize();
	    System.out.println(driver.getTitle());
	   
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    System.out.println(driver.getTitle());
		
	    
	/*    driver.findElement(By.className("ui-advertising__skinsBodyWrp"));
		System.out.println(driver.findElement(By.className("ui-advertising__skinsBodyWrp")));
		System.out.println(driver.findElement(By.className("ab-close-button")));
		driver.findElement(By.className("ab-close-button")).click(); */
		System.out.println("closed pop up 1");
		
		driver.findElement(By.xpath("//a[@href='/racecards/big-race-entries']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	/*	driver.findElement(By.className("ui-advertising__skinsBodyWrp"));
		System.out.println(driver.findElement(By.className("ui-advertising__skinsBodyWrp")));
		System.out.println(driver.findElement(By.className("ab-close-button")));
		driver.findElement(By.className("ab-close-button")).click();   */
		System.out.println("closed pop up 2");
		String expPage2Url = "https://www.racingpost.com/racecards/big-race-entries";
		System.out.println(expPage2Url);
		String actPage2Url = driver.getCurrentUrl();
		System.out.println(actPage2Url);
		boolean currPage2Url=false;
		if(actPage2Url.equals(expPage2Url))
		{ 
			System.out.println("test case paased");
			currPage2Url = true;
		}
		else
		{ 
			System.out.println("test case failed");
			currPage2Url = false;
		}
	    
		assertEquals(true, currPage2Url);
		
		
	}
		
		
		
		 
	

	@Then("^Next date Event is in future$")
	public void next_date_Event_is_in_future() throws ParseException {
		boolean futureDate=false;
		
		System.out.println("Input Passed 3");
		List<WebElement> listOfDateElements = driver.findElements(By.className("RC-bigRaces__dateWide"));
	//	int count = listOfDateElements.size();
	//	System.out.println("count:" +count);
		String firstDate = listOfDateElements.get(0).getText();
		
		
		    System.out.println(firstDate);
		    char ch = '-';
		    String firstFormatDate = firstDate.replace(' ', ch);
		    System.out.println(firstFormatDate);
		    String DateNew = "01-Jul-21";
		    
		   // boolean futureDate=false;
	        
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
	        Date enteredDate = sdf.parse(firstFormatDate);
	        Date currentDate = new Date();
	        System.out.println("entered date: " +enteredDate);
	        System.out.println("Current date: " +currentDate);
	        if(enteredDate.after(currentDate)) {
	            futureDate= true;
	                    
	  
	        System.out.println("futureDate :" +futureDate);
	       
	   }
        assertEquals(true, futureDate);
	}
}
