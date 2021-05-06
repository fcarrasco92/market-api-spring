package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository implements ProductRepository {
  private ProductoCrudRepository productoCrudRepository;
  private ProductMapper mapper; // instancia para mapear

  @Override
  public List<Product> getAll(){
    List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
    return  mapper.toProducts(productos);
  }

  @Override
  public Optional<List<Product>> getByCategory(int categoryId) {
    List <Producto> productos = productoCrudRepository.findByIdCategoria(categoryId);
    return Optional.of(mapper.toProducts(productos));
  }

  @Override
  public Optional<List<Product>> getScarseProducts(int quantity) {
    Optional<List<Producto>> productos =  productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
    return productos.map(prods -> mapper.toProducts(prods));
  }

  @Override
  public Optional<Product> getProduct(int productId) {
    return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
  }

  @Override
  public Product save(Product product) {
    Producto producto = mapper.toProducto(product);
    return mapper.toProduct(productoCrudRepository.save(producto));
  }

  @Override
  public void delete(int productId){
    productoCrudRepository.deleteById(productId);
  }

  @Override
  public List<Product> getProductsActive(){
   List<Producto> productos =  productoCrudRepository.findByEstadoOrderByNombreAsc(true);
   return mapper.toProducts(productos);
  }

  @Override
  public List<Product> getByCategoryOrdered(int categoryId) {
    List<Producto> productos = (List<Producto>)  productoCrudRepository.finByIdCategoriaOrderByNombreAsc(categoryId);
    return mapper.toProducts(productos);
  }

  @Override
  public List<Product> getProductsCheap(double price, boolean active) {
    List<Producto> productos = productoCrudRepository.findByPrecioVentaLessThanAndEstado(price, active);
    return mapper.toProducts(productos);
  }
}
