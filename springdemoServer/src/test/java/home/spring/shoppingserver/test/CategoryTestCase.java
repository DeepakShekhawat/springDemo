package home.spring.shoppingserver.test;

import static org.junit.Assert.assertEquals;
import home.spring.shoppingserver.dao.CategoryDAO;
import home.spring.shoppingserver.dto.Category;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO; 
	private Category category;

	@BeforeClass
	public static void inti(){
		context = new AnnotationConfigApplicationContext();
		context.scan("home.spring.shoppingserver");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	

	/*@Test
	public void testAddCategory(){
		category = new Category();
		category.setName("Laptop");
		category.setDescription("Lenovo");
		category.setImageUrl("CAT_3.img");
		assertEquals("Category Added successfully...",true,categoryDAO.addCategory(category));
	}*/
	
	
	/*@Test
	public void getTestCategory(){
		
		category=categoryDAO.getCategory(1);
		assertEquals("Category Name is equals to expect category name..","Television",category.getName());
	}*/
	
	/*@Test
	public void updateCategory(){
		category = categoryDAO.getCategory(4);
		category.setImageUrl("CAT_4.img");
		assertEquals("Category updated single category successfully...",true,categoryDAO.updateCategory(category));
	}*/
	
	/*@Test
	public void deleteCategory(){
		category = categoryDAO.getCategory(4);
		category.setActive(false);
		assertEquals("Category updated as unavailable successfully...",true,categoryDAO.deleteCategory(category));
	}*/
	
	/*@Test
	public void getCategory(){
		category = categoryDAO.getCategory(4);
		category.setActive(false);
		assertEquals("get the list of all categories successfully...",3,categoryDAO.list().size());
	}*/
	
	@Test
	public void testCurdOperation(){
		
		//Add operation
		category = new Category();
		category.setName("Laptop");
		category.setDescription("Lenovo");
		category.setImageUrl("CAT_11.img");
		assertEquals("Category Added successfully...",true,categoryDAO.addCategory(category));
		category = new Category();
		category.setName("Telivesion");
		category.setDescription("LG Full HD 55 inches");
		category.setImageUrl("CAT_22.img");
		assertEquals("Category Added successfully...",true,categoryDAO.addCategory(category));
		category = new Category();
		category.setName("Mobile");
		category.setDescription("IPhone 7s plus golden");
		category.setImageUrl("CAT_33.img");
		assertEquals("Category Added successfully...",true,categoryDAO.addCategory(category));
		
		//fetching and updating category
		
		category = categoryDAO.getCategory(3);
		category.setImageUrl("CAT_333.img");
		assertEquals("Category updated single category successfully...",true,categoryDAO.updateCategory(category));
		
		//Deleting category
		
		category = categoryDAO.getCategory(3);
		category.setActive(false);
		assertEquals("Category updated as unavailable successfully...",true,categoryDAO.deleteCategory(category));
		
		assertEquals("get the list of all categories successfully...",2,categoryDAO.list().size());
	}
}

