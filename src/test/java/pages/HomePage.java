/**
 * 
 */
package pages;

/**
 * @author mandla.tyindyi
 *
 */
public class HomePage {

	
	public static String searchFieldXpath() {
		return "//input[@id='search_query_top']";
	}
	
	public static String searchIconXpath() {
		return "//button[@name='submit_search']";
	}
	
	public static String searchFirstResultXpath() {
		return "//ul[@class='product_list grid row']/li[1]";
	}
}
