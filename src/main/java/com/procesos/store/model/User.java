package com.procesos.store.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Nombre de usuario es requerido")
    @Size(max = 255)
    private String firstName;
    private String lastName;
    @NotNull(message = "Campo requerido")
    @Size(min = 5, max = 15)
    private String document;
    private String phone;
    @NotNull(message = "Este valor no puede ser nulo")
    @Email
    private String email;
    @NotNull(message = "este campo no puede estar vacio")
    @Size(min = 8)
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference   // Add this annotation to prevent recursion
    List<Address> addressList;

}
