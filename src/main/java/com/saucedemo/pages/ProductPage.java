package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class ProductPage {
    private final Page page;
    
    // Locators
    private final String firstProduct = "#item_4_title_link"; // All product links, 
    private final String productName = ".inventory_details_name";
    private final String productPrice = ".inventory_details_price";
    private final String addToCartBtn = "#add-to-cart";
    private final String backButton = "#back-to-products";
    private final String cartBadge = ".shopping_cart_badge";
    
    public ProductPage(Page page) {
        this.page = page;
    }
    
    public void navigateToFirstProduct() {
        page.locator(firstProduct).first().click();
    }
    
    public String getProductName() {
        return page.textContent(productName);
    }
    
    public String getProductPrice() {
        return page.textContent(productPrice);
    }
    
    public void addToCart() {
        page.click(addToCartBtn);
    }
    
    public void backToProducts() {
        page.click(backButton);
    }
    
    public int getCartCount() {
        return Integer.parseInt(page.textContent(cartBadge));
    }
    
    public boolean isOnProductPage() {
        return page.url().contains("/inventory.html");
    }
    
    public boolean isProductDetailsVisible() {
        return page.isVisible(productName) && 
               page.isVisible(productPrice) && 
               page.isVisible(addToCartBtn);
    }
}