package mk.ukim.finki.emt.deviceshop.service.impl;

import mk.ukim.finki.emt.deviceshop.exceptions.CategoryNotFoundException;
import mk.ukim.finki.emt.deviceshop.models.Category;
import mk.ukim.finki.emt.deviceshop.models.Product;
import mk.ukim.finki.emt.deviceshop.repository.PersistentCategoryRepository;
import mk.ukim.finki.emt.deviceshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    @Autowired
    private PersistentCategoryRepository categoryRepository;


    @Override
    public Category getCategoryById(Long categoryId) {
        Optional<Category> c= categoryRepository.findById(categoryId);
        if(!c.isPresent())
            throw new CategoryNotFoundException();

        return c.get();
    }

    @Override
    public List<Product> getAllProducts(Long categoryId) {
        Optional<Category> c= categoryRepository.findById(categoryId);
        if(!c.isPresent())
            throw new CategoryNotFoundException();

        return c.get().getProducts();
    }
}
