package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

  // query Methods
  List<Producto> findByIdCategoria(int idCategoria);

  // query sql
  @Query(value = "SELECT * FROM productos where id_categoria = ?", nativeQuery = true)
  List<Producto> getCategoryByIdCategoria(int idCategoria);

  List<Producto> finByIdCategoriaOrderByNombreAsc(int idCategoria);

  Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

  List<Producto> findByPrecioVentaLessThanAndEstado(Double precioVenta, boolean estado);

  List<Producto> findByEstadoOrderByNombreAsc(boolean estado);
}
