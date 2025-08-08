package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class CartPage {
    private final Page page;
    
    // Locators
    private final String cartItem = ".cart_item";
    private final String itemName = ".inventory_item_name";
    private final String removeButton = "button[id^='remove']";
    private final String continueShoppingBtn = "#continue-shopping";
    private final String checkoutBtn = "#checkout";

    public CartPage(Page page) {
        this.page = page;
    }

    public int getCartItemCount() {
        return page.locator(cartItem).count();
    }

    public String getFirstItemName() {
        return page.locator(itemName).first().textContent();
    }

    public void removeFirstItem() {
        page.locator(removeButton).first().click();
    }

    public void continueShopping() {
        page.click(continueShoppingBtn);
    }

    public void proceedToCheckout() {
        page.click(checkoutBtn);
    }

    public boolean isOnCartPage() {
        return page.url().contains("/cart.html");
    }
}