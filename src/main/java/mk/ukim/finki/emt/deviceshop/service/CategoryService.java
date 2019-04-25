package mk.ukim.finki.emt.deviceshop.service;

import mk.ukim.finki.emt.deviceshop.models.Category;
import mk.ukim.finki.emt.deviceshop.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService{
    Category getCategoryById(Long categoryId);

    List<Product> getAllProducts(Long categoryId);

    List<Category> getAllCategories();
}
