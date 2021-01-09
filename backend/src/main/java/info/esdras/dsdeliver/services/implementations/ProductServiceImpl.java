package info.esdras.dsdeliver.services.implementations;

import info.esdras.dsdeliver.dto.ProductDTO;
import info.esdras.dsdeliver.entities.Product;
import info.esdras.dsdeliver.repositories.ProductRepository;
import info.esdras.dsdeliver.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = repository.findAllByOrderByNameAsc();
        return products.stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
