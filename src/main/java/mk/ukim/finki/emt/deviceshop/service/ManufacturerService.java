package mk.ukim.finki.emt.deviceshop.service;

import mk.ukim.finki.emt.deviceshop.models.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    Manufacturer getManufacturerById(Long manufacturerId);

    List<Manufacturer> getAllManufacturers();
}
