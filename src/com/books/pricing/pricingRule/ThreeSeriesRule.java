package com.books.pricing.pricingRule;
import java.util.List;

import com.books.pricing.service.LineItemBO;
import com.books.pricing.util.PricingConstants;

public class ThreeSeriesRule extends Rule{
	
	private static double discountPercentage = 10;
	
	public ThreeSeriesRule(String ruleName, String priority, String desc) {
		super(ruleName,priority,desc);
		
	}
	
	public boolean evaluateCondition(List<LineItemBO> items){
		if(numberOfSeriesInCart(items)== PricingConstants.THREE_SERIES)
			return true;
		else return false;
	}
	public double processRule(List<LineItemBO> items){
		double discountedValue =0;
		int set = minimumCombination(items);
		discountedValue = set*PricingConstants.THREE_SERIES*8*discountPercentage/100;
		updateLineItemQuantity(items,set);
		return discountedValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThreeSeriesRule other = (ThreeSeriesRule) obj;
		if (super.getPriority() == null) {
			if (other.getPriority() != null)
				return false;
		} else if (!super.getPriority().equals(other.getPriority()))
			return false;
		if (super.getPriority() == null) {
			if (other.getRuleName() != null)
				return false;
		} else if (!super.getRuleName().equals(other.getRuleName()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ThreeSeriesRule [getRuleName()=" + getRuleName()+"\t priority="+getPriority();
	}
	
}
