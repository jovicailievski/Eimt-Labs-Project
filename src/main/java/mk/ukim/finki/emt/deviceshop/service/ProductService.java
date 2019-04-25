package mk.ukim.finki.emt.deviceshop.service;

import mk.ukim.finki.emt.deviceshop.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {


    List<Product> getAllProducts();

    Product getProductById(Long id);

    List<Product> getProductsByCategory(Long categoryId);

    List<Product> getProductsByCategoryAndManufacturer(Long categoryId, Long manufacturerId);

    Double getPriceForAllProductsInCategory(Long categoryId);

    void addNewProduct(Product p);
}
