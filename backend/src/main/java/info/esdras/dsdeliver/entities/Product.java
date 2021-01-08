package info.esdras.dsdeliver.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product extends AbstractEntity<Long> {

    private static final long serialversionUID = 1L;

    private String name;
    private Double price;
    private String description;
    private String imageUri;

    public Product() {
    }

    public Product(String name, Double price, String description, String imageUri) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUri = imageUri;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Product setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUri() {
        return imageUri;
    }

    public Product setImageUri(String imageUri) {
        this.imageUri = imageUri;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageUri='" + imageUri + '\'' +
                '}';
    }
}
