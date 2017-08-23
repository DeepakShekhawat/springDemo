package home.spring.shoppingserver.test;

import static org.junit.Assert.assertEquals;
import home.spring.shoppingserver.dao.ProductDAO;
import home.spring.shoppingserver.dto.Product;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTeseCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private static Product product;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("home.spring.shoppingserver");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	
	
	/*@Test
	public void testProductCurdOperation(){
		
				//Add operation
				product = new Product();
				product.setName("Sony Xperia");
				product.setDescription("Sony Xperia Z2 5.5 inch water resistent phone");
				product.setBrand("Sony");
				product.setActive(true);
				product.setSupplierId(3);
				product.setCategoryId(3);
				product.setUnitPrice(43000);
				productDAO.addProduct(product);
				assertEquals("single product updated successfully...",true,productDAO.addProduct(product));
				
				//fetching and updating product
				
				product = productDAO.getProduct(3);
				product.setDescription("LG 55 inch Full HD LED");
				assertEquals("single product updated successfully...",true,productDAO.updateProduct(product));
				
				//Deleting product
				
				product = productDAO.getProduct(3);
				product.setActive(false);
				assertEquals("Product updated as unavailable successfully...",true,productDAO.deleteProduct(product));
				
				assertEquals("get the list of all categories successfully...",6,productDAO.getAllProducts().size());
	}*/
	
	@Test
	public void testgetLatestActiveProducts(){
		
		assertEquals("get the list of all categories successfully...",6,productDAO.getLatestActiveProducts(10).size());
	}
}
