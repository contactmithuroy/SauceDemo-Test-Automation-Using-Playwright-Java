package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.LogoutPage;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Epic("Logout Management")
//@Feature("Logout Operations")
public class LogoutTest extends BaseTest {
	private void loginToInventory() {
		LoginPage loginPage = new LoginPage(page);
		loginPage.navigateToLogin();
		loginPage.login("standard_user", "secret_sauce");
	}
	
	 @Test(priority = 1, description = "Verify inventory page is logout")
	 @Severity(SeverityLevel.CRITICAL)
	 @Story("User should logout inventory")
	 public void testInventoryPageLogout() {
		 loginToInventory();
	        
		 LogoutPage logoutPage = new LogoutPage(page);
		 logoutPage.clicToMenu();
		 logoutPage.logoutToInventory();
		 Assert.assertEquals(
				 page.url(),
				 "https://www.saucedemo.com/",
				 "Should be on login page"
	            );
	    }
}
