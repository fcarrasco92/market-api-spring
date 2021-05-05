package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import java.util.List;
import java.util.Optional;

public class ProductoRepository {
  private ProductoCrudRepository productoCrudRepository;

  public List<Producto> getAll(){
    return (List<Producto>) productoCrudRepository.findAll();
  }

  public List<Producto> getByCategoria(int idCategoria){
    return productoCrudRepository.findByIdCategoria(idCategoria);
  }

  public List<Producto> getByCategoriaOrdered(int idCategoria){
    return productoCrudRepository.finByIdCategoriaOrderByNombreAsc(idCategoria);
  }

  public Optional<List<Producto>> getEscasos(int cantidad){
    return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
  }

  public List<Producto> getProductsCheap(Double precioVenta, boolean estado){
    return productoCrudRepository.findByPrecioVentaLessThanAndEstado(precioVenta, estado);
  }

  public List<Producto> getProductsActive(){
    return productoCrudRepository.findByEstadoOrderByNombreAsc(true);
  }
}
