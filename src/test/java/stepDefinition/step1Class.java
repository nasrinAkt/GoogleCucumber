package stepDefinition;

import java.time.Duration;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument.TotalDigits;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.stylesheets.LinkStyle;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class step1Class {
	WebDriver driver;
	
	@Given("^Open google application$")
	public void open_google_application() throws Throwable {
	   System.setProperty("Webdriver.chrome.driver", "C:\\chrome driver\\chrome-win64\\chrome.exe");
	   ChromeOptions run = new ChromeOptions();
	   
	   run.addArguments("--remote-allow-origins=*");
	   
	   driver = new ChromeDriver();
	   
	   driver.get("https://www.google.com/finance");
	   
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   
	   driver.manage().window().maximize();
	   
	}

	@Then("^Enter google in search field$")
	public void enter_google_in_search_field() throws Throwable {
	  
		WebElement search = driver.findElement(By.xpath("/html/body/c-wiz[2]/div/div[3]/div[3]/div/div/div/div[1]/input[2]"));
		search.sendKeys("google");
		
		WebElement search1 = driver.findElement(By.xpath("/html/body/c-wiz[2]/div/div[3]/div[3]/div/div/div/div[1]/input[2]"));
		search1.sendKeys(Keys.ENTER);
		
		
	}

	@Then("^print day range value$")
	public void print_day_range_value() throws Throwable {
	
 String value = driver.findElement(By.xpath("/html/body/c-wiz[3]/div/div[4]/div/main/div[2]/div[2]/div/div[1]/div[3]/div")).getText();
  System.out.println("DAY RANGE VALUE IS " + value);
  
  Thread.sleep(3000);
  driver.close();
		
	}
	@Then("^count of links available in page$")
	public void count_of_links_available_in_page() throws Throwable {
	   List<WebElement> all = driver.findElements(By.tagName("a"));
	   System.out.println("Total Link " + all.size());
	   
	   for(int i = 0; i<all.size();i++) {
		 System.out.println( all.get(i).getAttribute("href")); 
		 
	   
	   }
	   driver.close();
	}


}
