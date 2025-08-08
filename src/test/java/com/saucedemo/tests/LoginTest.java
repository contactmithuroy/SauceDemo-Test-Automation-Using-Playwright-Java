package com.saucedemo.tests;
import io.qameta.allure.*;
import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {

	@Test(priority = 1, description = "Successful login with valid credentials")
	@Description("Verify successful login redirects to inventory page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Login with valid user")
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLogin();
        loginPage.login("standard_user", "secret_sauce");
        
        Assert.assertTrue(page.url().contains("/inventory.html"), "User should be redirected to inventory page");
    }

	@Test(priority = 2, description = "Error message for locked_out_user")
	@Description("Check locked out user receives appropriate error")
	@Severity(SeverityLevel.NORMAL)
	@Story("Login with locked_out_user")
    public void testLockedOutUser() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLogin();
        loginPage.login("locked_out_user", "secret_sauce");
        
        Assert.assertEquals(
            loginPage.getErrorMessage(),
            "Epic sadface: Sorry, this user has been locked out.",
            "Error message should match"
        );
    }

	@Test(priority = 3, description = "Error message for invalid credentials")
	@Description("Check error for invalid login credentials")
	@Severity(SeverityLevel.NORMAL)
	@Story("Login with invalid credentials")
    public void testInvalidCredentials() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLogin();
        loginPage.login("invalid_user", "wrong_password");
        
        Assert.assertEquals(
            loginPage.getErrorMessage(),
            "Epic sadface: Username and password do not match any user in this service",
            "Error message should match"
        );
    }
}