package test.com.pricing;


import org.junit.BeforeClass;
import org.junit.Test;

import com.books.pricing.model.CartLineItem;
import com.books.pricing.model.ShoppingCart;
import com.books.pricing.service.ShoppingCartService;
import com.books.pricing.util.Series;

public class ShoppingCartTest {
  private static  ShoppingCartService service = null;
  private static  ShoppingCart cart= null;
	@BeforeClass
	public static void init(){
	
		cart = new ShoppingCart();
		cart.setCartKey("4455");
		cart.setCartName("eCart");
		service = new ShoppingCartService();
	}
	
	@Test
	public  void test() {
		
		CartLineItem line1 = new CartLineItem("1","105", "Harry Potter Edition1 ", Series.FIRST.getName(),1);
		CartLineItem line2 = new CartLineItem("1","106", "Harry Potter Edition2 ", Series.SECOND.getName(),1);
		CartLineItem line3 = new CartLineItem("1","107", "Harry Potter Edition3 ", Series.THIRD.getName(),1);
		CartLineItem line4 = new CartLineItem("1","108", "Harry Potter Edition4 ", Series.FOURTH.getName(),1);
		CartLineItem line5 = new CartLineItem("1","109", "Harry Potter Edition5 ", Series.FIFTH.getName(),1);
		
		cart.addItemToCart(line1);
		cart.addItemToCart(line2);
		cart.addItemToCart(line3);
		cart.addItemToCart(line4);
		cart.addItemToCart(line5);
		
		service.fillCartWithPrice(cart);
		System.out.println("list price="+cart.getListPriceTotal()+"\t discount="+cart.getDiscount());
	}

	
}
