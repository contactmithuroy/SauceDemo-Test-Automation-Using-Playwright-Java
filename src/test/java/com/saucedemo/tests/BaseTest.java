package com.saucedemo.tests;

import com.microsoft.playwright.Page;
import com.saucedemo.utils.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected Page page;

    @Parameters({"browser", "headless"})
    @BeforeMethod
    public void setUp(String browser, String headless) {
        page = BrowserFactory.initBrowser(browser, Boolean.parseBoolean(headless));
    }
    @AfterMethod
    public void tearDown() {
        BrowserFactory.closeBrowser();
    }
}