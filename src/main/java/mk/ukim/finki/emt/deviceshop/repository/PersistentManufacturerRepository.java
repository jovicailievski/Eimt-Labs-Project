package mk.ukim.finki.emt.deviceshop.repository;

import mk.ukim.finki.emt.deviceshop.models.Manufacturer;
import org.springframework.data.repository.CrudRepository;

public interface PersistentManufacturerRepository extends CrudRepository<Manufacturer,Long> {
}
