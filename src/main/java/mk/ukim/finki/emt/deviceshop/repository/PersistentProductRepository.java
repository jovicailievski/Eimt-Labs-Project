package mk.ukim.finki.emt.deviceshop.repository;

import mk.ukim.finki.emt.deviceshop.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface PersistentProductRepository extends CrudRepository<Product,Long> {
}
