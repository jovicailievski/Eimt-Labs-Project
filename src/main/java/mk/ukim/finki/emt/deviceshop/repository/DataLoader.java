package mk.ukim.finki.emt.deviceshop.repository;

import mk.ukim.finki.emt.deviceshop.models.Accessory;
import mk.ukim.finki.emt.deviceshop.models.Category;
import mk.ukim.finki.emt.deviceshop.models.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private PersistentCategoryRepository categoryRepository;

    @Autowired
    private PersistentManufacturerRepository manufacturerRepository;

    @Autowired
    private PersistentProductRepository productRepository;

    @Autowired
    private PersistentAccessoryRepository accessoryRepository;


    public void run(ApplicationArguments args) {
        Category c = new Category();
        c.setName("Phones");
        categoryRepository.save(c);
        c = new Category();
        c.setName("HeadPhones");
        categoryRepository.save(c);

        Manufacturer m = new Manufacturer();
        m.setName("Samsung");
        manufacturerRepository.save(m);
        m = new Manufacturer();
        m.setName("Sony");
        manufacturerRepository.save(m);


        Accessory a = new Accessory();
        a.setName("HeadPhones");
        a.setDesc("Headphones for samsung device");
        accessoryRepository.save(a);
    }
}
