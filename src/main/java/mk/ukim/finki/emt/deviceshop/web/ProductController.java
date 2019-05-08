package mk.ukim.finki.emt.deviceshop.web;


import mk.ukim.finki.emt.deviceshop.exceptions.CategoryNotFoundException;
import mk.ukim.finki.emt.deviceshop.exceptions.ManufacturerNotFoundException;
import mk.ukim.finki.emt.deviceshop.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt.deviceshop.models.Category;
import mk.ukim.finki.emt.deviceshop.models.Manufacturer;
import mk.ukim.finki.emt.deviceshop.models.Product;
import mk.ukim.finki.emt.deviceshop.service.CategoryService;
import mk.ukim.finki.emt.deviceshop.service.ManufacturerService;
import mk.ukim.finki.emt.deviceshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
//    private Long counter;
//    private List<Product> productList = null;
//
//    private List<Manufacturer> manufacturers = null;
//    private List<Category> categories = null;
//
//    @PostConstruct
//    public void init() {
//        counter = 1l;
//        manufacturers = new ArrayList<>();
//        categories = new ArrayList<>();
//        productList = new ArrayList<>();
//        Manufacturer m = new Manufacturer();
//        Manufacturer m1 = new Manufacturer();
//        Manufacturer m2 = new Manufacturer();
//        m.setId(1l);
//        m.setName("Nike");
//        m1.setId(2l);
//        m1.setName("Adidas");
//        m2.setId(3l);
//        m2.setName("Timberland");
//        manufacturers.add(m);
//        manufacturers.add(m1);
//        manufacturers.add(m2);
//        Category c = new Category();
//        Category c1 = new Category();
//        Category c2 = new Category();
//        c.setId(1l);
//        c.setName("Sport");
//        c1.setId(2l);
//        c1.setName("Casual");
//        c2.setId(3l);
//        c2.setName("Winter");
//        categories.add(c);
//        categories.add(c1);
//        categories.add(c2);
//
//        Product p = new Product();
//        p.setId(getNextId());
//        p.setName("NIKE AIR MAX");
//        p.setDescription("asdgsdfgdfgsdfg sdfg sdfg sdfg sdfg sdfg sdfg sdsf sdfg ");
//        p.setImgLink("google.com");
//        p.setCategory(c1);
//        p.setManufacturer(m1);
//        Product p1 = new Product();
//        p1.setId(getNextId());
//        p1.setName("WMNS NIKE FLYKNIT MAX");
//        p1.setDescription("Testing test ");
//        p1.setImgLink("google.com");
//        p1.setCategory(c2);
//        p1.setManufacturer(m1);
//        productList.add(p);
//        productList.add(p1);
//
//    }
    @Autowired
    private ProductService productService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("productList", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productDetails(Model model, @PathVariable("id") Long id) {


        model.addAttribute("product",productService.getProductById(id));
        return "product.details";
    }


    @GetMapping("/product/add")
    public String addProductGet(Model model) {
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
        model.addAttribute("categories", categoryService.getAllCategories());
        Product p = new Product();
        model.addAttribute("product", p);
        return "product.form";
    }


//    @PostMapping("/product/edit")
//    public String editProductDetails(Model model,@ModelAttribute Product p){
//        Optional<Product> Oprod = productList.stream()
//                .filter(pp -> pp.getId().equals(p.getId()))
//                .findAny();
//
//        if(!Oprod.isPresent())
//            throw new ProductNotFoundException();
//
//        Oprod.get();
//
//        Optional<Manufacturer> man = manufacturers.stream()
//                .filter(m -> m.getId().equals(p.getManufacturer().getId()))
//                .findAny();
//        if (!man.isPresent()) {
//            throw new ManufacturerNotFoundException();
//        }
//
//        p.setManufacturer(man.get());
//        Optional<Category> cat = categories.stream()
//                .filter(c -> c.getId().equals(p.getCategory().getId()))
//                .findAny();
//        if (!cat.isPresent()) {
//            throw new CategoryNotFoundException();
//        }
//
//        p.setManufacturer(man.get());
//        p.setCategory(cat.get());
//        productList.remove(Oprod.get());
//        productList.add(p);
//
//
//        return "redirect:/product/" + p.getId() + "/";
//    }
//
//    @GetMapping("/product/edit/{id}")
//    public String editProductDetailsForm(Model model,@PathVariable Long id){
//        model.addAttribute("manufacturers", manufacturers);
//        model.addAttribute("categories", categories);
//        Optional<Product> prod = productList.stream()
//                .filter(p -> p.getId().equals(id))
//                .findAny();
//        if(!prod.isPresent())
//            throw new ProductNotFoundException();
//
//
//        model.addAttribute("product", prod.get());
//        return "product.edit";
//    }

    @PostMapping("/product/add")
    public String addProductPost(Model model, @ModelAttribute Product p) {


        productService.addNewProduct(p);

        return "redirect:/products/";
    }

}
