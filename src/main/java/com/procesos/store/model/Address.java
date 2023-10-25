package com.procesos.store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Street address is required")
    @Size (max = 255, message = "Street addres max 255 characters")
    private String streetAddress ;
    @NotNull
    private String city ;
    private String state;
    @NotNull
    @Size(max = 10)
    private String postalCode;
    private Boolean status = Boolean.TRUE;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @JsonBackReference
    private User user;

}
