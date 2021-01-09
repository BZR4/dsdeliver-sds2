package info.esdras.dsdeliver.services.implementations;

import info.esdras.dsdeliver.dto.OrderDTO;
import info.esdras.dsdeliver.entities.Order;
import info.esdras.dsdeliver.entities.Product;
import info.esdras.dsdeliver.entities.enums.OrderStatus;
import info.esdras.dsdeliver.repositories.OrderRepository;
import info.esdras.dsdeliver.repositories.ProductRepository;
import info.esdras.dsdeliver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<OrderDTO> findAll() {
        List<Order> orders = repository.findOrdersWithProducts();
        return orders.stream().map(OrderDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = false)
    @Override
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
        Order finalOrder = order;
        dto.getProducts().forEach(productDTO -> {
            Product product = productRepository.getOne(productDTO.getId());
            finalOrder.getProducts().add(product);
        });
        order = repository.save(order);
        return new OrderDTO(order);
    }
}
