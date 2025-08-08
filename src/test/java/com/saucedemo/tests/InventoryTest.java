package com.saucedemo.tests;

import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

//@Epic("Inventory Management")
//@Feature("Inventory Operations")
public class InventoryTest extends BaseTest {

    private void loginToInventory() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLogin();
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(priority = 1, description = "Verify inventory page contains 'Swag Labs' heading")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User views inventory")
    public void testInventoryPageHeading() {
        loginToInventory();
        
        Assert.assertTrue(page.locator(".header_label .app_logo").isVisible(), 
            "Swag Labs logo should be visible");
        Assert.assertEquals(page.locator(".header_label .app_logo").textContent(), 
            "Swag Labs", "Heading should match 'Swag Labs'");
    }

    @Test(priority = 2, description = "Verify cart badge is displayed when item added")
    @Severity(SeverityLevel.NORMAL)
    @Story("User adds item to cart")
    public void testCartBadgeDisplay() {
        loginToInventory();
        InventoryPage inventoryPage = new InventoryPage(page);
        
        inventoryPage.addFirstItemToCart();
        Assert.assertTrue(page.locator(".shopping_cart_badge").isVisible(), 
            "Cart badge should be visible");
        Assert.assertEquals(inventoryPage.getCartItemCount(), 1, 
            "Cart badge should show 1 item");
    }

    @Test(priority = 3, description = "Add item to cart from inventory")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User adds item to cart")
    public void testAddItemToCart() {
        loginToInventory();
        InventoryPage inventoryPage = new InventoryPage(page);
       
        inventoryPage.addFirstItemToCart();
        
        Assert.assertEquals(inventoryPage.getCartItemCount(), 1, 
            "Cart should show 1 item after adding");
    }

    @Test(priority = 4, description = "Remove item from inventory")
    @Severity(SeverityLevel.NORMAL)
    @Story("User removes item")
    public void testRemoveItemFromInventory() {
        loginToInventory();
        InventoryPage inventoryPage = new InventoryPage(page);
        
        inventoryPage.addFirstItemToCart();
        inventoryPage.removeFirstItemFromCart();
        
        Assert.assertEquals(page.locator(".shopping_cart_badge").count(), 0,
            "Cart badge should disappear after removal");
    }

    @Test(priority = 5, description = "Sort inventory items by Name (Z to A)")
    @Severity(SeverityLevel.NORMAL)
    @Story("User sorts inventory")
    public void testSortInventory() {
        loginToInventory();
        InventoryPage inventoryPage = new InventoryPage(page);
        
        String originalFirstItem = inventoryPage.getFirstItemName();
        inventoryPage.sortItems("za");
        String sortedFirstItem = inventoryPage.getFirstItemName();
      
        Assert.assertNotEquals(originalFirstItem, sortedFirstItem, 
            "Sorting should change item order");
    }

    @Test(priority = 6, description = "Verify 'Open Menu' button exists")
    @Severity(SeverityLevel.MINOR)
    @Story("User views menu options")
    public void testMenuButtonExists() {
        loginToInventory();
        InventoryPage inventoryPage = new InventoryPage(page);
      
        Assert.assertTrue(inventoryPage.isMenuButtonVisible(),
            "Menu button should be visible");
        Assert.assertEquals(inventoryPage.getAllItemsLinkText(), 
        		"All Items", "All Items hadding is visible");
        
    }
}