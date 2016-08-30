package com.books.pricing.model;

public class CartLineItem {
	
	private String lineItemKey;
	private String sku;
	private String skuName;
	private String seriesName;
	public CartLineItem(String lineItemKey, String sku, String skuName,
			String seriesName, int quantity) {
		super();
		this.lineItemKey = lineItemKey;
		this.sku = sku;
		this.skuName = skuName;
		this.seriesName = seriesName;
		this.quantity = quantity;
	}
	private int quantity;
	private final static int price=8;//price is already provided for each book
	
	
	public String getLineItemKey() {
		return lineItemKey;
	}
	public void setLineItemKey(String lineItemKey) {
		this.lineItemKey = lineItemKey;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public static int getPrice() {
		return price;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartLineItem other = (CartLineItem) obj;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}
	
	
	

}
