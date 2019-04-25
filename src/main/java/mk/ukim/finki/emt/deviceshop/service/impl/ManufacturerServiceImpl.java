package mk.ukim.finki.emt.deviceshop.service.impl;

import mk.ukim.finki.emt.deviceshop.exceptions.ManufacturerNotFoundException;
import mk.ukim.finki.emt.deviceshop.models.Manufacturer;
import mk.ukim.finki.emt.deviceshop.repository.PersistentManufacturerRepository;
import mk.ukim.finki.emt.deviceshop.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private PersistentManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer getManufacturerById(Long manufacturerId) {
        Optional<Manufacturer> man = manufacturerRepository.findById(manufacturerId);
        if(!man.isPresent())
            throw new ManufacturerNotFoundException();

        return man.get();
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        List<Manufacturer> manufacturers = new ArrayList<>();
        manufacturerRepository.findAll().forEach(manufacturers::add);
        return  manufacturers;
    }
}
