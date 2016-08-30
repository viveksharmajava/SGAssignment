package com.books.pricing.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	private String cartKey;
	private String cartName;
	private List<CartLineItem> items = new ArrayList<CartLineItem>();
	private double listPriceTotal;
	private double discount;
	private double cartTotal;
	public String getCartKey() {
		return cartKey;
	}
	public void setCartKey(String cartKey) {
		this.cartKey = cartKey;
	}
	public String getCartName() {
		return cartName;
	}
	public void setCartName(String cartName) {
		this.cartName = cartName;
	}
	public List<CartLineItem> getItems() {
		return items;
	}
	
	public double getListPriceTotal() {
		return listPriceTotal;
	}
	public void setListPriceTotal(double listPriceTotal) {
		this.listPriceTotal = listPriceTotal;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}
	/*
	 * Here assumption is that no duplicate item will be added means user won't add same book more than ones.
	 */
	public List<CartLineItem> addItemToCart(CartLineItem item){
		items.add(item);
		return items;
	}
	
	public List<CartLineItem> deleteItemFromCart(CartLineItem item){
		
		items.remove(item);
		return items;
	}
	
}
