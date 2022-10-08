package com.example.hospital.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(catalog = "hospital",name = "ClinicHistory")
public class ClinicHistory {
    @Column(name = "Id",insertable = false,updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "day",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date day;

    @Column(name = "current_ordinal_number",insertable = false)
    private int currentOrdinalNumber;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;


}
