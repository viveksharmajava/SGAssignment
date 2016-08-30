package com.books.pricing.service;

public class LineItemBO {

	private String sku;
	private int quantity;
	private int price ;
	private String seriesName;
	public LineItemBO(String sku, int quantity, int price,String seriesName) {
		super();
		this.sku = sku;
		this.quantity = quantity;
		this.price = price;
		this.seriesName=seriesName;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	@Override
	public String toString() {
		return "LineItemBO [sku=" + sku + ", quantity=" + quantity + ", price="
				+ price + ", seriesName=" + seriesName + "]";
	}
	
	
}
