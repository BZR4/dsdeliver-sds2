package info.esdras.dsdeliver.entities;

import info.esdras.dsdeliver.entities.enums.OrderStatus;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order extends AbstractEntity<Long> {

    private static final long serialversionUID = 1L;

    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;
    private Double total;

    @ManyToMany
    @JoinTable(name = "tb_order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private final Set<Product> products = new HashSet<>();

    public Order() {
    }

    public Order(String address, Double latitude, Double longitude, Instant moment, OrderStatus status, Double total) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moment = moment;
        this.status = status;
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public Order setAddress(String address) {
        this.address = address;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Order setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Order setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public Instant getMoment() {
        return moment;
    }

    public Order setMoment(Instant moment) {
        this.moment = moment;
        return this;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Order setStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public Order setTotal(Double total) {
        this.total = total;
        return this;
    }


    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + getId() + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", moment=" + moment +
                ", status=" + status +
                ", total=" + total +
                '}';
    }
}
