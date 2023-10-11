package com.procesos.store.service;

import com.procesos.store.model.Address;
import com.procesos.store.model.User;
import com.procesos.store.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserService userService;

    public Address createAddress(Address address, Long id){
        User user = userService.getUserById(id);
        if (user != null){
            throw new RuntimeException("User not found");
        }
        address.setUser(user);
        return addressRepository.save(address);
    }

    public Address getAddressById(Long id){
        Optional<Address> address = addressRepository.findById(id);
        if (address.isEmpty()){

            throw new RuntimeException("Address not found");
        }
        return  address.get();
    }

    public Address updateStatusAddress(Long id){
        Optional<Address> address = addressRepository.findById(id);
        if (address.isEmpty()){

            throw new RuntimeException("Address not found");
        }
        address.get().setStatus(Boolean.FALSE);
        return addressRepository.save(address.get());
    }

    public List<Address> findAllAddress(){
        return (List<Address>) addressRepository.findAll();
    }
}
