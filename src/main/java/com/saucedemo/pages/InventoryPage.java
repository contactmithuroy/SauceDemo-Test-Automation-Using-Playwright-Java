package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class InventoryPage {
    private final Page page;
    
    // Locators
    private final String cartIcon = ".shopping_cart_link";
    private final String inventoryItems = ".inventory_item";
    private final String itemName = ".inventory_item_name";
    private final String addToCartButton = "button:has-text('Add to cart')";
    private final String removeButton = "button:has-text('Remove')";
    private final String cartBadge = ".shopping_cart_badge";
    private final String sortDropdown = ".product_sort_container";
    private final String menuButton = "#react-burger-menu-btn";
    private final String sideBarButton = "#react-burger-menu-btn";
    private final String allItems = "#inventory_sidebar_link";
    public InventoryPage(Page page) {
        this.page = page;
    }

    public int getInventoryItemCount() {
        return page.locator(inventoryItems).count();
    }
 
    public String getFirstItemName() {
        return page.locator(itemName).first().textContent();
    }

    public void addFirstItemToCart() {
        page.locator(addToCartButton).first().click();
    }

    public void removeFirstItemFromCart() {
        page.locator(removeButton).first().click();
    }

    public int getCartItemCount() {
        return Integer.parseInt(page.locator(cartBadge).textContent());
    }

    public void sortItems(String sortOption) {
        page.locator(sortDropdown).selectOption(sortOption);
    }

    public void goToCart() {
        page.locator(cartIcon).click();
    }

    public boolean isMenuButtonVisible() {
        return page.locator(menuButton).isVisible();
    }

    public String getAllItemsLinkText() {
        page.locator(sideBarButton).click();
        return page.locator(allItems).textContent();
    }
}