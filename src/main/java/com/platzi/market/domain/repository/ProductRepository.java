package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
  List<Product> getAll();
  Optional<List<Product>> getByCategory(int categoryId);
  Optional<List<Product>> getScarseProducts(int quantity);
  Optional<Product> getProduct(int productId);
  Product save(Product product);
  void delete(int productId);

  // method created by me.
  List<Product> getByCategoryOrdered(int categoryId);
  List<Product> getProductsCheap(double price, boolean active);
  List<Product> getProductsActive();

}
