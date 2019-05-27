package mk.ukim.finki.emt.deviceshop.service.impl;


import mk.ukim.finki.emt.deviceshop.repository.PersistentAccessoryRepository;
import mk.ukim.finki.emt.deviceshop.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessoryServiceImpl implements AccessoryService{

    @Autowired
    private PersistentAccessoryRepository accessoryRepository;


}
