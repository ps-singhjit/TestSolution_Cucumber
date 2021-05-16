package parallel;

import java.io.File;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver()); // get the already running driver
	private static String title;

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		String appPath = System.getProperty("user.dir")+"/LoginApp/index.html" ;		
		DriverFactory.getDriver().get(appPath);
		title = loginPage.getLoginPageTitle();
		System.out.println("My login page title is: " + title);
		String expectedTitle = "LoginApp-LA";
		Assert.assertTrue(title.contains(expectedTitle));		

	}

	@When("I login with {string} and {string}")
	public void i_login_with_and(String uName, String uPassword) {
		loginPage.doLogin(uName, uPassword);
	}

	@Then("I should see a message saying {string} near Password field" )
	public void i_should_see_a_message_saying_near_Password_field(String msg) {
		String message = loginPage.getPasswordMessage();
		Assert.assertEquals(message, msg);
	}
	
	@Then("I should see a message saying {string} near Name field" )
	public void i_should_see_a_message_saying_near_Name_field(String msg) {
		String message = loginPage.getUserMessage();
		Assert.assertEquals(message, msg);
	}

//	@Given("user is on login page")
//	public void user_is_on_login_page() {
//		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
//		
//	}
//
//	@When("user gets the title of the page")
//	public void user_gets_the_title_of_the_page() {
//		title = loginPage.getLoginPageTitle();
//		System.out.println("My login page title is: " + title);
//	}
//	
//	@Then("page title should be {string}")
//	public void page_title_should_be(String expectedTitle) {		
//		Assert.assertTrue(title.contains(expectedTitle));
//	    
//	}
//
//	@Then("forgot your password link should be displayed")
//	public void forgot_your_password_link_should_be_displayed() {
//		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
//	}
//
//	@When("user enters username {string}")
//	public void user_enters_username(String username) {
//		loginPage.enterUserName(username);
//	}
//
//	@When("user enters password {string}")
//	public void user_enters_password(String password) {
//	    loginPage.enterPassword(password);
//	}
//
//	@When("user clicks on Login button")
//	public void user_clicks_on_login_button() {
//	    loginPage.clickOnLoginButton();
//	}

}
