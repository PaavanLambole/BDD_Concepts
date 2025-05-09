package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchResultsSteps {

	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("browser will open");
		String projectPath = System.getProperty("user.dir");

//	   System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\test\\resources\\Edge\\msedgedriver.exe");
//	   driver= new ChromeDriver();

		driver = new EdgeDriver();
		System.setProperty("webdriver.edge.driver", projectPath + "\\src\\test\\resources\\Edge\\msedgedriver.exe");

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		System.out.println("browser will open");
		driver.navigate().to("https://www.google.co.in/");
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() {
		System.out.println("Enter text");
		driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("java");

	}

	@And("hits enter")
	public void hits_enter() {
		System.out.println("Enter Button");
		driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		System.out.println("Search results");

		driver.getPageSource().contains("java");
		driver.close();
	}

}
