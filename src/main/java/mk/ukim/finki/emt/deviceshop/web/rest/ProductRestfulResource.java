package mk.ukim.finki.emt.deviceshop.web.rest;

import mk.ukim.finki.emt.deviceshop.models.Product;
import mk.ukim.finki.emt.deviceshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ProductRestfulResource {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/product/category/{categoryId}")
    public List<Product> getProductsByCategoryId(@PathVariable Long categoryId){
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping("/product/category/{categoryId}/manufacturer/{manufacturerId}")
    public List<Product> getProductsByCategoryAndManufacturer(@PathVariable Long categoryId, @PathVariable Long manufacturerId){
        return productService.getProductsByCategoryAndManufacturer(categoryId,manufacturerId);
    }

    @GetMapping("/product/category/{categoryId}/price")
    public Double getProductsByCategoryAndManufacturer(@PathVariable Long categoryId){
        return productService.getPriceForAllProductsInCategory(categoryId);
    }


}
