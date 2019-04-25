package mk.ukim.finki.emt.deviceshop.service.impl;

import mk.ukim.finki.emt.deviceshop.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt.deviceshop.models.Category;
import mk.ukim.finki.emt.deviceshop.models.Manufacturer;
import mk.ukim.finki.emt.deviceshop.models.Product;
import mk.ukim.finki.emt.deviceshop.repository.PersistentProductRepository;
import mk.ukim.finki.emt.deviceshop.service.CategoryService;
import mk.ukim.finki.emt.deviceshop.service.ManufacturerService;
import mk.ukim.finki.emt.deviceshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private PersistentProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product getProductById(Long id) {
         Optional<Product> p = productRepository.findById(id);
         if(!p.isPresent())
             throw new ProductNotFoundException();

         return p.get();
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
       return categoryService.getAllProducts(categoryId);
    }

    @Override
    public List<Product> getProductsByCategoryAndManufacturer(Long categoryId, Long manufacturerId) {
        Category cat = categoryService.getCategoryById(categoryId);
        Manufacturer man = manufacturerService.getManufacturerById(manufacturerId);
        List<Product> pList = new ArrayList<>();
        for(Product pc : cat.getProducts()){
            for(Product pm : man.getProducts()){
                if(pc.getId().equals(pm.getId()))
                    pList.add(pc);
            }
        }

        return pList;

    }

    @Override
    public Double getPriceForAllProductsInCategory(Long categoryId) {
        Category c = categoryService.getCategoryById(categoryId);
        return c.getProducts().stream()
                .mapToDouble(p -> p.getPrice())
                .sum();
    }

    @Override
    public void addNewProduct(Product p) {
        Manufacturer man = manufacturerService.getManufacturerById(p.getManufacturer().getId());
        Category cat = categoryService.getCategoryById(p.getCategory().getId());
        p.setCategory(cat);
        p.setManufacturer(man);
        productRepository.save(p);
    }
}
