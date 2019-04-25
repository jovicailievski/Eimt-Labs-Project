package mk.ukim.finki.emt.deviceshop.repository;

import mk.ukim.finki.emt.deviceshop.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Calendar;

public interface PersistentCategoryRepository extends CrudRepository<Category,Long> {
}
