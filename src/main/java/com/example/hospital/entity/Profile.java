package com.example.hospital.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(catalog = "hospital",name = "Profile")
public class Profile {
    @Column(name = "Id",insertable = false,updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name",length = 25,nullable = false)
    private String firstName;

    @Column(name = "last_name",length = 25,nullable = false)
    private String lastName;

    @Column(name = "citizen_identication",length = 12,nullable = false)
    private String citizenIdentication;

    @Column(name = "phone_number",length = 10,nullable = false)
    private String phoneNumber;

    @Column(name = "address",nullable = false,length = 1000)
    private String address;

    @Column(name = "job",length = 20,nullable = false)
    private String job;

    @Column(name = "email",length = 50,nullable = false)
    private String email;

    @Column(name = "sex",length = 1,nullable = false)
    private char sex;

    @Column(name = "ethnic",length = 20,nullable = false)
    private String ethnic;

//    @Column(name = "date_of_birth",length = 20,nullable = false)
//    private Date date_of_birth;

    @Column(name = "created_at",nullable = false,insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date Created_at;



}
