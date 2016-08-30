package com.books.pricing.util;


public enum Discount {
	ALL5(PricingConstants.TWENTYFIVE),
	FOUR(PricingConstants.TWENTY),
	THREE(PricingConstants.TEN),
	TWO(PricingConstants.FIVE),
	Others("Not Discount");
	
	String name;
	
	Discount(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static Discount getDiscount(String discount) {
		Discount discountObj = Others;
	    if(discount != null) {
	        try {
	        	discountObj = Discount.valueOf(discount);
	        } catch(IllegalArgumentException ex) {
	        }
	    }
	    return discountObj;
	}
	
}