package com.books.pricing.pricingRule;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.books.pricing.service.LineItemBO;
public class RuleEngine {
	
	Set <Rule> ruleList =null;
	public RuleEngine(){
		ruleList= new TreeSet<Rule>();
	}

	public void registerRule(Rule rule){
			ruleList.add(rule);
	}
	
	public double runRules(List <LineItemBO> lineItems)	{
		double totalDiscount =0;
		if(ruleList.size()>0){
			for(Rule rule : ruleList){
				if(rule.evaluateCondition(lineItems))
					{
					System.out.println("rule ="+rule.getRuleName()+"\t executed");
					totalDiscount= totalDiscount +	rule.processRule(lineItems);
					
					}
			}
		}
		return totalDiscount;
	
	}
	public Set<Rule> getRules(){
		 
		return ruleList;
	}
}
