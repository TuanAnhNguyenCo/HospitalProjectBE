package com.example.hospital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(catalog = "hospital",name = "Role")
public class Role {
    @Column(name = "Id",insertable = false,updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",length = 15)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Collection<Account> accounts = new ArrayList<>();
}
