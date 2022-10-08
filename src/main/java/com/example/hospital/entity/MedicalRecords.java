package com.example.hospital.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(catalog = "hospital",name = "MedicalRecords")
public class MedicalRecords {
    @Column(name = "Id",updatable = false)
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Column(name = "name",length = 1000)
    private String name;

    @Column(name = "created_at",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "end_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date endAt;

    @Column(name = "ordinal_number")
    private int ordinalNumber;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @Column(name = "health_insurance")
    private boolean healthInsurance;

    @Column(name = "payment_status")
    private boolean paymentStatus;

    @Column(name = "verify_status")
    private boolean verifyStatus;


}
