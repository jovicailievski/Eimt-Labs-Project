package mk.ukim.finki.emt.deviceshop.repository;

import mk.ukim.finki.emt.deviceshop.models.Accessory;
import org.springframework.data.repository.CrudRepository;

public interface PersistentAccessoryRepository extends CrudRepository<Accessory,Long> {
}
