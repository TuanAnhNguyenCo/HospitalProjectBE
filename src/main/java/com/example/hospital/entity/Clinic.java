package com.example.hospital.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(catalog = "hospital",name = "Clinic")
public class Clinic {
    @Column(name = "Id",insertable = false,updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",length = 100,nullable = false)
    private String name;

    @Column(name = "address",length = 1000,nullable = false)
    private String address;


    @ManyToMany(mappedBy = "clinics")
    private Collection<Account> accounts = new ArrayList<>();
}
