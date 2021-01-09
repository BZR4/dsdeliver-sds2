package info.esdras.dsdeliver.services.implementations;

import info.esdras.dsdeliver.dto.OrderDTO;
import info.esdras.dsdeliver.entities.Order;
import info.esdras.dsdeliver.repositories.OrderRepository;
import info.esdras.dsdeliver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<OrderDTO> findAll() {
        List<Order> orders = repository.findOrdersWithProducts();
        return orders.stream().map(OrderDTO::new).collect(Collectors.toList());
    }
}
