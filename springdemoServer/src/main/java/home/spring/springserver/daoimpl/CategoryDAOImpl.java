package home.spring.springserver.daoimpl;

import home.spring.shoppingserver.dto.Category;
import home.spring.springserver.dao.CategoryDAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	private static List<Category> categories = new ArrayList<Category>();
	
	{
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("55 inch full HD");
		category.setImageUrl("CAT_1.img");
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("IPhone");
		category.setImageUrl("CAT_2.img");
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Lenovo");
		category.setImageUrl("CAT_3.img");
		categories.add(category);
	}
	
	
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}




	@Override
	public Category getCategory(int id) {
		// TODO Auto-generated method stub
		for(Category category : categories){
			if(category.getId()==id) return category;
		}
		
		return null;
	}

}
