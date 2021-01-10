package info.esdras.dsdeliver.services;

import info.esdras.dsdeliver.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> findAll();
    OrderDTO insert(OrderDTO orderDTO);
    OrderDTO setDelivered(Long id);
}
