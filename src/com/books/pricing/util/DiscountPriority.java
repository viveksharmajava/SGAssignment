package com.books.pricing.util;

/**
 * ENUM for setting up sorting priority for different types of discounts
 * @author vivek
 *
 */
public enum DiscountPriority {
	
	ALL5("1", "25% Discount if user is buying books from all"),
	FOUR("2", "20% Discount if user is buying books from 4 series"),
	THREE("3", "10% Discount if user is buying books from 3 series"),
	TWO("4", "5% Discount if user is buying books from 2 series"),
	Others("999", "No Discount applicable");
	String priority;
	
	String description;
	
	private DiscountPriority(String priority, String description) {
		this.priority = priority;
		this.description = description;
	}
	
	public static DiscountPriority getDiscountPriority(String discount) {
		DiscountPriority discountPriority = Others;
	    if(discount != null) {
	        try {
	        	discountPriority = DiscountPriority.valueOf(discount);
	        } catch(IllegalArgumentException ex) {
	        }
	    }
	    return discountPriority;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

