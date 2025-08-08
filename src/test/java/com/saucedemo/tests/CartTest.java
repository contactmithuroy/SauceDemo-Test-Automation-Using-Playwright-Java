
// Verify adding item and viewing it in cart
// Verify removing item from cart
// Verify checkout button is visible
// Continue shopping from cart

package com.saucedemo.tests;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

// @Epic("Cart Management")
//@Feature("Cart Operations")
public class CartTest extends BaseTest {
    
    private void loginAndAddItem() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLogin();
        loginPage.login("standard_user", "secret_sauce");
        
        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.addFirstItemToCart();
        inventoryPage.goToCart();
    }
    
    @Test(priority = 1, description = "Verify checkout button is visible")
    @Description("Ensure checkout option is visible after adding an item")
    @Severity(SeverityLevel.NORMAL)
    @Story("Cart - Checkout visibility")
    public void testCheckoutButtonVisible() {
    	loginAndAddItem();

        Assert.assertTrue(page.isVisible("button[data-test='checkout']"), "Checkout button should be visible");
    }
    
    @Test(priority = 2, description = "Verify items added to cart")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User adds item to cart")
    public void testItemAddedToCart() {
        loginAndAddItem();
        CartPage cartPage = new CartPage(page);
        
        Assert.assertTrue(cartPage.isOnCartPage(), "Should be on cart page");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Cart should have 1 item");
    }

    @Test(priority = 3, description = "Remove item from cart")
    @Severity(SeverityLevel.NORMAL)
    @Story("User removes item from cart")
    public void testRemoveItemFromCart() {
        loginAndAddItem();
        CartPage cartPage = new CartPage(page);
        
        String itemName = cartPage.getFirstItemName();
        cartPage.removeFirstItem();
        
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Cart should be empty after removal");
    }

    @Test(priority = 4, description = "Continue shopping from cart")
    @Severity(SeverityLevel.NORMAL)
    @Story("User continues shopping")
    public void testContinueShopping() {
        loginAndAddItem();
        CartPage cartPage = new CartPage(page);
        cartPage.continueShopping();
        
        Assert.assertTrue(page.url().contains("/inventory.html"), "Should return to inventory");
    }
    
}