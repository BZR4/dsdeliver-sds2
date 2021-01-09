package info.esdras.dsdeliver.dto;

import info.esdras.dsdeliver.entities.Order;
import info.esdras.dsdeliver.entities.enums.OrderStatus;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;
    private Double total;

    private List<ProductDTO> products = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(Order entity) {
        id = entity.getId();
        address = entity.getAddress();
        latitude = entity.getLatitude();
        longitude = entity.getLongitude();
        moment = entity.getMoment();
        status = entity.getStatus();
        total = entity.getTotal();
        products = entity.getProducts().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public OrderDTO(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatus status, Double total) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moment = moment;
        this.status = status;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public OrderDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public OrderDTO setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public OrderDTO setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderDTO setMoment(Instant moment) {
        this.moment = moment;
        return this;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public OrderDTO setStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public OrderDTO setTotal(Double total) {
        this.total = total;
        return this;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }
}
