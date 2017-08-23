package home.spring.shoppingserver.daoimpl;

import home.spring.shoppingserver.dao.ProductDAO;
import home.spring.shoppingserver.dto.Product;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getAllProducts() {
		logger.info("inside getAlProductDAOImpllProducts getAllProducts method INFO");
		logger.debug("inside ProductDAOImpl getAllProducts method DEBUG");
		String queryStringForProductList = "From Product";
		Query query = sessionFactory.getCurrentSession().createQuery(
				queryStringForProductList, Product.class);
		return query.getResultList();
	}

	@Override
	public Product getProduct(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class,
					Integer.valueOf(productId));
		} catch (Exception ex) {

			ex.printStackTrace();

		}
		return null;
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();

		}
		return false;

	}

	@Override
	public boolean addProduct(Product product) {

		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();

		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProductQueryString = "From Product where active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(
				selectActiveProductQueryString, Product.class);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductQueryString = "From Product where active = :active and categoryId = :categoryId";
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProductQueryString, Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId).getResultList();

	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"From Product where active = :active ORDER BY id",
						Product.class).setParameter("active", true)
				.setFirstResult(0).setMaxResults(count).getResultList();
	}

}
