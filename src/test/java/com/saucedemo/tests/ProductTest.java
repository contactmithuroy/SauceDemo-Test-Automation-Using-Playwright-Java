package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Product Details")
@Feature("Standalone Product Testing")
public class ProductTest extends BaseTest {
    
    private void loginToInventory() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLogin();
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(priority = 1, description = "Verify product details display")
    @Severity(SeverityLevel.CRITICAL)
    public void testProductDetailsDisplay() {
    	loginToInventory();
    	
    	ProductPage productPage = new ProductPage(page);
    	productPage.navigateToFirstProduct();
    	
        Assert.assertTrue(productPage.isProductDetailsVisible(), 
            "All product elements should be visible");
        
        String name = productPage.getProductName();
        String price = productPage.getProductPrice();
        
        Assert.assertFalse(name.isEmpty(), "Product name shouldn't be empty");
        Assert.assertTrue(price.startsWith("$"), "Price should be formatted");
    }

    @Test(priority = 2, description = "Add product to cart from details")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddToCartFromProductPage() {
    	loginToInventory();
    	
    	ProductPage productPage = new ProductPage(page);
    	productPage.navigateToFirstProduct();
    	
        productPage.addToCart();
        Assert.assertEquals(productPage.getCartCount(), 1, 
            "Cart count should update after adding");
    }

    @Test(priority = 3, description = "Navigate back to inventory")
    @Severity(SeverityLevel.NORMAL)
    public void testBackNavigation() {
    	loginToInventory();
    	
    	ProductPage productPage = new ProductPage(page);
    	productPage.navigateToFirstProduct();
    	
        productPage.backToProducts();
        Assert.assertTrue(productPage.isOnProductPage(), 
            "Should return to inventory page");
    }
}