package home.spring.shoppingserver.daoimpl;

import home.spring.shoppingserver.dao.CategoryDAO;
import home.spring.shoppingserver.dto.Category;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * getList of all Categories
	 * @see home.spring.shoppingserver.dao.CategoryDAO#list()
	 */
	@Override
	public List<Category> list() {
		
		String selectActiveCategoryQuery = "From Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategoryQuery);
		query.setParameter("active", true);
		return query.getResultList();
	}

	/*
	 * getting category for each id
	 * @see home.spring.shoppingserver.dao.CategoryDAO#getCategory(int)
	 */
	@Override
	public Category getCategory(int id) {
		// TODO Auto-generated method stub
		try{
			return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		} catch(Exception ex){
			
			ex.printStackTrace();
			
		}
		return null;
	}
	
	/*
	 * add a new Category
	 * @see home.spring.shoppingserver.dao.CategoryDAO#addCategory(home.spring.shoppingserver.dto.Category)
	 */
	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		// TODO Auto-generated method stub
	}

	/*
	 * update a single category
	 * @see home.spring.shoppingserver.dao.CategoryDAO#updateCategory(home.spring.shoppingserver.dto.Category)
	 */
	@Override
	public boolean updateCategory(Category category) {
		
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	/*
	 * Soft delete category by setting active flag as False
	 * @see home.spring.shoppingserver.dao.CategoryDAO#deleteCategory(home.spring.shoppingserver.dto.Category)
	 */
	@Override
	public boolean deleteCategory(Category category) {
		
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
