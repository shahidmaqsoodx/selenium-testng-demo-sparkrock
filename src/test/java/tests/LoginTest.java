package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTest extends BaseTest {

    // TC-001: Valid login
    @Test
    public void testValidLogin() {
    	driver.get(baseUrl+"/login");
    	
    	LoginPage loginPage = new LoginPage(driver);
    	
    	loginPage.loginAs("tomsmith","SuperSecretPassword!");
    	
    	
    	SecureAreaPage secureAreaPage = new SecureAreaPage(driver);
    	
    	
    	//Verify the header
    	Assert.assertEquals(secureAreaPage.getHeaderText().trim(), "Secure Area");
    	
    	//Verify the flash text
    	Assert.assertTrue(secureAreaPage.getFlashMessage().contains("You logged into a secure area!"), "Expected flash text: 'You logged into a secure area!'");
    }

    //// Data provider for Invalid credentials
    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials(){
    	
    	return new Object[][] {
    		{"wronguser", "SuperSecretPassword", "Your username is invalid!"},
    		{"tomsmith", "wrongpassword", "Your password is invalid!"},
    		{"wronguser", "wrongpassword", "Your username is invalid!"}
    	};
    }
    

    // TC-002: Invalid credentials
    @Test(dataProvider = "invalidCredentials")
    public void testInvalidLogin(String username, String password, String expectedMessage) {
    	
    	driver.get(baseUrl+"/login");
    	
    	LoginPage loginPage = new LoginPage(driver);
    	
    	loginPage.loginAs(username, password);
    	
    	//Verify the flash error text message
    	Assert.assertTrue(loginPage.getFlashMessage().contains(expectedMessage), "Expected flash text: "+expectedMessage+" but received '"+loginPage.getFlashMessage()+"'");
    }

    
    
    
    
    

    // Data provider for Blank credentials
    @DataProvider(name = "blankCredentials")
    public Object[][] blankCredentials(){
    	
    	return new Object[][] {
    		{"", "SuperSecretPassword", "Your username is invalid!"},
    		{"tomsmith", "", "Your password is invalid!"},
    		{"", "", "Your username is invalid!"}
    	};
    }
    

    @Test(dataProvider = "blankCredentials")
    public void testBlankLogin(String username, String password, String expectedMessage) {
    	driver.get(baseUrl+"/login");
    	
    	LoginPage loginPage = new LoginPage(driver);
    	
    	loginPage.loginAs(username, password);
    	
    	//Verify the flash error text message
    	Assert.assertTrue(loginPage.getFlashMessage().contains(expectedMessage), "Expected flash text: "+expectedMessage+" but received '"+loginPage.getFlashMessage()+"'");
    }
}
