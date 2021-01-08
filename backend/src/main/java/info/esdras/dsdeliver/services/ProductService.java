package info.esdras.dsdeliver.services;

import info.esdras.dsdeliver.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
}
