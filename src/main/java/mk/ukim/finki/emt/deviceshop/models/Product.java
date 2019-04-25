package mk.ukim.finki.emt.deviceshop.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    @Column(length = 1000)
    private String description;

    @Column(length = 1000)
    private String imgLink;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "man_id")
    private Manufacturer manufacturer;


    @ManyToMany
    @JoinTable(name = "device_accessory")
    List<Accessory> accessories;

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
