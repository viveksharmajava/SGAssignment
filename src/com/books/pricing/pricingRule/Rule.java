package com.books.pricing.pricingRule;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.books.pricing.service.LineItemBO;

public abstract class Rule  implements Comparable<Rule>{


	private String ruleName;
	private String priority ;
	private String description;
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
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
	public Rule(String ruleName, String priority, String description) {
		super();
		this.ruleName = ruleName;
		this.priority = priority;
		this.description = description;
	}
	
	int numberOfSeriesInCart(List <LineItemBO >lines){
		HashSet <String> series = new HashSet<String>();
		Iterator <LineItemBO> lineIt = lines.iterator();
		while(lineIt.hasNext()){
			LineItemBO line =lineIt.next();
			series.add(line.getSeriesName());
		}
		return series.size();
	}
	
	int minimumCombination(List <LineItemBO >lines){
	  
		 Collections.sort(lines,new Comparator<LineItemBO>()
        {
            public int compare( LineItemBO o1, LineItemBO o2 )
            {
                return (Integer.valueOf(o1.getQuantity())).compareTo(Integer.valueOf( o2.getQuantity()) );
            }
        } );
		 
		 //System.out.println("minimumCombination="+lines.get(0).getQuantity());
		return lines.get(0).getQuantity();
	}
	
	public void updateLineItemQuantity(List<LineItemBO> lines,int reduceQuantity){
		
		Iterator <LineItemBO> lineIt = lines.iterator();
		for (Iterator<LineItemBO> iterator = lines.iterator(); iterator.hasNext();) {
			LineItemBO line = iterator.next();
		    if (0==line.getQuantity()-reduceQuantity) {
		        iterator.remove();
		    }
		    line.setQuantity(line.getQuantity()-reduceQuantity);
		}
		
		//System.out.println("lines after updating quantity"+lines);
	}
	public abstract boolean evaluateCondition(List<LineItemBO> items);
	public abstract double processRule(List<LineItemBO> items);
	@Override
	public int compareTo(Rule o) {
		return this.getPriority().compareTo(o.getPriority());
	}
	

}
