package com.procesos.store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Street address is required")
    @Max(value = 255, message = "Street addres max 255 characters")
    private String streetAddress ;
    @NotNull
    private String city ;
    private String state;
    @NotNull
    @Max(10)
    private String postalCode;
    private Boolean status = Boolean.TRUE;

    @ManyToOne()
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

}
