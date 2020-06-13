package mx.tec.lab.stepdefinitions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInLogOutStepDefs {
    private static WebDriver driver;
			
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
        String basePath = new File("").getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", basePath + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/login");
	}
	
	@When("she fills in {string} with {string}")
	public void she_fills_in_with(String inputId, String inputValue) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("username")).sendKeys("tomsmith");
	    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	    throw new io.cucumber.java.PendingException();
	}

	@When("she presses {string}")
	public void she_presses(String buttonName) {
	    // Write code here that turns the phrase above into concrete actions
		 WebElement button = driver.findElement(By.className("radius"));
	        button.click();
		/*switch(buttonName) {
			case "Login":
		       
		    
		}*/
	    throw new io.cucumber.java.PendingException();
	}

	@Then("she is on the users secure area")
	public void she_is_on_the_users_secure_area() {
		WebElement headerLabel = driver.findElement(By.tagName("h2"));
		String title = headerLabel.getText();
		assertEquals("Secure Area", title);
	}

	@Then("she sees {string}")
	public void she_sees(String successMessage) {
		WebElement divSuccess = driver.findElement(By.id("flash"));
		String text = divSuccess.getText();
		assertThat(text, containsString(successMessage));
		driver.close();
	}
}
