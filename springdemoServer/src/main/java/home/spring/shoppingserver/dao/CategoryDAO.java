package home.spring.shoppingserver.dao;

import home.spring.shoppingserver.dto.Category;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface CategoryDAO {

	
	public Category getCategory(int id);
	public List<Category> list();
	public boolean addCategory(Category category);
	
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
}
