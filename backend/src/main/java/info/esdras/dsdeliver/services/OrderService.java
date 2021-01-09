package info.esdras.dsdeliver.services;

import info.esdras.dsdeliver.dto.OrderDTO;
import info.esdras.dsdeliver.entities.Order;

import java.util.List;

public interface OrderService {
    List<OrderDTO> findAll();
}
