package com.books.pricing.service;

import java.util.ArrayList;
import java.util.List;

import com.books.pricing.model.CartLineItem;
import com.books.pricing.model.ShoppingCart;
import com.books.pricing.pricingRule.AllSeriesRule;
import com.books.pricing.pricingRule.FourSeriesRule;
import com.books.pricing.pricingRule.Rule;
import com.books.pricing.pricingRule.RuleEngine;
import com.books.pricing.pricingRule.ThreeSeriesRule;
import com.books.pricing.pricingRule.TwoSeriesRule;
import com.books.pricing.util.Discount;
import com.books.pricing.util.DiscountPriority;

public class ShoppingCartService {
	
	
	public ShoppingCart fillCartWithPrice(ShoppingCart cart){
		
		double totalListPrice = calculateTotalListPrice(cart.getItems());
		double totalDiscount  = calculateDiscount(cart.getItems());
		cart.setListPriceTotal(totalListPrice);
		cart.setDiscount(totalDiscount);
		cart.setCartTotal(totalListPrice-totalDiscount);
		return cart;
	}
	
	public double calculateTotalListPrice(List<CartLineItem> lineItems){
		
		double totalListPrice =0;
		for(CartLineItem lineItem :lineItems){
			totalListPrice+=(lineItem.getQuantity()*lineItem.getPrice() );
		}
		return totalListPrice;
	}
	
public double calculateDiscount(List<CartLineItem> lineItems){
		
		double totalDiscount =0;
		List <LineItemBO> lines = new ArrayList<LineItemBO>(); //create LineItemBO list so that original cart remain untouched
		for(CartLineItem lineItem :lineItems){
			if(!(lineItem.getQuantity()>0)) {//if lineItem with 0 quantity don't calculate discount on it.
				continue;
			}
			lines.add( new LineItemBO(lineItem.getSku() , lineItem.getQuantity(),lineItem.getPrice(),lineItem.getSeriesName()));
		}
		
		RuleEngine ruleEngine = new RuleEngine();
		registerRule( ruleEngine);
		System.out.println("get rules after register"+ruleEngine);
		totalDiscount = ruleEngine.runRules(lines);
		return totalDiscount;
	}

public void registerRule(RuleEngine ruleEngine){
    Rule rule = new AllSeriesRule(Discount.ALL5.getName(), DiscountPriority.ALL5.getPriority(),  DiscountPriority.ALL5.getDescription());
	ruleEngine.registerRule(rule);
	
	rule = new ThreeSeriesRule(Discount.THREE.getName(), DiscountPriority.THREE.getPriority(),  DiscountPriority.THREE.getDescription());
	ruleEngine.registerRule(rule);
	
	rule = new FourSeriesRule(Discount.FOUR.getName(), DiscountPriority.FOUR.getPriority(),  DiscountPriority.FOUR.getDescription());
	ruleEngine.registerRule(rule);
	
	rule = new TwoSeriesRule(Discount.TWO.getName(), DiscountPriority.TWO.getPriority(),  DiscountPriority.TWO.getDescription());
	ruleEngine.registerRule(rule);
}

}
