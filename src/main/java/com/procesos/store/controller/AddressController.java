package com.procesos.store.controller;

import com.procesos.store.model.Address;
import com.procesos.store.model.User;
import com.procesos.store.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("address/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getAddressById(id));
    };

    @PostMapping("address/{id}")
    public ResponseEntity<Address>  Create(@Valid @RequestBody Address address,@PathVariable Long id){
        return new ResponseEntity<>(addressService.createAddress(address, id), HttpStatus.CREATED);

    }

    @GetMapping("address/disable/{id}")
    public ResponseEntity<Address>  disable(@Valid @PathVariable Long id){
        return new ResponseEntity<>(addressService.updateStatusAddress(id), HttpStatus.OK);
    }


    @GetMapping("address")
    public ResponseEntity<List<Address>> findAll(){
        return ResponseEntity.ok(addressService.findAllAddress());
    }
}
