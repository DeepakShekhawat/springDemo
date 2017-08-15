package home.spring.springserver.dao;

import home.spring.shoppingserver.dto.Category;

import java.util.List;

public interface CategoryDAO {

	public List<Category> list();
	public Category getCategory(int id);
}
