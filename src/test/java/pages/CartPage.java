/**
 * 
 */
package pages;

/**
 * @author mandla.tyindyi
 *
 */
public class CartPage {

	public static String tshirtsTabXpath() {
		return "//div[@class='container']//div[@id='block_top_menu']/ul/li[3]/a";
	}
	
	public static String addToCartButtonXpath() {
		return "//ul[@class='product_list grid row']/li[1]//div[@class='button-container']/a/span[text()='Add to cart']";
	}
	
	public static String cartAssertText() {
		return "There is 1 item in your cart.";
	}
	
	public static String closeButtonXpath() {
		return "//span[@class='cross']";
	}
	
	public static String checkoutButtonXpath() {
		return "//span[contains(text(),'Proceed to checkout')]";
	}
	
	public static String unitPriceXpath() {
		return "//td[@class='cart_unit']//span[@class='price']/span";
	}
	
	public static String totalPriceXpath() {
		return "//td[@class='cart_total']/span";
	}
	
	public static String increaseQuantityButtonXpath() {
		return "//i[@class='icon-plus']";
	}
}
