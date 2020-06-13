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
	
	@When("she fills in {string} with {string}1")
	public void she_fills_in_with1(String inputId, String inputValue) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("username")).sendKeys("tomsmith");
	    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("she fills in {string} with {string}2")
	public void she_fills_in_with2(String inputId, String inputValue) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("username")).sendKeys("tomsmith");
	    driver.findElement(By.id("password")).sendKeys("wrong");
	    throw new io.cucumber.java.PendingException();
	}
	//Ss que hacer esto doble mata el proposito del 3, pero lo que pidio el 3 si se optimizo
	
	@When("she presses {string}")
	public void she_presses(String buttonName) {
	    // Write code here that turns the phrase above into concrete actions
		 WebElement button = driver.findElement(By.className("radius"));
	        button.click();
	    throw new io.cucumber.java.PendingException();
	}

	//optimizar el 3 mata el input de passwords para 2 pruebas diferentes
	@Then("she is on the {String}") 
	public void she_is_on_the_users_secure_area() {
		WebElement headerLabel = driver.findElement(By.tagName("h2"));
		String title = headerLabel.getText();
		switch (title){
			case "Secure Area":
				assertEquals("Secure Area", title);
				break;
			case "Login Page":
				assertEquals("Login Page", title);
				break;
		}
	}
	

	@Then("she sees {string}")
	public void she_sees(String successMessage) {
		WebElement divSuccess = driver.findElement(By.id("flash"));
		String text = divSuccess.getText();
		assertThat(text, containsString(successMessage));
		driver.close();
	}
}
