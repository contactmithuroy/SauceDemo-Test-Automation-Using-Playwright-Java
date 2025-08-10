package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class LogoutPage {
	private final Page page;
	
	//Locators
	 private final String menuButton = "#react-burger-menu-btn";
	 private final String logoutButton = "#logout_sidebar_link";
	 
	 public LogoutPage(Page page) {
		 this.page = page;	 
		 }
	 public void clicToMenu() {
		 page.locator(menuButton).click();;
	 }
	 
	 public void logoutToInventory() {
		 page.locator(logoutButton).click();
	 }
}
