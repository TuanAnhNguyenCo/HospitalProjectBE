package com.example.hospital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(catalog = "hospital",name = "Account")
public class Account {
    @Column(name = "Id",insertable = false,updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username",length = 100,unique = true)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password",length = 100)
    private String password;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profileOfUser;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "Account_Role_Relationship",joinColumns = @JoinColumn(name = "account_id")
            ,inverseJoinColumns = @JoinColumn(name = "role_id") )
    private Collection<Role> roles = new ArrayList<>();

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "AccountClinicRelationship",joinColumns = @JoinColumn(name = "account_id")
            ,inverseJoinColumns = @JoinColumn(name = "clinic_id"))

    @JsonIgnore
    private Collection<Clinic> clinics = new ArrayList<>();


}
