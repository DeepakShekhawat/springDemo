package home.spring.shoppingserver.dao;

import home.spring.shoppingserver.dto.Product;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface ProductDAO {

	List<Product> getAllProducts();
	Product getProduct(int productId);
	boolean updateProduct(Product product);
	boolean addProduct(Product product);
	boolean deleteProduct(Product product);
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
}
