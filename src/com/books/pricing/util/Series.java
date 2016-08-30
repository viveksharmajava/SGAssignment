package com.books.pricing.util;


public enum Series {
	FIFTH("Fifth Series"),
	FOURTH("Fourth Series"),
	THIRD("Third Series"),
	SECOND("Second Series"),
	FIRST("First Series"),
	Others("unknown Series");
	
	String name;
	
	Series(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static Series getSeries(String discount) {
		Series discountObj = Others;
	    if(discount != null) {
	        try {
	        	discountObj = Series.valueOf(discount);
	        } catch(IllegalArgumentException ex) {
	        }
	    }
	    return discountObj;
	}
	
}