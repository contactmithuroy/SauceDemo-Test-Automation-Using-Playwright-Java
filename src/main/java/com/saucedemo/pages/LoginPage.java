package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    
    // Locators
    private final String usernameInput = "#user-name";
    private final String passwordInput = "#password";
    private final String loginButton = "#login-button";
    private final String errorMessage = "h3[data-test='error']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigateToLogin() {
        page.navigate("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        page.fill(usernameInput, username);
    }

    public void enterPassword(String password) {
        page.fill(passwordInput, password);
    }

    public void clickLogin() {
        page.click(loginButton);
    }

    public String getErrorMessage() {
        return page.textContent(errorMessage);
    }

    // Helper method for quick login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}